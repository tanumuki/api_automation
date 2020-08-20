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

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with Channel get details api {string}")
    public void payload_with_Channel_get_details_api(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls the channel get details with given {string}")
    public void user_calls_the_channel_get_details_with_given(String channel_id) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("channel_id", channel_id);
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println("Aswin response: " + resp.asString());

        logResponseTime(resp);
    }

    @Then("Channel get details api must respond with status {string}")
    public void channel_get_details_api_must_respond_with_status(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("Channel get details api response must be validated successfully")
    public void channel_get_details_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.channelGetDetailsPojos.ChannelGetDetails chanDets = mapper.readValue(resp.asString(), pojos.channelGetDetailsPojos.ChannelGetDetails.class);
        SoftAssert sa = new SoftAssert();
        new ChannelGetDetailsValidator().validate(chanDets, sa);
        sa.assertAll();
    }

}