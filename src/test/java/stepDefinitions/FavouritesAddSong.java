package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.MixDetails;
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
import validators.genericValidators.MixDetailsValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class FavouritesAddSong extends Util {
    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("favouritesAddSong API with endpoint {string}")
    public void favouritesAddSong_API_with_endpoint(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }
    @When("User calls favouritesAddSong api with {string}")
    public void user_calls_favouritesAddSong_api_with(String SongId) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("SongId", SongId);
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println("Favourite response: " + resp.asString());

        logResponseTime(resp);
    }

    @Then("favouritesAddSong api must respond with status code {string}")
    public void favouritesAddSong_api_must_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("User should see the favouritesAddSong response validated")
    public void user_should_see_the_favouritesAddSong_response_validated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        MixDetails plObj = mapper.readValue(resp.asString(), MixDetails.class);
        SoftAssert sa = new SoftAssert();
        new MixDetailsValidator().validate(plObj, sa);
        sa.assertAll();
    }
}
