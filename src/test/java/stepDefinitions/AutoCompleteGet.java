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

	@Then("I should see response with JSON validation")
	public void i_should_see_response_with_JSON_validation() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		SearchResponse responseObj = mapper.readValue(GenericSteps.resp.asString(), SearchResponse.class);
		new SearchResponseValidator().validate(responseObj, new SoftAssert());
	}

}
