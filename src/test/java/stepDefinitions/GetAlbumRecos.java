package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import endPoints.APIResources;
import entities.AlbumMiniObject;
import entities.AlbumReco;
import entities.Channel;
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
import validators.genericValidators.AlbumMiniValidator;
import validators.genericValidators.ChannelValidator;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetAlbumRecos extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with get album recommendations endPoint {string}")
    public void payload_with_get_album_recommendations_end_point(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls Get album recommendations api for the {string}")
    public void user_calls_get_album_recommendations_api_for_the(String albumid) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        reqSpec.queryParam("albumid", albumid);
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println("Aswin response: " + resp.asString());

        logResponseTime(resp);
    }

    @Then("Get album recommendations must respond with status code {string}")
    public void get_album_recommendations_must_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("User should see the recommendations response validated")
    public void user_should_see_the_recommendations_response_validated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        TypeFactory typeFactory = mapper.getTypeFactory();

        AlbumReco albumReco = mapper.readValue(resp.asString(), AlbumReco.class);
        SoftAssert sa = new SoftAssert();

//        Validators
        sa.assertTrue(albumReco.getStatus().equalsIgnoreCase("success"));
        for(AlbumMiniObject album : albumReco.getData()) {
            new AlbumMiniValidator().validate(album, sa);
        }
        sa.assertAll();
    }

}
