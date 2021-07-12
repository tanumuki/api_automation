package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import cookieManager.GetCookies;
import endPoints.APIResources;
import enums.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.asserts.SoftAssert;
import pojos.browseGetAll.BrowseGetAllPojo;
import resources.ConfigReader;
import resources.Util;
import validators.BrowseGetAll.BrowseGetAllValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class BrowseGetAll extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    String cookie = "";

    @Then("Browse get all api should return with status code {string}")
    public void browse_get_all_api_should_return_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(GenericSteps.resp.getStatusCode(), resource);
    }

    @Then("Browse get all response must be validated successfully")
    public void browse_get_all_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        BrowseGetAllPojo br = mapper.readValue(GenericSteps.resp.asString(), BrowseGetAllPojo.class);
        SoftAssert sa  = new SoftAssert();
        new BrowseGetAllValidator().validate(br, sa);
        sa.assertAll();
    }

}
