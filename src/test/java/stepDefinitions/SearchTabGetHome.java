package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.Artist;
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
import pojos.searchTabHomePage.SearchTabHomePage;
import resources.ConfigReader;
import resources.Util;
import validators.SearchTabHomePage.SearchTabHomeValidator;
import validators.genericValidators.ArtistMapValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SearchTabGetHome extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with search grid home page endpoint {string}")
    public void payload_with_search_grid_home_page_endpoint(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User call search grid get home page api with {string} and {string}")
    public void user_call_search_grid_get_home_page_api_with_and(String page, String next_sign) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        reqSpec.queryParam("page", page);
        reqSpec.queryParam("next_sign", next_sign);
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println( resp.asString());

        logResponseTime(resp);
    }

    @Then("Search grid home page api must respond with status code {string}")
    public void search_grid_home_page_api_must_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("Search grid home page api response must be validated successfully")
    public void search_grid_home_page_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        SearchTabHomePage result = mapper.readValue(resp.asString(), SearchTabHomePage.class);
        SoftAssert sa = new SoftAssert();
        new SearchTabHomeValidator().validate(result, sa);
        sa.assertAll();
    }
}
