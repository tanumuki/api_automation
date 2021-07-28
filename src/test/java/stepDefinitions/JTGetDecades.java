package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.PlaylistMini;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.JiotuneHomePageData.JTGetDecadesPojo;
import resources.Util;
import validators.AssertionMsg;
import validators.PlaylistMiniValidator;
import validators.Validate;

@Slf4j
public class JTGetDecades extends Util {

    @Then("I validate the response of API call")
    public void iValidateTheResponseOfAPICall() throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        JTGetDecadesPojo jtGetDecadesPojo = objectMapper.readValue(GenericSteps.resp.asString(), JTGetDecadesPojo.class);

//        Verifying last_page and list of objects as PlaylistMini Objects
        sa.assertTrue(Validate.asBoolean(jtGetDecadesPojo.getLastPage()));
        log.info((jtGetDecadesPojo.getLastPage()) + " that it is the last page.");

        if (jtGetDecadesPojo.getData().size() > 0) {
            for (PlaylistMini playlistMini : jtGetDecadesPojo.getData()) {
                new PlaylistMiniValidator().validate(playlistMini, sa);
            }
        }
        log.info("Playlistmini objects are validated: "+ jtGetDecadesPojo.getData());
        sa.assertAll();
    }
}
