package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import endPoints.APIResources;
import endPoints.Context;
import entities.Album;
import enums.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import resources.APIConstants;
import resources.ConfigReader;
import resources.ScenarioContext;
import resources.UserGenerator;
import resources.Util;

@Slf4j
public class PlaylistOps extends Util {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;
	String cookie = "";
	String resource;
	String seed_song_id = "";
	String seed_album_id = "";
	Album albumDataInLibrary ;
	String albumResponse="";
	public ScenarioContext scenarioContext;

	@Given("Add payload with get playlist endpoint {string} and account credentials for cookie")
	public void add_payload_with_get_playlist_endpoint_and_account_credentials_for_cookie(String endPoint)
			throws Exception {

		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		UserGenerator user = UserGenerator.getInstance();
		HashMap<String, String> userMap = user.generateNewUserCookie();
		cookie = userMap.get("cookie");
		testContext.scenarioContext.setContext(Context.COOKIE, cookie);
		//System.setProperty("cookie", cookie);
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

			res.queryParam("listname", data.get(0).get("listname"));
			res.queryParam("contents", data.get(0).get("contents"));
			res.queryParam("share", data.get(0).get("share"));
			resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
		}

		resp = res.given().log().all().when().get("/api.php").then().log().all().spec(resspec).extract().response();

	}

	@Then("The Playlist API returns success with status code {string}")
	public void the_Playlist_API_returns_success_with_status_code(String statusCode) {

		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		System.out.println("the code is  " + resource);
		System.out.println("cookie in response " + resp.getHeaders());
		System.out.println("the response is  " + resp.body().asString());

		assertEquals(resp.getStatusCode(), resource);
	}

}
