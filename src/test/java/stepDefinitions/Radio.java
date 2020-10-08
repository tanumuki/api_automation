package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import entities.Entity;
import entities.Song;
import io.cucumber.core.internal.gherkin.deps.com.google.gson.Gson;
import io.cucumber.core.internal.gherkin.deps.com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import endPoints.APIResources;
import endPoints.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIConstants;
import resources.ConfigReader;
import resources.ScenarioContext;
import resources.Util;
import validators.RadioValidator;
import enums.StatusCode;
import validators.genericValidators.SongValidator;

public class Radio extends Util {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response resp;
    String resource;
    static String stationId = "";
    public ScenarioContext scenarioContext;


    @Given("Create the artist station with endpoint {string}")
    public void create_the_artist_station_with_endpoint(String endPoint) throws IOException {

        APIResources resourceAPI = APIResources.valueOf(endPoint);
        resource = resourceAPI.getResource();
        System.out.println("respurce api " + resourceAPI.getResource());
        res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));

    }

    @When("User calls GET method with below params name and query")
    public void user_calls_GET_method_with_below_params_name_and_query(io.cucumber.datatable.DataTable table) {
        resspec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();

        // code to handle Data Table
        List<Map<String, String>> data = table.asMaps();
        System.out.println("data" + data.get(0));
        String method = data.get(0).get("method");

        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
            res.queryParam("query", data.get(0).get("query"));
            res.queryParam("name", data.get(0).get("name"));
            res.queryParam("language", data.get(0).get("language"));
            resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
        }
    }

    @Then("The Radio API returns station ID with status code {string}")
    public void the_Radio_API_returns_station_ID_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        System.out.println("the code is  " + resource);
        System.out.println("the response is  " + resp.body().asString());
        System.out.println("the response TIME is  " + resp.getTime());

        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("Parse the stationId")
    public void parse_the_stationId() {
        //testContext = new TestContext();
        stationId = resp.jsonPath().get("stationid");
        testContext.scenarioContext.setContext(Context.STATIONID, stationId);
        String st = (String) testContext.scenarioContext.getContext(Context.STATIONID);
        System.out.println("sth " + st);
        //System.setProperty("stationid", stationId);
        System.out.println("sta id is " + stationId);
    }

    @Given("Fetch the song by adding payload of {string}")
    public void fetch_the_song_by_adding_payload_of(String endPoint) throws IOException {

        APIResources resourceAPI = APIResources.valueOf(endPoint);
        resource = resourceAPI.getResource();
        System.out.println("respurce api " + resourceAPI.getResource());
        res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls GET method with below param with next =1 and stationid {string}")
    public void user_calls_GET_method_with_below_param_with_next_1_and_stationid(String string,
                                                                                 io.cucumber.datatable.DataTable table) {

        resspec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();

        //testContext = new TestContext() ;
        stationId = (String) testContext.scenarioContext.getContext(Context.STATIONID);

        // code to handle Data Table
        List<Map<String, String>> data = table.asMaps();
        System.out.println("data" + data.get(0));
        String method = data.get(0).get("method");

        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {

            res.queryParam("next", data.get(0).get("next"));
            res.queryParam("stationid", stationId);
            resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();

        }

    }

    @Then("Validate the station response")
    public void validate_the_station_response() throws JsonMappingException, JsonProcessingException {

        System.out.println("Radio response" + resp.getBody().asString());
        SoftAssert sa = new SoftAssert();
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                true);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        entities.Radio radio = objectMapper.readValue(resp.asString(), entities.Radio.class);
        new RadioValidator().validateRadio(radio, stationId, sa);
        sa.assertAll();


    }

    @And("Validate the artist in radio station response")
    public void validate_the_artist_in_radio_station_response() throws JsonMappingException, JsonProcessingException {

        System.out.println("Radio response" + resp.getBody().asString());
        SoftAssert sa = new SoftAssert();
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                true);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        entities.Radio radio = objectMapper.readValue(resp.asString(), entities.Radio.class);
        new RadioValidator().validateRadio(radio, stationId, sa);


    }


    @Then("The create entity station returns status code {int}")
    public void theCreateEntityStationReturnsStatusCode(int expectedStatusCode) {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for radio create entity station API");
        sa.assertAll();
    }

    @And("I parse the stationId")
    public void iParseTheStationId() {
        System.out.println();
        testContext.scenarioContext.setContext(Context.STATIONID, GenericSteps.resp.jsonPath().get("stationid"));
        System.out.println(testContext.scenarioContext.getContext(Context.STATIONID));
    }

    @Then("The create station returns status code {int}")
    public void theCreateStationReturnsStatusCode(int expectedStatusCode) {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for radio create entity station API");
        sa.assertAll();
    }

    @When("I make the {string} request with the following query parameters and the station Id")
    public void iMakeTheRequestWithTheFollowingQueryParametersAndTheStationid(String method, DataTable queryParams) {
        List<Map<String, String>> params = queryParams.asMaps();
        String stationId = (String) testContext.scenarioContext.getContext(Context.STATIONID);
        System.out.println(stationId);
        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
            GenericSteps.request.queryParams(params.get(0));
        }
        GenericSteps.request.queryParam("stationid", stationId);
        resp = GenericSteps.request.given()
                .log()
                .all()
                .when()
                .get("/api.php")
                .then()
                .log()
                .all()
                .extract()
                .response();
        logResponseTime(resp);
        System.out.println(resp.asString());
    }

    @Then("The Web Radio Get Song API returns response with status code {int}")
    public void theWebRadioGetSongAPIReturnsResponseWithStatusCode(int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for radio create entity station API");
        Assert.assertEquals((String) testContext.scenarioContext.getContext(Context.STATIONID), resp.jsonPath().get("stationid"));

        JsonPath responseJson = resp.jsonPath();

        LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> songs = responseJson.get();


        for (int i = 0; i < 5; i++) {
            String json = new Gson().toJson(songs.get(Integer.toString(i)).get("song"), LinkedHashMap.class);
            Song song = new ObjectMapper().readValue(json, new TypeReference<Song>() {
            });

            new SongValidator().validate(song, sa);
        }
        sa.assertAll();
    }
}
