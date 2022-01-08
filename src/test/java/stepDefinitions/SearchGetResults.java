package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
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
import pojos.SearchGetEntityResults.SearchGetEntityResults;
import resources.ConfigReader;
import resources.Util;
import validators.SearchGetEntityResults.SearchGetEntityResultsValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SearchGetResults extends Util {


    @Then("search get results api response must be validated")
    public void search_get_results_api_response_must_be_validated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        SearchGetEntityResults result = mapper.readValue(GenericSteps.resp.asString(), SearchGetEntityResults.class);
        SoftAssert sa = new SoftAssert();
        new SearchGetEntityResultsValidator().validate(result, sa);
        sa.assertAll();
    }
}
