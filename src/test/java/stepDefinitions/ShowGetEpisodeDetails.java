package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.EpisodeDetails;
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
import validators.genericValidators.EpisodeDetailsValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ShowGetEpisodeDetails extends Util {

    @Then("Get episode details api response is validated successfully")
    public void get_episode_details_api_response_is_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        EpisodeDetails episodeDetails = mapper.readValue(GenericSteps.resp.asString(), EpisodeDetails.class);
        SoftAssert sa = new SoftAssert();
        new EpisodeDetailsValidator().validate(episodeDetails, sa);
        sa.assertAll();
    }
}
