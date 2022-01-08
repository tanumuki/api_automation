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
import resources.ConfigReader;
import resources.Util;
import validators.genericValidators.ArtistMapValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SearchGetArtistResults extends Util {


    @Then("Get artist results api response must be validated successfully")
    public void get_artist_results_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.search.SearchGetArtistResults result = mapper.readValue(GenericSteps.resp.asString(), pojos.search.SearchGetArtistResults.class);
        SoftAssert sa = new SoftAssert();
        for(Artist artist : result.getResults()) {
            new ArtistMapValidator().validate(artist, sa, "artist", "artist", artist.getId());
        }
        sa.assertAll();
    }

}
