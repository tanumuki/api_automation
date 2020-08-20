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
import pojos.getHomePageDataV2.HomePageDataV2;
import resources.ConfigReader;
import resources.Util;
import validators.HomepageDataV2.HomepageDataValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetHomePageDataV2 extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    String cookie = "";

    @Given("Payload with endpoint GetHomepageDataV2 {string}")
    public void payload_with_endpoint_GetHomepageDataV2(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls get homepage data api")
    public void user_calls_get_homepage_data_api() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println("Aswin response: " + resp.asString());

        logResponseTime(resp);
    }

    @Then("Get homepage data api must respond with status code {string}")
    public void get_homepage_data_api_must_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("Get homepage data api response must be validated successfully with userstate as logged out")
    public void get_homepage_data_api_response_must_be_validated_successfully_with_userstate_as_logged_out() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        HomePageDataV2 home = mapper.readValue(resp.asString(), HomePageDataV2.class);
        SoftAssert sa = new SoftAssert();
        new HomepageDataValidator().validate(home, sa);
        sa.assertAll();
    }

    @Given("Payload with endpoint GetHomepageDataV2 {string} along with the credentials")
    public void payload_with_endpoint_GetHomepageDataV2_along_with_the_credentials(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String username = ConfigReader.getInstance().getUsername();
        String password = ConfigReader.getInstance().getPassword();
        cookie = GetCookies.initCookies(username, password);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        System.out.println("cookie: " + cookie);
        reqSpec = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
    }

    @Then("Get homepage data api response must be validated successfully with user state as logged in")
    public void get_homepage_data_api_response_must_be_validated_successfully_with_user_state_as_logged_in() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        HomePageDataV2 home = mapper.readValue(resp.asString(), HomePageDataV2.class);
        SoftAssert sa = new SoftAssert();
        new HomepageDataValidator().validate(home, sa);
        sa.assertAll();
    }


}
