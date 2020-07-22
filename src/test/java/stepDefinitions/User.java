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
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.login_pojos.UserLogin;
import pojos.user_pojos.UserProfileUpdate;
import resources.APIConstants;
import resources.ConfigReader;
import resources.Util;
import statusCodes.StatusCode;
import validators.UserLoginValidator;
import validators.UserPofileDataValidator;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class User extends Util{
    RequestSpecification request;
    ResponseSpecification resspec;
    Response resp;
    String apiResource;

    @Given("I have the endopoint for {string}")
    public void iHaveTheEndopointFor(String endPoint) {
        apiResource = APIResources.valueOf(endPoint).getResource();
        try {
            request = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), apiResource));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("I make the {string} request with the following query parameters")
    public void iMakeTheRequestWithTheFollowingQueryParameters(String method, DataTable queryParams) throws IOException {
        List<Map<String, String>> params = queryParams.asMaps();
        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
            request.queryParams(params.get(0));
        }
        request.header("Cookie",GetCookies.initCookies("sun@s.in", "saavn123"));
        request.log().everything();
        resp = request.given()
                .when()
                .get("/api.php")
                .then()
                .log()
                .all()
                .extract()
                .response();

        System.out.println(resp.getBody().asString());
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
