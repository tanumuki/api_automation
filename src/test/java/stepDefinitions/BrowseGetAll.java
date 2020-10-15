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
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.asserts.SoftAssert;
import pojos.browseGetAll.BrowseGetAllPojo;
import resources.ConfigReader;
import resources.Util;
import validators.appGetLaunchDataValidators.GetLaunchDataValidator;
import validators.browseGetAllValidator.BrowseGetAllValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class BrowseGetAll extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    String cookie = "";
    @Given("Payload with browse get all endpoint {string} along with given credentials")
    public void payload_with_browse_get_all_endpoint_along_with_given_credentials(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String username = ConfigReader.getInstance().getUsername();
        String password = ConfigReader.getInstance().getPassword();
        cookie = GetCookies.initCookies(username, password);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        System.out.println("cookie: " + cookie);
        reqSpec = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
    }

    @When("User calls browse get all api")
    public void user_calls_browse_get_all_api() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        QueryableRequestSpecification queryreq = SpecificationQuerier.query(reqSpec);
        System.out.println("req: " +  queryreq.getURI());
        System.out.println("Aswin response: " + resp.asString());

        logResponseTime(resp);
    }

    @Then("Browse get all api should return with status code {string}")
    public void browse_get_all_api_should_return_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("Browse get all response must be validated successfully")
    public void browse_get_all_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        BrowseGetAllPojo br = mapper.readValue(resp.asString(), BrowseGetAllPojo.class);
        SoftAssert sa  = new SoftAssert();
        new BrowseGetAllValidator().validate(br, sa);
        sa.assertAll();
    }

}
