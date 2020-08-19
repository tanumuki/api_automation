package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import endPoints.APIResources;
import entities.Song;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIConstants;
import resources.ConfigReader;
import resources.ScenarioContext;
import resources.Util;
import validators.RadioValidator;
import enums.StatusCode;

public class Radio extends Util {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;
	String resource;
	static String stationId = "";
	public ScenarioContext scenarioContext;

	@Given("Create the artist station with endpoint {string}")
	public void create_the_artist_station_with_endpoint(String endPoint) throws IOException {

		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));

	}

	@When("User calls GET method with below params name and query")
	public void user_calls_GET_method_with_below_params_name_and_query(io.cucumber.datatable.DataTable table) {
		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();

		// code to handle Data Table
		List<Map<String, String>> data = table.asMaps();
		System.out.println("data" + data.get(0));
		String method = data.get(0).get("method");

		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {

			res.queryParam("query", data.get(0).get("query"));
			res.queryParam("name", data.get(0).get("name"));
			resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();

//			
//			if(resource.equals("webradio.getSong")){
//				res.queryParam("next",data.get(0).get("next") );
//				res.queryParam("stationid", stationId);
//				resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
//			}

		}
	}

	@Then("The Radio API returns station ID with status code {string}")
	public void the_Radio_API_returns_station_ID_with_status_code(String statusCode) {
		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		System.out.println("the code is  " + resource);
		System.out.println("the response is  " + resp.body().asString());
		System.out.println("the response TIME is  " + resp.getTime());

		assertEquals(resp.getStatusCode(), resource);
	}

	@Then("Parse the stationId")
	public void parse_the_stationId() {

		stationId = resp.jsonPath().get("stationid");
		System.setProperty("stationid", stationId);
		System.out.println("sta id is " + stationId);
	}

	@Given("Fetch the song by adding payload of {string}")
	public void fetch_the_song_by_adding_payload_of(String endPoint) throws IOException {

		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
	}

	@When("User calls GET method with below param with next =1 and stationid {string}")
	public void user_calls_GET_method_with_below_param_with_next_1_and_stationid(String string,
			io.cucumber.datatable.DataTable table) {

		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();

		// code to handle Data Table
		List<Map<String, String>> data = table.asMaps();
		System.out.println("data" + data.get(0));
		String method = data.get(0).get("method");

		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {

			res.queryParam("next", data.get(0).get("next"));
			res.queryParam("stationid", stationId);
			resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
			
		}

	}

	@Then("Validate the station response")
	public void validate_the_station_response() throws JsonMappingException, JsonProcessingException {

		System.out.println("Radio response" + resp.getBody().asString());
		SoftAssert sa = new SoftAssert();
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				true);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);		
		//pojos.radio.Radio radio = objectMapper.readValue(resp.asString(), Radio.class);
		//new RadioValidator().validateRadio(radio, sa);
		sa.assertAll();
		
		
	}

}
