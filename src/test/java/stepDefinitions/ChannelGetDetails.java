package stepDefinitions;

import endPoints.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ConfigReader;
import resources.Util;
import statusCodes.StatusCode;

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
    public void user_calls_the_channel_get_details_with_given(String string) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
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
    public void channel_get_details_api_response_must_be_validated_successfully() {


    }

}
