package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import endPoints.APIResources;
import entities.Song;
import entities.SongContainer;
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
import validators.Validate;
import validators.genericValidators.SongValidator;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SongRecommendation extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with endPoint get song reco API {string}")
    public void payload_with_end_point_get_song_reco_api(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls get song reco request with  {string}")
    public void user_calls_get_song_reco_request_with(String song_id) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("pid", song_id);
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println(resp.asString());

        logResponseTime(resp);
    }

    @Then("get song reco API returns a status code {string}")
    public void get_song_reco_api_returns_a_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("get song reco API response is validated")
    public void get_song_reco_api_response_is_validated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        TypeFactory typeFactory = mapper.getTypeFactory();
        SoftAssert sa = new SoftAssert();

        if (ConfigReader.getInstance().getCtx().equals("androidgo")) {
            List<Song> songs = mapper.readValue(resp.asString(), new TypeReference<List<Song>>() {
            });
            for (Song song : songs) {
                new SongValidator().validate(song, sa);
            }
        } else {
            SongContainer songs = mapper.readValue(resp.asString(), SongContainer.class);
            sa.assertTrue(songs.getStatus().equalsIgnoreCase(Validate.API_STATUS_SUCCESS),
                    "Expected \"" + Validate.API_STATUS_SUCCESS + "\", but found: \"" + songs.getStatus() + "\"");
            for (Song song : songs.getData()) {
                new SongValidator().validate(song, sa);
            }
        }
        sa.assertAll();
    }

}
