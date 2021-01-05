package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import enums.StatusCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.asserts.SoftAssert;
import pojos.Artist.SimilarArtists;
import pojos.Artist.SimilarArtistsContainer;
import resources.ConfigReader;
import resources.Util;
import validators.Artist.ArtistPageValidator;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ArtistSimilarArtists extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with similar artists endpoint {string}")
    public void payloadWithArtistPageDetailsEndpoint(String endPoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endPoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource api " + resourceAPI.getResource());
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls Get Similar Artists api with {string}")
    public void userCallsGetArtistPageApi(String artistID) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("artistId", artistID);
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        logResponseTime(resp);
    }

    @Then("Get Similar Artists API must respond with status code {string}")
    public void getArtistPageAPIMustRespondWithStatusCode(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @And("User should see the similar artists response validated")
    public void userShouldSeeTheArtistPageResponseValidated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        SimilarArtistsContainer similarArtistContainerObj = mapper.readValue(resp.asString(), SimilarArtistsContainer.class);
        SoftAssert sa = new SoftAssert();

//        Validators
        sa.assertTrue(similarArtistContainerObj.getStatus().equalsIgnoreCase("success"));
        for (SimilarArtists sm_art : similarArtistContainerObj.getData()) {
            new ArtistPageValidator().validateSimilarArtists(sm_art, sa);
        }
        sa.assertAll();

    }
}
