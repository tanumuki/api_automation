package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.JioTuneLimitPojo;
import validators.JioTuneLimitValidator;

public class JioTuneLimitSteps {
    @Then("The Jio tune API returns response with status code {int}")
    public void theJioTuneAPIReturnsResponseWithStatusCode(int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(GenericSteps.resp.getStatusCode(), expectedStatusCode, "Response code validation failed for user update API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        JioTuneLimitPojo jioTuneLimitPojo = objectMapper.readValue(GenericSteps.resp.asString(),JioTuneLimitPojo.class);
        new JioTuneLimitValidator().validate(jioTuneLimitPojo, sa);
        sa.assertAll();
    }
}
