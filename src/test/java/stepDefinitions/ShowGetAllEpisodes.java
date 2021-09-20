package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import endPoints.APIResources;
import entities.Episode;
import entities.EpisodeContainer;
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
import validators.Validate;
import validators.genericValidators.EpisodeValidator;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ShowGetAllEpisodes extends Util {


    @Then("Get all episodes api response must be valided successfully")
    public void get_all_episodes_api_response_must_be_valided_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        TypeFactory typeFactory = mapper.getTypeFactory();
        SoftAssert sa = new SoftAssert();
        if (ConfigReader.getInstance().getCtx().equalsIgnoreCase("androidgo"))
        {
            List<Episode> episodes = mapper.readValue(GenericSteps.resp.asString(), new TypeReference<List<Episode>>() {
            });
            for (Episode episode : episodes) {
                new EpisodeValidator().validate(episode, sa);
            }
        }
        else {
            EpisodeContainer episodes = mapper.readValue(GenericSteps.resp.asString(), EpisodeContainer.class);

//        Validators
            sa.assertTrue(episodes.getStatus().equalsIgnoreCase(Validate.API_STATUS_SUCCESS),
                    "Expected \"" + Validate.API_STATUS_SUCCESS + "\", but found: \"" + episodes.getStatus() + "\"");
            for (Episode episode : episodes.getData()) {
                new EpisodeValidator().validate(episode, sa);
            }
        }
        sa.assertAll();
    }
}
