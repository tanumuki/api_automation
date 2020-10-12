package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.Artist;
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
import validators.genericValidators.ArtistMapValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SearchGetArtistResults extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with get artist results endpoint {string}")
    public void payload_with_get_artist_results_endpoint(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls the get artists results api with {string}")
    public void user_calls_the_get_artists_results_api_with(String query) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("q", query);
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println("Aswin response: " + resp.asString());

        logResponseTime(resp);
    }

    @Then("Get artist results api must respond with status code {string}")
    public void get_artist_results_api_must_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("Get artist results api response must be validated successfully")
    public void get_artist_results_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.search.SearchGetArtistResults result = mapper.readValue(resp.asString(), pojos.search.SearchGetArtistResults.class);
        SoftAssert sa = new SoftAssert();
        for(Artist artist : result.getResults()) {
            new ArtistMapValidator().validate(artist, sa, "artist", "artist", artist.getId());
        }
        sa.assertAll();
    }

}
