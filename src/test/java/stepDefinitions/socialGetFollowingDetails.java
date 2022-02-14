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
import resources.ConfigReader;
import resources.Util;
import validators.ChannelGetDetails.ChannelGetDetailsValidator;
import validators.SocialFollow.socialGetFollowingDetailsValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

   public class socialGetFollowingDetails extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;

    @Given("Payload with Following get details api {string}")
       public void payloadWithFollowingGetDetailsApi(String endpoint) throws IOException {
           APIResources resourceAPI = APIResources.valueOf(endpoint);
           String resource = resourceAPI.getResource();
           System.out.println("resource: " + resource);
           reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));

       }


       @When("User calls the Following details with given {string}")
       public void userCallsTheFollowingDetailsWithGiven(String uid) {
           resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                   .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
           reqSpec.queryParam("uid", uid);
           System.out.println("resSpec: " + resSpec.toString());
           resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
           System.out.println("Following response: " + resp.asString());

           logResponseTime(resp);
       }

    @Then("Following get details api must respond with status {string}")
    public void Following_get_details_api_must_respond_with_status(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }



        @Then("Following get details api response must be validated successfully")
    public void SocialGetFollowing_details_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.SocialFollow.GetFollowingDetails followingDetails = mapper.readValue(resp.asString(), pojos.SocialFollow.GetFollowingDetails.class);
        SoftAssert sa = new SoftAssert();
        new socialGetFollowingDetailsValidator().validate(followingDetails, sa);
        sa.assertAll();
    }

   }
