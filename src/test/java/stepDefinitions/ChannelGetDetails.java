package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import enums.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.asserts.SoftAssert;
import resources.ConfigReader;
import resources.Util;
import validators.ChannelGetDetails.ChannelGetDetailsValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ChannelGetDetails extends Util {

    @Then("Channel get details api response must be validated successfully")
    public void channel_get_details_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.channelGetDetailsPojos.ChannelGetDetails channels = mapper.readValue(GenericSteps.resp.asString(), pojos.channelGetDetailsPojos.ChannelGetDetails.class);
        SoftAssert sa = new SoftAssert();
        new ChannelGetDetailsValidator().validate(channels, sa);
        sa.assertAll();
    }

}
