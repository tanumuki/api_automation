package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Playlist;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import resources.Util;
import validators.genericValidators.PlaylistValidator;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/**
 * @author ashwinsriv
 *
 */
public class SurpriseMePlaylist extends Util {

    @Then("User should see the SurpriseMe response validated")
    public void user_should_see_the_surprise_me_response_validated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Playlist plObj = mapper.readValue(GenericSteps.resp.asString(), Playlist.class);
        SoftAssert sa = new SoftAssert();
        String listSize = GenericSteps.params.get(0).get("count");


//      Surprise Me playlist specific validations
//      Validate name
        sa.assertTrue(plObj.getTitle().equalsIgnoreCase("surprise+me"),
                "The requested playlist ID: " + plObj.getId() + " is not a Surprise Me playlist.");
//      Validate list_count
        sa.assertTrue(plObj.getListCount().equalsIgnoreCase((listSize)),
                "Expected listcount: " + listSize + ", but found: " + plObj.getListCount());

        new PlaylistValidator().validate(plObj, sa);
        sa.assertAll();
    }

}
