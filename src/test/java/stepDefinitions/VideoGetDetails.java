package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import resources.Util;
import validators.VideoValidator.VideoGetDetailsValidator;

@Slf4j
public class VideoGetDetails extends Util {


    @Then("The video API returns {string} with status code {int}")
    public void the_video_api_returns_success_with_status_code(String expectedStatus, int expectedStatusCode) {

        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for user update API");
        Assert.assertEquals(expectedStatus, GenericSteps.resp.jsonPath().get("status"), "Status validation failed for user update API");
        sa.assertAll();
    }

    @Then("Validate the video response")
    public void validate_the_video_response() throws JsonProcessingException {
       log.info( " Validating video response");
        SoftAssert sa = new SoftAssert();

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        pojos.videoGetDetails.VideoGetDetails videoDetailsObject= mapper.readValue(GenericSteps.resp.asString(), pojos.videoGetDetails.VideoGetDetails.class);
        new VideoGetDetailsValidator().validate(videoDetailsObject, sa);

        sa.assertAll();

    }







}
