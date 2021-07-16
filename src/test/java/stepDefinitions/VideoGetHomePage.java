package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import resources.Util;

public class VideoGetHomePage extends Util {



    @Then("The videoGetHomePage API returns status code {int}")
    public void the_video_get_home_page_api_returns_status_code( int statusCode) {

        SoftAssert softAssert= new SoftAssert();
        Assert.assertEquals(statusCode, GenericSteps.resp.getStatusCode());
        softAssert.assertAll();
    }



}
