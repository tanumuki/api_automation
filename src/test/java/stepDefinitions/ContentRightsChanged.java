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
import pojos.SubsContentRightsChanged.ContentRightsChange;
import resources.ConfigReader;
import resources.Util;
import validators.SearchGetEntityResults.SearchGetEntityResultsValidator;
import validators.SubsContentRIghtsChanged.ContentRightsChangeValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ContentRightsChanged extends Util {

    @Then("get content rights api response must be validated successfully")
    public void get_content_rights_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        ContentRightsChange result = mapper.readValue(GenericSteps.resp.asString(), ContentRightsChange.class);
        SoftAssert sa = new SoftAssert();
        new ContentRightsChangeValidator().validate(result, sa);
        sa.assertAll();
    }
}
