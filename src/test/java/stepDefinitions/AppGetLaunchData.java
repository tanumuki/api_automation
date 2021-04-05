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
import resources.ConfigReader;
import resources.Util;
import validators.AppGetLaunchData.GetLaunchDataValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class AppGetLaunchData extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    String cookie = "";
    @Given("Payload with endpoint for app get launch {string}")
    public void payload_with_endpoint_for_app_get_launch(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @Given("Payload with app get launch endpoint {string} along with given credentials")
    public void payload_with_app_get_launch_endpoint_along_with_given_credentials(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String username = ConfigReader.getInstance().getUsername();
        String password = ConfigReader.getInstance().getPassword();
//        System.out.println("from config appversion: " + ConfigReader.getInstance().getAppVersion());

        cookie = GetCookies.initCookies(username, password);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        System.out.println("cookie: " + cookie);
        reqSpec = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
    }


    @When("User calls app get launch api")
    public void user_calls_app_get_launch_api() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println(resp.asString());

        logResponseTime(resp);
    }

    @Then("App get launch data api must respond with code {string}")
    public void app_get_launch_data_api_must_respond_with_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("App get launch data response must be validated successfully")
    public void app_get_launch_data_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.appGetLaunchData.AppGetLaunchData agld = mapper.readValue(resp.asString(), pojos.appGetLaunchData.AppGetLaunchData.class);
        SoftAssert sa  = new SoftAssert();
        System.out.println("from config appversion2: " + ConfigReader.getInstance().getAppVersion());
        System.setProperty("app_version", ConfigReader.getInstance().getAppVersion());
        new GetLaunchDataValidator().validate(agld, sa);
        sa.assertAll();
    }
}
