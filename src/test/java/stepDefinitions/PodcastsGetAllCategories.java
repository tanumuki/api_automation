package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
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
import pojos.podcastGetAllCategories.PodcastGetAllCategories;
import pojos.podcastsGetAll.PodcastGetAllPojo;
import resources.ConfigReader;
import resources.Util;
import validators.PodcastGetAllValidator.PodcastGetAllValidator;
import validators.pGACategoriesValidator.PodcastGetAllCategoriesValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PodcastsGetAllCategories extends Util {
    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    @Given("Payload with podcasts get all categories endpoint {string}")
    public void payload_with_podcasts_get_all_categories_endpoint(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls podcasts get all categories api")
    public void user_calls_podcasts_get_all_categories_api() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println("Aswin response: " + resp.asString());

        logResponseTime(resp);
    }

    @Then("Podcasts get all categories api should return with status code {string}")
    public void podcasts_get_all_categories_api_should_return_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("Podcasts get all categories response must be validated successfully")
    public void podcasts_get_all_categories_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        PodcastGetAllCategories pg = mapper.readValue(resp.asString(), PodcastGetAllCategories.class);
        SoftAssert sa  = new SoftAssert();
        new PodcastGetAllCategoriesValidator().validate(pg, sa);
        sa.assertAll();
    }
}
