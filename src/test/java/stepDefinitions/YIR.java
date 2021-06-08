package stepDefinitions;

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
import resources.ConfigReader;
import resources.Util;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class YIR extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    String cookie;
    @Given("Payload with endpoint YIR {string}")
    public void payload_with_endpoint_yir(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String username = ConfigReader.getInstance().getUsername();
        String password = ConfigReader.getInstance().getPassword();
        cookie = GetCookies.initCookies(username, password);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        System.out.println("cookie: " + cookie);
        reqSpec = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
    }

    @When("User calls YIR api with the given user credentials")
    public void user_calls_yir_api_with_the_given_user_credentials() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println( resp.asString());

        logResponseTime(resp);
    }

    @Then("YIR must respond with status code {string}")
    public void yir_must_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("YIR api response must be validated successfully")
    public void yir_api_response_must_be_validated_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
