package stepDefinitions;

import static org.testng.Assert.assertEquals;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.Context;
import entities.Playlist;
import entities.PlaylistContainer;
import enums.StatusCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.asserts.SoftAssert;
import resources.APIConstants;
import resources.Util;
import validators.PlaylistOpsValidator;
import validators.Validate;

@Slf4j
public class PlaylistOps extends Util {

	Response resp;
	String listID;

	@When("User calls method with below params for playlistOps")
	public void user_calls_method_with_below_params_for_playlistOps(io.cucumber.datatable.DataTable table) {
		List<Map<String, String>> data = table.asMaps();
		log.info("data" + data.get(0));
		String method = data.get(0).get("method");
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		log.info(generatedString);

		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
			GenericSteps.request.queryParam("listname", generatedString);
			GenericSteps.request.queryParam("contents", data.get(0).get("contents"));
			GenericSteps.request.queryParam("share", data.get(0).get("share"));
		}

		resp = GenericSteps.request.given()
				.log()
				.all()
				.when()
				.get("/api.php")
				.then()
				.log()
				.all()
				.extract()
				.response();
		log.info(resp.asString());
	}

	@Then("User validates the status code {string}")
	public void userValidatesTheStatusCode(String statusCode) {
		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		assertEquals(resp.getStatusCode(), resource);
		log.info("The status is "+ resp.getStatusCode());
	}

	@And("User validates the response of the newly created playlist")
	public void userValidatesTheResponseOfTheNewlyCreatedPlaylist() throws JsonProcessingException {
		SoftAssert sa = new SoftAssert();
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		PlaylistContainer playlist = mapper.readValue(resp.asString(), PlaylistContainer.class);
		new PlaylistOpsValidator().validate(playlist, sa);
		listID = playlist.getDetails().getId();
		testContext.scenarioContext.setContext(Context.PLAYLIST_ID,listID);
		log.info(this.listID);

	}

	@When("User calls {string} method with param listID of the created playlist")
	public void userCallsMethodWithParamListIDOfTheCreatedPlaylist(String method) {
//
		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
			listID = (String) testContext.scenarioContext.getContext(Context.PLAYLIST_ID);
			log.info("List ID: "+listID);
			GenericSteps.request.queryParam("listid", listID);
		}

		resp = GenericSteps.request.given()
				.log()
				.all()
				.when()
				.get("/api.php")
				.then()
				.log()
				.all()
				.extract()
				.response();
		log.info(resp.asString());
	}

	@Then("Playlist Delete API returns success with status code {string} and response is validated")
	public void playlistDeleteAPIReturnsSuccessWithStatusCode(String statusCode) throws JsonProcessingException {
		userValidatesTheStatusCode(statusCode);
		SoftAssert sa = new SoftAssert();
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		PlaylistContainer playlist = mapper.readValue(resp.asString(), PlaylistContainer.class);
		if(Validate.isNonEmptyString(playlist.getStatus()))
			sa.assertTrue(Validate.asStatusMessage(playlist.getStatus()));
		log.info("Validation done for status "+playlist.getStatus()+"after deleting a playlist.");

	}

	@And("I make the {string} request with the following query parameters with deleted listID")
	public void iMakeTheRequestWithTheFollowingQueryParametersWithDeletedListID(String method) {
		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
			listID = (String) testContext.scenarioContext.getContext(Context.PLAYLIST_ID);
			log.info("List ID: "+listID);
			GenericSteps.request.queryParam("listid", listID);
		}

		resp = GenericSteps.request.given()
				.log()
				.all()
				.when()
				.get("/api.php")
				.then()
				.log()
				.all()
				.extract()
				.response();
		log.info(resp.asString());
	}

	@Then("I verify that there is no such playlist after deletion and status code is {string}")
	public void iVerifyThatThereIsNoSuchPlaylistAfterDeletionAndStatusCodeIs(String statusCode) throws JsonProcessingException {
		userValidatesTheStatusCode(statusCode);
		SoftAssert sa = new SoftAssert();
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		Playlist playlist = mapper.readValue(resp.asString(), Playlist.class);
		new PlaylistOpsValidator().validatePlaylistDeletion(playlist, sa);

	}
}
