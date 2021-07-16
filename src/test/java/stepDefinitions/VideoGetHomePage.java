package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import resources.Util;

@Slf4j
public class VideoGetHomePage extends Util {



    Response response;

    @Then("The videoGetHomePage API returns status code {int}")
    public void the_video_get_home_page_api_returns_status_code( int statusCode) {

        SoftAssert softAssert= new SoftAssert();
        Assert.assertEquals(statusCode, GenericSteps.resp.getStatusCode());
        softAssert.assertAll();
    }

    @Then("Validate the videoGetHomePage response")
    public void validate_the_video_get_home_page_response() throws JsonProcessingException {

        log.info( " Validating video homepage response");
        SoftAssert sa = new SoftAssert();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);

       pojos.videoGetHomePage.VideoGetHomePage homePage = mapper.readValue(response.asString(), pojos.videoGetHomePage.VideoGetHomePage.class);


    }



}
