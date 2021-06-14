package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.mongodb.util.JSON;
import endPoints.APIResources;
import entities.WebRadioDataMultiple;
import entities.WebRadioDataSingle;
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
import validators.GoogleAssistant;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class GoogleAssistantGet extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    String stationID;

    @Given("Payload with the GoogleAssistantGet endPoint {string}")
    public void payloadWithTheGivenEndPoint(String endPoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endPoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource api " + resourceAPI.getResource());
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
        System.out.println(reqSpec);
    }

    @When("User calls the given request with {string}")
    public void userCallsHttpsRequestWith(String query) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("query", query);
        resp = reqSpec.given().log()
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

    @Then("User should get response with {string} status code")
    public void theUserShouldGetResponseWithStatusCode(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @And("GoogleAssistantGet response should be validated against the query")
    public void googleassistantgetResponseShouldBeValidatedAgainstTheQuery() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        entities.GoogleAssistantGet googleAssistantGetPojo = objectMapper.readValue(resp.asString(), entities.GoogleAssistantGet.class);
        SoftAssert sa = new SoftAssert();
        new GoogleAssistant().validate(googleAssistantGetPojo, sa);
        this.stationID = googleAssistantGetPojo.getStationid();
        sa.assertAll();
    }

    @And("User calls {string} API")
    public void userCallsAPI(String endPoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endPoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource api " + resourceAPI.getResource());
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @And("User calls the WebRadioGetSong request with stationID")
    public void userCallsTheWebRadioGetSongRequestWithStationId() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("stationid", this.stationID);

        resp = reqSpec.given().log()
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

    @And("WebRadioGetSong response should be validated and return {string} status code")
    public void webradiogetsongResponseShouldBeValidatedAndReturnStatusCode(String statusCode) throws JsonProcessingException {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
        WebRadioDataSingle webRadioDataSingle = null;
        WebRadioDataMultiple webRadioDataMultiple = null;
        SoftAssert sa = new SoftAssert();
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        try{
            webRadioDataSingle = objectMapper.readValue(resp.asString(), WebRadioDataSingle.class);
        }catch (Exception e){
            webRadioDataMultiple = objectMapper.readValue(resp.asString(), WebRadioDataMultiple.class);
        }

        if(webRadioDataSingle != null){
            new GoogleAssistant().validateWebRadioSingle(webRadioDataSingle, sa, this.stationID);
        }
        else if(webRadioDataMultiple != null){
            new GoogleAssistant().validateWebRadioMultiple(webRadioDataMultiple, sa, this.stationID);
        }
        sa.assertAll();
    }
}
