package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.benefits.BenefitsCount;
import pojos.benefits.BenefitsList;
import resources.Util;
import validators.BenefitsValidator;

public class Benefits extends Util {
    @Then("The Benefits Count API returns response with status code {int}")
    public void theBenefitsCountAPIReturnsResponseWithStatusCode(int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for benefits count API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        BenefitsCount benefitsCount = objectMapper.readValue(GenericSteps.resp.asString(), BenefitsCount.class);
        new BenefitsValidator().validateCount(benefitsCount, sa);
        sa.assertAll();
    }

    @Then("The Benefits List API returns response with status code {int}")
    public void theBenefitsListAPIReturnsResponseWithStatusCode(int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for benefits list API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        BenefitsList benefitsList = objectMapper.readValue(GenericSteps.resp.asString(), BenefitsList.class);
        new BenefitsValidator().validateList(benefitsList, sa);
        sa.assertAll();
    }
}
