package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import pojos.JiotunepageCallerTune.ArtistCallerTuneContainer;
import pojos.JiotunepageCallerTune.NameCallerTuneContainer;
import resources.Util;
import validators.JiotunepageCallerTunes.JTPageNameCallerTuneHomeValidator;
import validators.JiotunepageCallerTunes.JiotunepageArtistCallerTuneHomeValidator;

import java.io.IOException;


public class JTPageNameCallerTuneHome extends Util {

    @Then("I validate the response of the API")
    public void iValidateTheResponseOfTheAPI() throws IOException {
        SoftAssert sa = new SoftAssert();
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        NameCallerTuneContainer nameCallerTuneContainer = objectMapper.readValue(GenericSteps.resp.asString(),NameCallerTuneContainer.class);
        new JTPageNameCallerTuneHomeValidator().validate(nameCallerTuneContainer, sa);
        sa.assertAll();
    }
}
