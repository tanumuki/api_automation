package stepDefinitions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import pojos.JiotunepageCallerTune.ArtistCallerTuneContainer;
import pojos.JiotunepageCallerTune.NameCallerTuneContainer;
import resources.Util;
import validators.JiotunepageCallerTunes.JTPageCallerTuneHomeValidator;

import java.io.IOException;


public class JiotunepageCallerTuneHome extends Util {

    @And("Response should be validated against the parameters")
    public void responseShouldBeValidatedAgainstTheParameters() throws IOException {
        SoftAssert sa = new SoftAssert();
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        ArtistCallerTuneContainer artistCallerTuneContainer = objectMapper.readValue(GenericSteps.resp.asString(), ArtistCallerTuneContainer.class);
        new JTPageCallerTuneHomeValidator().validate(artistCallerTuneContainer, sa);
        sa.assertAll();
    }

    @And("Response should be validated against the parameters for Name Tune Home")
    public void responseShouldBeValidatedAgainstTheParametersforNameTune() throws IOException {
        SoftAssert sa = new SoftAssert();
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        NameCallerTuneContainer nameCallerTuneContainer = objectMapper.readValue(GenericSteps.resp.asString(), NameCallerTuneContainer.class);
        new JTPageCallerTuneHomeValidator().validateNameTune(nameCallerTuneContainer, sa);
        sa.assertAll();
    }
}
