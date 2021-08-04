package stepDefinitions;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import endPoints.Context;
import entities.Album;
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
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import resources.APIConstants;
import resources.ConfigReader;
import resources.ScenarioContext;
import resources.UserGenerator;
import resources.Util;
import validators.genericValidators.MixDetailsValidator;

public class MakePrivatePlaylist extends Util {
    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("MakePrivatePlaylist API with endpoint {string}")
    public void MakePrivatePlaylist_API_with_endpoint(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }
    @When("User calls MakePrivatePlaylist  api with {int}")
    public void user_calls_MakePrivatePlaylist_api_with(String playlist_id){
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("listid", playlist_id);
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println( resp.asString());

        logResponseTime(resp);
    }

    @Then("MakePrivatePlaylist api must respond with status code {string}")
    public void makeprivateplaylist_api_must_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("User should see the MakePrivatePlaylist response validated")
    public void user_should_see_the_MakePrivatePlaylist_response_validated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        MakePrivatePlaylist plObj = mapper.readValue(resp.asString(), MakePrivatePlaylist.class);
        SoftAssert sa = new SoftAssert();
//        new MakePrivatePlaylistValidator().validate(plObj, sa);
        sa.assertAll();
    }

}
