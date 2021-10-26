/**
 * 
 */
package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.AlbumWithSongsList;
import entities.Playlist;
import entities.WebAPIPlaylist;
import enums.StatusCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import resources.ConfigReader;
import resources.Util;
import validators.WebAPI.WebApiGetValidator;
import validators.genericValidators.AlbumValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * @author snigdhamajee
 *
 */

@Slf4j
public class WebApiGet extends Util {

	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Response resp;

	@Given("Payload with endPoint {string} with given {string}")
	public void payloadWithEndPointWithGivenCTX(String endPoint, String ctx) throws IOException {
		APIResources resourceAPI = APIResources.valueOf(endPoint);
		String resource = resourceAPI.getResource();
		log.info("resource: " + resource);
		reqSpec = given().spec(requestSpecification(ctx, resource));
	}

	@When("User calls https request with {string}, {string}, {string} and {string}")
	public void userCallsHttpsRequestWithQueryParams(String token, String type, String n, String p) {
		resSpec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
		reqSpec.queryParam("token", token);
		reqSpec.queryParam("type", type);
		reqSpec.queryParam("n", n);
		reqSpec.queryParam("p", p);
		log.info("resSpec: " + resSpec.toString());
		resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
		log.info(resp.asString());
		logResponseTime(resp);
	}

	@Then("The response should be validated with status code {string}")
	public void user_should_get_response_with_status_code(String statusCode) {
		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		assertEquals(resp.getStatusCode(), resource);
	}


	@And("The response should be validated for all the fields")
	public void theResponseShouldBeValidatedForTheFields() throws JsonProcessingException {
		SoftAssert sa = new SoftAssert();
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		WebAPIPlaylist playlist = mapper.readValue(resp.asString(), WebAPIPlaylist.class);
		new WebApiGetValidator().validate(playlist, sa);
		log.info("Validation done for webapi.get");
	}
}
