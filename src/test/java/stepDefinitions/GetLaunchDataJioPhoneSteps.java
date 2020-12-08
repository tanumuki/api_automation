package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.jioPhoneGetLaunchData.JioPhoneGetLaunchData;
import resources.Util;
import validators.GetLaunchDataJioPhoneValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetLaunchDataJioPhoneSteps extends Util {
    Response resp;
    @Given("I have the endpoint for JioPhone API {string}")
    public void iHaveTheEndpointForJioPhoneAPI(String endPoint) throws IOException {
        String apiResource = APIResources.valueOf(endPoint).getResource();
        request = given().spec(requestSpecificationJioPhone(apiResource, GenericSteps.cookie));
    }

    @When("I make the {string} request for JioPhone API")
    public void iMakeTheRequestForJioPhoneAPI(String arg0) {
        resp = request.given()
                .log()
                .all()
                .when()
                .get("/api.php")
                .then()
                .log()
                .all()
                .extract()
                .response();

        logResponseTime(resp);
        System.out.println(resp.asString());
    }

    @Then("The JioPhone Get Launch API returns response with status code {int}")
    public void theJioPhoneGetLaunchAPIReturnsResponseWithStatusCode(int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, resp.getStatusCode(), "Response code validation failed for JioPhone Get Launch Data API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        JioPhoneGetLaunchData jioPhoneGetLaunchData = objectMapper.readValue(resp.asString(), JioPhoneGetLaunchData.class);
        new GetLaunchDataJioPhoneValidator().validate(jioPhoneGetLaunchData, sa);
        sa.assertAll();
    }
}
