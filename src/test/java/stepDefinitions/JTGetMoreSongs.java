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
import resources.ConfigReader;
import resources.Util;
import validators.JTGetMoreSongs.JTGetMoreSongsValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class JTGetMoreSongs extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with endpoint jiotunes get more songs {string}")
    public void payload_with_endpoint_jiotunes_get_more_songs(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls jiotunes get more songs api with {string}, {string} and {string}")
    public void user_calls_jiotunes_get_more_songs_api_with_and(String query, String n, String p) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        reqSpec.queryParam("query", query);
        reqSpec.queryParam("n", n);
        reqSpec.queryParam("p", p);

        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println( resp.asString());

        logResponseTime(resp);
    }

    @Then("jiotunes get more songs api must respond with status {string}")
    public void jiotunes_get_more_songs_api_must_respond_with_status(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("jiotunes get more songs response must be validated successfully")
    public void jiotunes_get_more_songs_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.JTGetMoreSongs.JTGetMoreSongs ms = mapper.readValue(resp.asString(), pojos.JTGetMoreSongs.JTGetMoreSongs.class);
        SoftAssert sa = new SoftAssert();
        new JTGetMoreSongsValidator().validate(ms, sa);
        sa.assertAll();
    }
}
