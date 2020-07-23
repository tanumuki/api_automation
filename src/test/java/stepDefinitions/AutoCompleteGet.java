/**
 * 
 */
package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.asserts.SoftAssert;
import pojos.search.SearchResponse;
import resources.ConfigReader;
import resources.Util;
import validators.SearchResponseValidator;

import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * @author aswingokulachandran
 *
 */
public class AutoCompleteGet extends Util {

	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Response resp;

	@Given("Add payload with search endpoint {string}")
	public void add_payload_with_search_endpoint(String endpoint) throws IOException {
		APIResources resourceAPI = APIResources.valueOf(endpoint);
		String resource = resourceAPI.getResource();
		System.out.println("resource api " + resourceAPI.getResource());
		reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
	}

	@When("User calls {string} https request for queries in {string}")
	public void user_calls_https_request_for_queries_in_file(String method, String query) throws FileNotFoundException {
		resSpec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
		if (method.equalsIgnoreCase("GET")) {
			reqSpec.queryParam("query", query);
			System.out.println("resSpec: " + resSpec.toString());
			resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
			System.out.println("Aswin response: " + resp.asString());

		}

		logResponseTime(resp);
	}

	@Then("Api should return response with status code {string}")
	public void api_should_return_response_with_status_code(String statusCode) {
		assertEquals(resp.getStatusCode(), Integer.parseInt(statusCode));
//		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
	}

	@Then("I should see response with JSON validation")
	public void i_should_see_response_with_JSON_validation() throws JsonMappingException, JsonProcessingException {
		System.out.println("i_should_see_response_with_JSON_validation");
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		SearchResponse responseObj = mapper.readValue(resp.asString(), SearchResponse.class);
		new SearchResponseValidator().validate(responseObj, new SoftAssert());
	}

}
