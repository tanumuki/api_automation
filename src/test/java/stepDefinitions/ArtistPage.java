package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.Artist;
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
import resources.ConfigReader;
import resources.Util;
import validators.ArtistValidator.ArtistPageValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ArtistPage extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with artist page details endpoint {string}")
    public void payloadWithArtistPageDetailsEndpoint(String endPoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endPoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource api " + resourceAPI.getResource());
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls Get Artist Page api with {string}")
    public void userCallsGetArtistPageApi(String artistID) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("artistId", artistID);
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        logResponseTime(resp);
    }

    @Then("Get Artist Page API must respond with status code {string}")
    public void getArtistPageAPIMustRespondWithStatusCode(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @And("User should see the artist page response validated")
    public void userShouldSeeTheArtistPageResponseValidated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Artist artistObj = mapper.readValue(resp.asString(), Artist.class);
        SoftAssert sa = new SoftAssert();
        new ArtistPageValidator().validateAll(artistObj, sa);
        sa.assertAll();

    }
}
