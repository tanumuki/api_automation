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
import pojos.SEO.GetMetaResponse;
import pojos.SearchGetEntityResults.SearchGetEntityResults;
import resources.ConfigReader;
import resources.Util;
import validators.SearchGetEntityResults.SearchGetEntityResultsValidator;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SEOgetMetaResponse extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with endpoint getMetaResponse {string}")
    public void payload_with_endpoint_get_meta_response(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls getMetaResponse api with {string}, {string} and {string}")
    public void user_calls_get_meta_response_api_with_and(String type, String id, String partner) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("type", type);
        reqSpec.queryParam("id", id);
//        reqSpec.queryParam("partner", partner);
        Map<String, Object> headerVals = new HashMap<>();
        headerVals.put("partner", partner);
        reqSpec = reqSpec.headers(headerVals);
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
//        System.out.println("Req: " + reqSpec.given().log().method().toString());
        System.out.println( resp.asString());

        logResponseTime(resp);
    }

    @Then("getMetaResponse api must return response code {string}")
    public void get_meta_response_api_must_return_response_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("getMetaResponse response must be validated successfully")
    public void get_meta_response_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        GetMetaResponse result = mapper.readValue(resp.asString(), GetMetaResponse.class);
        SoftAssert sa = new SoftAssert();
//        new SearchGetEntityResultsValidator().validate(result, sa);
        sa.assertAll();
    }
}
