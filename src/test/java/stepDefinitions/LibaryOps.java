package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import endPoints.APIResources;
import entities.Album;
import entities.AlbumMiniObject;
import entities.AlbumReco;
import entities.AssortedEntities;
import enums.StatusCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.libraryOps.LibraryData;
import pojos.libraryOps.LibraryEntities;
import resources.APIConstants;
import resources.ConfigReader;
import resources.UserGenerator;
import resources.Util;
import validators.LibraryValidator;
import validators.Validate;
import validators.genericValidators.AlbumMiniValidator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static org.testng.Assert.assertEquals;


@Slf4j
public class LibaryOps extends Util {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;
	String cookie = "";
	String resource;
	String seed_song_id = "";
	String seed_album_id = "";
	Album albumDataInLibrary ;
	String albumResponse="";
	String entity_type;

	@Given("Add payload with get library endpoint {string} and account credentials for cookie")
	public void add_payload_with_get_library_endpoint_and_account_credentials_for_cookie(String endPoint)
			throws Exception {

		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		UserGenerator user = UserGenerator.getInstance();
		HashMap<String, String> userMap = user.generateNewUserCookie();
		cookie = userMap.get("cookie");
		System.setProperty("cookie", cookie);
		res = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
		log.info("MYCOOKIE1 " + cookie);

	}

	@When("User calls method with below params")
	public void user_calls_method_with_below_params(io.cucumber.datatable.DataTable table) {
		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();
		// code to handle Data Table
		List<Map<String, String>> data = table.asMaps();
		System.out.println("data" + data.get(0));
		String method = data.get(0).get("method");

		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {

			res.queryParam("n", data.get(0).get("n"));
			res.queryParam("p", data.get(0).get("p"));
			resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
		}

		resp = res.given().log().all().when().get("/api.php").then().log().all().spec(resspec).extract().response();

	}

	@Then("The Library API returns success with status code {string}")
	public void the_Library_API_returns_success_with_status_code(String statusCode) {

		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		System.out.println("the code is  " + resource);
		System.out.println("cookie in response " + resp.getHeaders());
		System.out.println("the response is  " + resp.body().asString());

		assertEquals(resp.getStatusCode(), resource);
	}

	@And("Validate the library data for new user")
	public void validate_the_library_data_for_new_user() throws JsonMappingException, JsonProcessingException {
		SoftAssert sa = new SoftAssert();

		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				true);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		LibraryData library = objectMapper.readValue(resp.asString(), LibraryData.class);
		new LibraryValidator().validateForNewUSer(library, sa);
		sa.assertAll();

	}

	@Given("Add payload with get library endpoint {string}")
	public void add_payload_with_get_library_endpoint(String endPoint) throws IOException {

		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));

	}

	@When("User calls method with album id as param")
	public void user_calls_method_with_album_id_as_param(io.cucumber.datatable.DataTable table) throws JsonMappingException, JsonProcessingException {
		
		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();
		// code to handle Data Table
		List<Map<String, String>> data = table.asMaps();
		System.out.println("data" + data.get(0));
		String method = data.get(0).get("method");

		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {

			res.queryParam("albumid", data.get(0).get("albumid"));
			resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
		}

		resp = res.given().log().all().when().get("/api.php").then().log().all().spec(resspec).extract().response();
		 albumResponse = resp.asString();
		System.setProperty("albumResponse", albumResponse);
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				true);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		 albumDataInLibrary = objectMapper.readValue(resp.asString(), Album.class);
		
		
	}
	
	
	
	

	@Given("Add payload with add library endpoint {string} with the same account credentials")
	public void add_payload_with_add_library_endpoint_with_the_same_account_credentials(String endPoint)
			throws Exception {

		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		cookie = System.getProperty("cookie");
		log.info("MYCOOKIE2 " + cookie);
		res = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));

	}

	@When("User calls {string} method with below param with {string} and entity_type as {string}")
	public void user_calls_method_with_below_param_with_and_entity_type_as(String method, String entity_ids,
			String entity_type) {

		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF8")).build();

		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
			res.queryParam("entity_ids", entity_ids);
			res.queryParam("entity_type", entity_type);
			if (entity_type.equals("song")) {
				seed_song_id = entity_ids;
				System.setProperty("seed_song_id", seed_song_id);
				log.info(seed_song_id);
			} else if (entity_type.equals("album")) {
				seed_album_id = entity_ids;
				System.setProperty("seed_album_id", seed_album_id);
				log.info(seed_album_id);
			}
			resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
		}
	}

	@Given("Validate the library data by calling endpoint {string} using same cookie")
	public void validate_the_library_data_by_calling_endpoint_using_same_cookie(String endPoint) throws IOException {

		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		cookie = System.getProperty("cookie");
		res = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
	}

	@And("Verify if the added song is present in the response")
	public void verify_if_the_added_song_is_present_in_the_response()
			throws JsonMappingException, JsonProcessingException {

		SoftAssert sa = new SoftAssert();
		albumResponse = System.getProperty("albumResponse");
		seed_album_id =System.getProperty("seed_album_id");
		seed_song_id =System.getProperty("seed_song_id");
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				true);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		LibraryData library = objectMapper.readValue(resp.asString(), LibraryData.class);
		new LibraryValidator().validateLibraryForUserWithUpdatedData(library, sa, seed_album_id, seed_song_id, albumResponse);
		sa.assertAll();

	}
	
	@Given("Validate the library data by calling library delete endpoint {string} using same cookie")
	public void validate_the_library_data_by_calling_library_delete_endpoint_using_same_cookie(String endPoint) throws FileNotFoundException {
		
		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		System.out.println("resource api " + resourceAPI.getResource());
		cookie = System.getProperty("cookie");
		log.info("Cookie for library delete API " + cookie);
		res = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
		
	}
	
	
	@Then("Verify if the song and album are not present in the response")
	public void verify_if_the_song_and_album_are_not_present_in_the_response() throws JsonMappingException, JsonProcessingException {
		SoftAssert sa = new SoftAssert();
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				true);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		LibraryData library = objectMapper.readValue(resp.asString(), LibraryData.class);
		new LibraryValidator().validateForUSerAfterDeletionOfLibraryData(library, sa);
		sa.assertAll();
		
	}

	@When("User calls the method {string} below params {string}, {string}, {string} and {string}")
	public void userCallsTheMethodBelowParams(String method, String entity_ids, String entity_type, String n, String p) {
		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF8")).build();
		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
			GenericSteps.request.queryParam("entity_ids", entity_ids);
			GenericSteps.request.queryParam("entity_type", entity_type);
			GenericSteps.request.queryParam("n", n);
			GenericSteps.request.queryParam("p", p);
			resp = GenericSteps.request.when().get("/api.php").then().log().all().spec(resspec).extract().response();
			System.out.println(resp.asString());
		}
		this.entity_type = entity_type;

	}

	@Then("User validates {string} status code")
	public void userValidatesStatusCode(String statusCode) {
		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		assertEquals(resp.getStatusCode(), resource);
	}


	@And("Validate the library details for the user against the params")
	public void validateTheLibraryDetailsForTheUserAgainstTheParams() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		LibraryData libraryData = mapper.readValue(resp.asString(), LibraryData.class);
		SoftAssert sa = new SoftAssert();
		if(!entity_type.equals("song")) {
			sa.assertTrue(libraryData.getStatus().equalsIgnoreCase(Validate.API_STATUS_SUCCESS),
					"Expected \"" + Validate.API_STATUS_SUCCESS + "\", but found: \"" + libraryData.getStatus() + "\"");
		}
		log.info("Validated for the following entity "+ this.entity_type);
		AssortedEntities.readAndValidateAssortedEntityForLibraryDetails(this.entity_type, resp, sa);
		sa.assertAll();
	}
}
