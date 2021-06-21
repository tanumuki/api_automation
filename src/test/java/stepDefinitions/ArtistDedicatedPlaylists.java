package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.DedicatedArtistPlaylist;
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
import validators.genericValidators.ArtistDedicatedPlaylistsValidator;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ArtistDedicatedPlaylists extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    String artistID;

    @Given("Payload with the ArtistDedicatedPlaylists endPoint {string}")
    public void payloadWithTheGivenEndPoint(String endPoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endPoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource api " + resourceAPI.getResource());
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
        System.out.println(reqSpec);
    }

    @When("The user calls https request with {string}")
    public void theUserCallsHttpsRequestWith(String artistID) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("artistId", artistID);
        this.artistID = artistID;
        resp = reqSpec.given()
                .log()
                .all()
                .when()
                .get("/api.php")
                .then()
                .log()
                .all()
                .extract()
                .response();
        System.out.println(resp.asString());
        logResponseTime(resp);
    }

    @Then("The user should get response with status code {string}")
    public void theUserShouldGetResponseWithStatusCode(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @And("Response should be validated")
    public void responseShouldBeValidated() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        DedicatedArtistPlaylist dedicatedArtistPlaylistPojo = objectMapper.readValue(resp.asString(), DedicatedArtistPlaylist.class);
        SoftAssert sa = new SoftAssert();
        new ArtistDedicatedPlaylistsValidator().validate(dedicatedArtistPlaylistPojo, sa, artistID);
        sa.assertAll();

    }

}
