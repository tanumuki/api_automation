package stepDefinitions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;
import pojos.JiotunepageCallerTune.ArtistCallerTuneContainer;
import resources.Util;
import validators.JiotunepageCallerTunes.JiotunepageArtistCallerTuneHomeValidator;

import java.io.IOException;


public class JiotunepageArtistCallerTuneHome extends Util {

    @And("Response should be validated against the parameters")
    public void responseShouldBeValidatedAgainstTheParameters() throws IOException {
        SoftAssert sa = new SoftAssert();
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        ArtistCallerTuneContainer artistCallerTuneContainer = objectMapper.readValue(GenericSteps.resp.asString(),ArtistCallerTuneContainer.class);
        System.out.println(GenericSteps.resp.asString());
        new JiotunepageArtistCallerTuneHomeValidator().validate(GenericSteps.resp, artistCallerTuneContainer, sa);
        sa.assertAll();
    }
}
