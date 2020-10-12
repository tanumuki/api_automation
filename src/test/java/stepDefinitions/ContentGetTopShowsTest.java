package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import pojos.getTopShows.TopShowsData;
import resources.ConfigReader;
import resources.Util;
import validators.genericValidators.TopShowsValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ContentGetTopShowsTest extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    boolean lastPageCheck;

    @Given("Payload with endpoint content get top shows {string}")
    public void payload_with_endpoint_content_get_top_shows(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls get top shows api")
    public void user_calls_get_top_shows_api() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println("Aswin response: " + resp.asString());

        logResponseTime(resp);
    }

    @When("User calls get top shows api with {string} and {string}")
    public void user_calls_get_top_shows_api_with_and(String page_no, String items_per_page) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        reqSpec.queryParam("n", items_per_page);
        reqSpec.queryParam("p", page_no);
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println("Aswin response: " + resp.asString());
    }

    @Then("Get top shows must respond with status code {string}")
    public void get_top_shows_must_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("Get top shows api response must be validated successfully")
    public void get_top_shows_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        TopShowsData shows = mapper.readValue(resp.asString(), TopShowsData.class);
        SoftAssert sa = new SoftAssert();
        new TopShowsValidator().validate(shows, sa);
        sa.assertAll();
    }

}
