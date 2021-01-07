package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.Artist;
import entities.Song;
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
import pagination.PaginationValidator;
import resources.ConfigReader;
import resources.Util;
import validators.Artist.ArtistPageValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ArtistMoreSongs extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    //    Pagination support parameters
    String apiResource;
    String artistID;
    int statusCodeResource;

    @Given("Payload with artist more songs endpoint {string}")
    public void payloadWithArtistPageDetailsEndpoint(String endPoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endPoint);
        String resource = resourceAPI.getResource();
        this.apiResource = resource; //Required for pagination step later
        System.out.println("resource api " + resourceAPI.getResource());
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls Get Artist More Songs api with {string}")
    public void userCallsGetArtistPageApi(String artistID) {
        this.artistID = artistID; //Required for pagination step later
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("artistId", artistID);
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        logResponseTime(resp);
    }

    @Then("Get Artist More Songs API must respond with status code {string}")
    public void getArtistPageAPIMustRespondWithStatusCode(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        this.statusCodeResource = resource; //Required for pagination step later
        assertEquals(resp.getStatusCode(), resource);
    }

    @And("User should see the artist more songs response validated")
    public void userShouldSeeTheArtistPageResponseValidated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Artist artistObj = mapper.readValue(resp.asString(), Artist.class);
        SoftAssert sa = new SoftAssert();
        new ArtistPageValidator().validateTopSongs(artistObj, sa);
        sa.assertAll();
    }

    @And("Pagination for More Songs API should return the requested content with startindex {int}, pagesize {int}, max pages {int}")
    public void paginationForMoreSongsAPIShouldReturnTheRequestedContentWithStartindexPagesizeMaxPages(int startindex, int pagesize, int maxNumberOfPages) throws JsonProcessingException,  IOException {
        List<String> paginatedList = new ArrayList<String>();
        for (int i = startindex; i < maxNumberOfPages; i++) {

//            Reset the request spec and construct a new one with pagination parameters
            reqSpec = null;
            reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), this.apiResource));
            reqSpec.queryParam("page", i);
            reqSpec.queryParam("size", pagesize);
            reqSpec.queryParam("artistId", this.artistID);

//            Reset the response spec and get a new one
            resp = null;
            resp = reqSpec.given().when().get("/api.php").then().extract().response();
            assertEquals(resp.getStatusCode(), this.statusCodeResource);
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
            Artist artistObj = mapper.readValue(resp.asString(), Artist.class);

//            Validate the paginated responses
            SoftAssert sa = new SoftAssert();
            new ArtistPageValidator().validateTopSongs(artistObj, sa);

//            Create a list of IDs of each song object
            for (Song a : artistObj.getTopSongs().getSongs()) {
                paginatedList.add(a.getId());
            }

//            Pass the list as an argument to the validator
            sa.assertTrue(paginatedList.size() > 0);
            sa.assertTrue(PaginationValidator.paginationDuplicateValidator(paginatedList),
                    "Found duplicate entities in paginated responses for Top Songs for artist " + this.artistID);

            sa.assertAll();
            sa = null;
        }
    }
}
