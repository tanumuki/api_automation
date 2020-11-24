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
import pojos.SearchGetEntityResults.SearchGetEntityResults;
import resources.ConfigReader;
import resources.Util;
import validators.SearchGetEntityResults.SearchGetEntityResultsValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SearchGetMoreResults extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with endpoint get more results {string}")
    public void payload_with_endpoint_get_more_results(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls get more results api with {string} and {string}")
    public void user_calls_get_more_results_api_with_and(String query, String param) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("query", query);
        String p = "{\"type\":\"" + param + "\"}";
        System.out.println("P: " + p);
        reqSpec.queryParam("params", p);
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println("Aswin response: " + resp.asString());

        logResponseTime(resp);
    }

    @Then("get more results api should respond with status code {string}")
    public void get_more_results_api_should_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("get more results api response must be validated successfully")
    public void get_more_results_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        SearchGetEntityResults result = mapper.readValue(resp.asString(), SearchGetEntityResults.class);
        SoftAssert sa = new SoftAssert();
        new SearchGetEntityResultsValidator().validate(result, sa);
        sa.assertAll();
    }
}
