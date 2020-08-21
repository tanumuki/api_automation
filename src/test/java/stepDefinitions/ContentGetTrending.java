package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.AssortedEntities;
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

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ContentGetTrending extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    //    Pagination support parameters
    String apiResource;
    int statusCodeResource;

    @Given("Payload with content get trending endpoint {string}")
    public void payload_with_content_get_trending_endpoint(String endPoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endPoint);
        String resource = resourceAPI.getResource();
        this.apiResource = resource; //Required for pagination step later
        System.out.println("resource api " + resourceAPI.getResource());
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));

    }

    @When("User calls Content Get Trending API")
    public void user_calls_Content_Get_Trending_API() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        resp = reqSpec.given().when().get("/api.php").then().extract().response();
        logResponseTime(resp);

    }
    @Then("Get Content Get Trending API must respond with status code {string}")
    public void get_Content_Get_Trending_API_must_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        this.statusCodeResource = resource; //Required for pagination step later
        assertEquals(resp.getStatusCode(), resource);

    }
    @Then("User should see the Content Get Trending response validated")
    public void user_should_see_the_Content_Get_Trending_response_validated() throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        AssortedEntities.readAndValidateAssortedEntity(resp, sa);
        sa.assertAll();

    }
    @Then("Pagination for Content Get Trending API should return the requested content with startindex {int}, pagesize {int}, max pages {int}")
    public void pagination_for_Content_Get_Trending_API_should_return_the_requested_content_with_startindex_pagesize_max_pages(int startindex, int pagesize, int maxNumberOfPages) {

    }
}
