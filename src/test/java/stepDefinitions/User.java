package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import cookieManager.GetCookies;
import endPoints.APIResources;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.user_pojos.UserProfileUpdate;
import resources.APIConstants;
import resources.ConfigReader;
import resources.Util;
import validators.UserPofileDataValidator;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j
public class User extends Util{
    RequestSpecification request=null;
    Response resp;
    String apiResource;

    @Given("I have the endpoint for {string}")
    public void iHaveTheEndopointFor(String endPoint) throws IOException {
        apiResource = APIResources.valueOf(endPoint).getResource();
        String cookie =GetCookies.initCookies("sun@s.in", "saavn123");
        try {
            request = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), apiResource, cookie));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("I make the {string} request with the following query parameters")
    public void iMakeTheRequestWithTheFollowingQueryParameters(String method, DataTable queryParams){
        List<Map<String, String>> params = queryParams.asMaps();
        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
            request.queryParams(params.get(0));
        }
//        request.header("Cookie", initCookies("sun@s.in", "saavn123"));
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
    }

    @Then("The User Update API returns {string} with status code {int}")
    public void theUserUpdateAPIReturnsWithStatusCode(String expectedStatus, int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, resp.getStatusCode(), "Response code validation failed for user update API");
        Assert.assertEquals(expectedStatus, resp.jsonPath().get("status"), "Status validation failed for user update API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);

        UserProfileUpdate profileUpdate = objectMapper.readValue(resp.asString(), UserProfileUpdate.class);

        new UserPofileDataValidator().validate(profileUpdate, sa);

    }
}
