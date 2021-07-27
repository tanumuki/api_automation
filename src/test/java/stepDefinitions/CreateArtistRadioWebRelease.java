package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import resources.ConfigReader;
import resources.Util;
import validators.RadioValidator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static cookieManager.GetCookies.initCookies;
import static io.restassured.RestAssured.given;

@Slf4j
public class CreateArtistRadioWebRelease extends Util {
    private RequestSpecification request = null;
    private Response resp;
    private String apiResource;
    private String cookie;
    private RequestSpecification getSongRequest;
    private Response getSongResponse;
    private List<Response> getRadioResponses = new ArrayList<>();
    private String stationId;


    @Given("I have the cookie for the following user for web release")
    public void iHaveTheCookieForTheFollowingUserForWebRelease(DataTable userDetails) throws IOException {
        List<Map<String, String>> user = userDetails.asMaps();
        cookie = initCookies(user.get(0).get("username"), user.get(0).get("password"));
    }

    @Given("I have the endpoint for {string} for web release")
    public void iHaveTheEndpointForForWebRelease(String endPoint) throws FileNotFoundException {
        apiResource = APIResources.valueOf(endPoint).getResource();
        request = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), apiResource, cookie));
    }

    @When("I make the GET request with query as {string} and name as {string} and value of k as {string}")
    public void iMakeTheGETRequestWithTheFollowingQueryAndName(String query, String name, String k) throws FileNotFoundException {

        request.queryParam("name", query);
        request.queryParam("query", name);

        resp = request.given()
                .log()
                .all()
                .when()
                .get("/api.php")
                .then()
                .log()
                .all()
                .extract()
                .response();
        System.out.println(resp.getStatusCode());
        System.out.println(resp.asString());
        for (int i = 0; i <= 3; i++) {
            apiResource = APIResources.valueOf("WebRadioGetSong").getResource();
            getSongRequest = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), apiResource, cookie));
            stationId=(resp.asString()).split(":")[1];
            getSongRequest.queryParam("stationid", stationId);
            getSongRequest.queryParam("next", 1);
            getSongRequest.queryParam("k", k);

            getSongResponse = getSongRequest.given()
                    .log()
                    .all()
                    .when()
                    .get("/api.php")
                    .then()
                    .log()
                    .all()
                    .extract()
                    .response();
            getRadioResponses.add(getSongResponse);
        }
    }

    @Then("I validate the response with status code {int} for the artist {string}")
    public void iValidateTheResponseWithSatatusCode(int expectedStatusCode, String artistName) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        int i=1;
       for (Response getSongResponse: getRadioResponses)
       {
           System.out.println(getSongResponse.asString());
           System.out.println("Validating Response "+i+" for artist "+artistName);
           Assert.assertEquals(getSongResponse.getStatusCode(),expectedStatusCode);

           ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                   true);
           entities.Radio  radio = objectMapper.readValue(getSongResponse.asString(),entities.Radio.class);

           System.out.println(artistName);
           new RadioValidator().validateRadio(radio, stationId, artistName,"", sa);
           i+=1;
       }
       sa.assertAll();

    }
}



