package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import endPoints.APIResources;
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
import enums.StatusCode;

public class Radio extends Util {
	

	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;
	String resource ; 
	static String stationId ="";
	public ScenarioContext scenarioContext;

	@Given("Add payload with endpoint {string}")
	public void add_payload_with_endpoint(String endPoint) throws IOException {

		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));

	}

	@When("User calls GET method with below params")
	public void user_calls_GET_method_with_below_params(io.cucumber.datatable.DataTable table) {
		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();		
		
			// code to handle Data Table
				List<Map<String,String>> data = table.asMaps();
				System.out.println("data" +data.get(0));
				String method= data.get(0).get("method");				

		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {

			if(resource.equals("webradio.createArtistStation")){
				res.queryParam("query",data.get(0).get("query") );
				res.queryParam("name",data.get(0).get("name") );
				resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
			}
			
			if(resource.equals("webradio.getSong")){
				res.queryParam("next",data.get(0).get("next") );
				res.queryParam("stationid", stationId);
				resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
			}

		}
	}

	@Then("The Radio API returns station ID with status code {string}")
	public void the_Radio_API_returns_station_ID_with_status_code(String statusCode) {
		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		System.out.println("the code is  " + resource);
		Radio.stationId = resp.jsonPath().get("stationid");
		System.out.println("sta id is "+stationId);
		System.out.println("the response is  " + resp.body().asString());
		System.out.println("the response TIME is  " + resp.getTime());

		assertEquals(resp.getStatusCode(), resource);	
		}
	
	
	
	

}
