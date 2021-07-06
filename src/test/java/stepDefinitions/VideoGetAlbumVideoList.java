package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.videoGetAlbumVideoList.GetAlbumVideoList;
import validators.VideoValidator.VideoGetAlbumListValidator;
import validators.VideoValidator.VideoGetDetailsValidator;

public class VideoGetAlbumVideoList {





    @Then("The AlbumVideoList API returns {string} with status code {int}")
    public void theAlbumVideoListAPIReturnsWithStatusCode(String expectedStatus, int expectedStatusCode) {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for user update API");
        Assert.assertEquals(expectedStatus, GenericSteps.resp.jsonPath().get("status"), "Status validation failed for user update API");
        sa.assertAll();

    }

    @And("Validate the videoList response")
    public void validateTheVideoListResponse() throws JsonProcessingException {

        SoftAssert sa = new SoftAssert();

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

       // pojos.videoGetDetails.VideoGetDetails videoDetailsObject= mapper.readValue(GenericSteps.resp.asString(), pojos.videoGetDetails.VideoGetDetails.class);
        GetAlbumVideoList videoListObject = mapper.readValue(GenericSteps.resp.asString(), GetAlbumVideoList.class);

        new VideoGetAlbumListValidator().validate(videoListObject,sa);

        sa.assertAll();
    }
}