package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import endPoints.Context;
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
import pojos.JiotuneHomePageData.JiotuneHomePageData;
import resources.ConfigReader;
import resources.ScenarioContext;
import resources.Util;
import validators.JiotuneHomepageData.JTHomePageDataValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class JiotuneGetHomepageData extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    ScenarioContext scenarioContext;

    @Given("Payload with jiotune home page data endpoint {string}")
    public void payload_with_jiotune_home_page_data_endpoint(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls jiotune home page data api")
    public void user_calls_jiotune_home_page_data_api() {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        System.out.println("resSpec: " + resSpec.toString());

        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println( resp.asString());
        testContext.scenarioContext.setContext(Context.JIOTUNEGETHOMEPAGERESPONSE, resp);
        logResponseTime(resp);
    }

    @Then("jiotune home page data api should respond with status code {string}")
    public void jiotune_home_page_data_api_should_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("jiotune home page data api response must be validated successfully")
    public void jiotune_home_page_data_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        JiotuneHomePageData homepageData = mapper.readValue(resp.asString(), JiotuneHomePageData.class);
        SoftAssert sa = new SoftAssert();
        new JTHomePageDataValidator().validate(homepageData, sa);
        sa.assertAll();
    }

}
