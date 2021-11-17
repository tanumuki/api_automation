package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import pojos.getTopShows.TopShowsData;
import resources.Util;
import validators.genericValidators.TopShowsValidator;

public class ContentGetTopShowsTest extends Util {

    @Then("Get top shows api response must be validated successfully")
    public void get_top_shows_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        TopShowsData shows = mapper.readValue(GenericSteps.resp.asString(), TopShowsData.class);
        SoftAssert sa = new SoftAssert();
        new TopShowsValidator().validate(shows, sa);
        sa.assertAll();
    }

}
