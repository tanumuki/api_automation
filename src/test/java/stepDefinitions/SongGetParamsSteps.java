package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.SongGetParam.SongGetParamPojo;
import resources.Util;
import validators.SongGetParamValidator;

public class SongGetParamsSteps extends Util {


    @Then("Song Get Param API returns response with status code {int} and pid as {string} and field as {string}")
    public void songGetParamAPIReturnsResponseWithStatusCodeAndPidAsPidsAndFieldAsFields(int expectedStatusCode, String pid, String field) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for song get params API");

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        SongGetParamPojo songGetParamPojo = objectMapper.readValue(GenericSteps.resp.asString(), SongGetParamPojo.class);

        new SongGetParamValidator().validate(songGetParamPojo, sa, pid, field);
    }

}
