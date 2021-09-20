package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.Artist;
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
import pojos.searchTabHomePage.SearchTabHomePage;
import resources.ConfigReader;
import resources.Util;
import validators.SearchTabHomePage.SearchTabHomeValidator;
import validators.genericValidators.ArtistMapValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SearchTabGetHome extends Util {


    @Then("Search grid home page api response must be validated successfully")
    public void search_grid_home_page_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        SearchTabHomePage result = mapper.readValue(GenericSteps.resp.asString(), SearchTabHomePage.class);
        SoftAssert sa = new SoftAssert();
        new SearchTabHomeValidator().validate(result, sa);
        sa.assertAll();
    }
}
