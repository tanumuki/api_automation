package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import endPoints.APIResources;
import entities.PlaylistContainer;
import entities.PlaylistMini;
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
import validators.PlaylistMiniValidator;
import validators.Validate;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetContentMini extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with get all contents endPoint {string}")
    public void payload_with_get_all_contents_endPoint(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls Get All contents api")
    public void user_calls_Get_All_contents_api() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println( resp.asString());

        logResponseTime(resp);
    }

    @Then("Get All contents must respond with status code {string}")
    public void get_All_contents_must_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("User should successfully validate the Get All contents response of type {string}")
    public void user_should_successfully_validate_the_Get_All_contents_response(String entityType) throws JsonProcessingException {
//      Here we're using "type" because the response type of charts is different from playlists. Charts response has status and data fields,
//        whereas playlist response has an array of playlist mini objects

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        SoftAssert sa = new SoftAssert();

        if(entityType.equalsIgnoreCase("chart")) {
            PlaylistContainer contentMinis = mapper.readValue(resp.asString(), PlaylistContainer.class);
//        Validators
            sa.assertTrue(contentMinis.getStatus().equalsIgnoreCase(Validate.API_STATUS_SUCCESS),
                    "Expected \"" + Validate.API_STATUS_SUCCESS + "\", but found: \"" + contentMinis.getStatus() + "\"");
            for(PlaylistMini ch : contentMinis.getData()) {
                new PlaylistMiniValidator().validate(ch, sa);
            }
        }

        else if(entityType.equalsIgnoreCase("playlist")) {
            List<PlaylistMini> contentMinis = mapper.readValue(resp.asString(), new TypeReference<List<PlaylistMini>>() {});
            for(PlaylistMini ch : contentMinis) {
                new PlaylistMiniValidator().validate(ch, sa);
            }
        }

        else {
//            purposefully fail the assertions for unhandled types. Specific types must be provided from the feature file
            sa.assertTrue(0>1);
        }

        sa.assertAll();
    }

}
