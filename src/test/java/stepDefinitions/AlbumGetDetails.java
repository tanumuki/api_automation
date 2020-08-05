/**
 * 
 */
package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import endPoints.APIResources;
import entities.Album;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ConfigReader;
import resources.Util;
import statusCodes.StatusCode;
import validators.genericValidators.AlbumValidator;

/**
 * @author aswingokulachandran
 *
 */
public class AlbumGetDetails extends Util {

	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Response resp;

	@Given("Payload with endPoint {string}")
	public void payload_with_end_point(String endpoint) throws IOException {
		APIResources resourceAPI = APIResources.valueOf(endpoint);
		String resource = resourceAPI.getResource();
		System.out.println("resource: " + resource);
		reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
	}

	@When("User calls https request with {string}")
	public void user_calls_https_request_with(String albumid) {
		resSpec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
		reqSpec.queryParam("albumid", albumid);
		System.out.println("resSpec: " + resSpec.toString());
		resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
		System.out.println("Aswin response: " + resp.asString());

		logResponseTime(resp);

	}

	@Then("User should get response with status code {string}")
	public void user_should_get_response_with_status_code(String statusCode) {
		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		assertEquals(resp.getStatusCode(), resource);
	}

	@Then("User should see the response validated")
	public void user_should_see_the_response_validated() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		Album albumObj = mapper.readValue(resp.asString(), Album.class);
		SoftAssert sa = new SoftAssert();
		new AlbumValidator().validate(albumObj, sa);
		sa.assertAll();
	}

}
