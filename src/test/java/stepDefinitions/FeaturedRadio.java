package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import endPoints.Context;
import entities.RadioStation;
import enums.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import resources.APIConstants;
import resources.ConfigReader;
import resources.Util;
import validators.RadioValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


@Slf4j
public class FeaturedRadio extends Util {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response resp;
    String resource;
    ArrayList<String> radioTitles;
    static String featuredStation = "";
    static ArrayList<String> stationName;
    static String stationId = "";

    @Given("Get the featured station with endpoint {string}")
    public void get_the_featured_station_with_endpoint(String endPoint) throws IOException {

        APIResources resourceAPI = APIResources.valueOf(endPoint);
        resource = resourceAPI.getResource();
        System.out.println("respurce api " + resourceAPI.getResource());
        res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));

    }

    @When("User calls GET method with language param")
    public void user_calls_GET_method_with_language_param(io.cucumber.datatable.DataTable table) {
        resspec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();

        // code to handle Data Table
        List<Map<String, String>> data = table.asMaps();
        System.out.println("data" + data.get(0));
        String method = data.get(0).get("method");

        // language= data.get(0).get("language");
        // testContext.scenarioContext.setContext(Context.LANGUAGE, language);

        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {

            res.queryParam("language", data.get(0).get("language"));
            resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();

        }
    }

    @Then("The Radio API returns station ID with status {string}")
    public void the_Radio_API_returns_station_ID_with_status(String statusCode) {

        ArrayList<String> staionList = new ArrayList<String>();
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        System.out.println("the code is  " + resource);
        System.out.println("the response is  " + resp.body().asString());
        System.out.println("the response TIME is  " + resp.getTime());

        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("Parse the title")
    public void parse_the_title() throws JsonMappingException, JsonProcessingException {
        String response = resp.getBody().asString();

        System.out.println("Radio response" + resp.getBody().asString());


        SoftAssert sa = new SoftAssert();
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                true);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //objectMapper.readerFor(resp.getBody().asByteArray());
        List<RadioStation> radioStationObj = objectMapper.readValue(resp.asString(), new TypeReference<List<RadioStation>>() {
        });
        radioTitles = new ArrayList<String>();

        for (RadioStation radioList : radioStationObj) {

            String radio = new RadioValidator().getFeaturedstation(radioList);
            radioTitles.add(radio);
        }
        System.out.println("Radio list " + radioTitles.toString());
        testContext.scenarioContext.setContext(Context.FEATURED_STATIONS, radioTitles);

    }

    @Given("Create feature station with endPoint  {string}")
    public void create_feature_station_with_endPoint(String endPoint) throws IOException {

        APIResources resourceAPI = APIResources.valueOf(endPoint);
        resource = resourceAPI.getResource();
        System.out.println("respurce api " + resourceAPI.getResource());
        res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));

    }

    @SuppressWarnings("unchecked")
    @When("User calls GET mehtod with param language")
    public void user_calls_GET_mehtod_with_param_language(io.cucumber.datatable.DataTable table) {

        resspec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();

        // code to handle Data Table
        List<Map<String, String>> data = table.asMaps();
        System.out.println("data" + data.get(0));
        String method = data.get(0).get("method");


        stationName = (ArrayList<String>) testContext.scenarioContext.getContext(Context.FEATURED_STATIONS);
        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {

            //looping based on radio station name
            for (int i = 0; i < stationName.size(); i++) {
                log.info("set context retrieve " + stationName.get(i));
                featuredStation = stationName.get(i);
                res.queryParam("language", data.get(0).get("language"));
                res.queryParam("name", featuredStation);
                resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();


            }
        }

    }

    @Then("Parse the featuredStationId")
    public void parse_the_featuredStationId() {
        //testContext = new TestContext();
        stationId = resp.jsonPath().get("stationid");
        testContext.scenarioContext.setContext(Context.STATIONID, stationId);
        String st = (String) testContext.scenarioContext.getContext(Context.STATIONID);
        System.out.println("sth " + st);
        //System.setProperty("stationid", stationId);
        System.out.println("station id is " + stationId);
    }

    //When create GET station with endPoint "WebRadioGetSong"

    @When("Create GET station with endPoint {string}")
    public void create_GET_station_with_endPoint(String endPoint) throws IOException {

        APIResources resourceAPI = APIResources.valueOf(endPoint);
        resource = resourceAPI.getResource();
        System.out.println("respurce api " + resourceAPI.getResource());
        res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));

    }


    @When("User calls GET method with params next=1 and featured stationId {string}")
    public void user_calls_GET_method_with_params_next_1_and_featured_stationId(String string, io.cucumber.datatable.DataTable table) {


        resspec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();

        //testContext = new TestContext() ;
        stationId = (String) testContext.scenarioContext.getContext(Context.STATIONID);

        System.out.println("station id  " + stationId);
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


}