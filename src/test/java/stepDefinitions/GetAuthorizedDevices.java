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
import pojos.GetAuthorizedDevices.SubsGetAuthorizedDevices;
import resources.ConfigReader;
import resources.Util;
import validators.ChannelGetDetails.ChannelGetDetailsValidator;
import validators.GetAuthorizedDevices.GetAuthDevicesValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetAuthorizedDevices extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    String cookie = "";

    @Given("Payload with get authorized devices endpoint {string} along with given credentials")
    public void payload_with_get_authorized_devices_endpoint_along_with_given_credentials(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String username = ConfigReader.getInstance().getUsername();
        String password = ConfigReader.getInstance().getPassword();
        cookie = GetCookies.initCookies(username, password);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        System.out.println("cookie: " + cookie);
        reqSpec = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
    }

    @When("User calls get authorized devices api")
    public void user_calls_get_authorized_devices_api() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println("Aswin response: " + resp.asString());

        logResponseTime(resp);
    }

    @Then("get authorized devices api must respond with code {string}")
    public void get_authorized_devices_api_must_respond_with_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("get authorized devices response must be validated successfully")
    public void get_authorized_devices_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        SubsGetAuthorizedDevices devices = mapper.readValue(resp.asString(), SubsGetAuthorizedDevices.class);
        SoftAssert sa = new SoftAssert();
        new GetAuthDevicesValidator().validate(devices, sa);
        sa.assertAll();
    }
}
