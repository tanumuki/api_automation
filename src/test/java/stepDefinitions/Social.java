package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import resources.Util;

public class Social extends Util {

    @Then("The Social Follow API returns {string} with status code {int}")
    public void theSocialFollowAPIReturnsWithStatusCode(String expectedStatus, int expectedStatusCode) {

        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(GenericSteps.resp.getStatusCode(), expectedStatusCode, "Response code validation failed for user update API");
        Assert.assertEquals(GenericSteps.resp.jsonPath().get("status"), expectedStatus, "Status validation failed for user update API");
        sa.assertAll();
    }

    @Then("The Social unfollow API returns {string} with status code {int}")
    public void theSocialUnfollowAPIReturnsWithStatusCode(String expectedStatus, int expectedStatusCode) {

        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for user update API");
        Assert.assertEquals(expectedStatus, GenericSteps.resp.jsonPath().get("status"), "Status validation failed for user update API");
        sa.assertAll();
    }

    @And("An error message {string} is returned with error code {int}")
    public void anErrorMessageIsReturnedWithErrorCode(String expectedErrorMessage, int expectedErrorCode) {
        SoftAssert sa = new SoftAssert();
        Assert.assertTrue(((String)GenericSteps.resp.jsonPath().get("error_message")).contains(expectedErrorMessage), "Response code validation failed for user update API");
        Assert.assertSame(expectedErrorCode, GenericSteps.resp.jsonPath().get("error_code"));
        System.out.println(GenericSteps.resp.jsonPath().get("error_code").getClass());
        sa.assertAll();
    }
}
