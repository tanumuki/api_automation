package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.JioSendOtp.JioSendOtpPojo;
import validators.JioSendOtpValidator;

public class JioSendOtpSteps {
    @Then("The Jio Send OTP API returns response with status code {int}")
    public void theJioSendOTPAPIReturnsResponseWithStatusCode(int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(GenericSteps.resp.getStatusCode(), expectedStatusCode, "Response code validation failed for user update API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        JioSendOtpPojo jioSendOtpPojo = objectMapper.readValue(GenericSteps.resp.asString(),JioSendOtpPojo.class);
        new JioSendOtpValidator().validate(jioSendOtpPojo, sa);
        sa.assertAll();
    }
}
