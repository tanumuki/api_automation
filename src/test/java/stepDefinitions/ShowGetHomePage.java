package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.ShowGetHome;
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
import validators.showGetHome.ShowGetHomeValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ShowGetHomePage extends Util {


    @Then("shows get homepage API response is validated")
    public void shows_get_homepage_API_response_is_validated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        ShowGetHome showHomePage = mapper.readValue(GenericSteps.resp.asString(), ShowGetHome.class);
//        System.out.println("showHomePage: " + showHomePage == null);
        SoftAssert sa = new SoftAssert();
        new ShowGetHomeValidator().validate(showHomePage, sa);
        sa.assertAll();
    }

}
