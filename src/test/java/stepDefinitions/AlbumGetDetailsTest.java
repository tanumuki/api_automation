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
import enums.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.asserts.SoftAssert;
import resources.ConfigReader;
import resources.Util;
import validators.genericValidators.AlbumValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * @author aswingokulachandran
 *
 */
public class AlbumGetDetailsTest extends Util {

	@Then("User should see the response validated")
	public void user_should_see_the_response_validated() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		AlbumWithSongsList albumObj = mapper.readValue(GenericSteps.resp.asString(), AlbumWithSongsList.class);
		SoftAssert sa = new SoftAssert();
		new AlbumValidator().validate(albumObj, sa);
		sa.assertAll();
	}

}
