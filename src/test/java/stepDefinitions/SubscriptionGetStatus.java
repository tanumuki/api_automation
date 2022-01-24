package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import cookieManager.GetCookies;
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
import pojos.login_pojos.LoginProstatus;
import resources.ConfigReader;
import resources.Util;
import validators.AppGetLaunchData.GetLaunchDataValidator;
import validators.SubsGetStatus.SubsGetStatusValidator;
import validators.genericValidators.LoginProStatusValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SubscriptionGetStatus extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    String cookie = "";

    @Given("Payload with endpoint subs get status {string} with the given credentials")
    public void payload_with_endpoint_subs_get_status_with_the_given_credentials(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String username = ConfigReader.getInstance().getUsername();
        String password = ConfigReader.getInstance().getPassword();
        cookie = GetCookies.initCookies(username, password);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        System.out.println("cookie: " + cookie);
        reqSpec = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
    }

    @When("User calls subs get status api without include receipt")
    public void user_calls_subs_get_status_api_without_include_receipt() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println( resp.asString());
    }

    @When("User calls subs get status api with the {string} flag")
    public void user_calls_subs_get_status_api_with_the_flag(String includeReceipt) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        reqSpec.queryParam("include_receipt", includeReceipt);
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println( resp.asString());
    }

    @Then("Subs get status api responds with the status code {string}")
    public void subs_get_status_api_responds_with_the_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("Subs get status api response is validated successfully")
    public void subs_get_status_api_response_is_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.SubsGetStatus.SubscriptionGetStatus ps = mapper.readValue(GenericSteps.resp.asString(), pojos.SubsGetStatus.SubscriptionGetStatus.class);
        SoftAssert sa  = new SoftAssert();
        new SubsGetStatusValidator().validate(ps, sa);
        sa.assertAll();
    }
}
