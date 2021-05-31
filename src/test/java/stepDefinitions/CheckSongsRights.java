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
import validators.CheckSongsRights.CheckSongsRightsValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CheckSongsRights extends Util {

    RequestSpecification reqSpec;
    ResponseSpecification resSpec;
    Response resp;
    String songsParam = "";
    @Given("Payload with endpoint check rights {string}")
    public void payload_with_endpoint_check_rights(String endpoint) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(endpoint);
        String resource = resourceAPI.getResource();
        System.out.println("resource: " + resource);
        reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
    }

    @When("User calls check rights api with the {string}")
    public void user_calls_check_rights_api_with_the(String pids) {
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
        songsParam = pids;
        String pidsEnc = "[";
        if(pids.indexOf(",") < 0){
            pidsEnc += "\"" + pids + "\"";
        } else {
            String[] songs = pids.split(",");

            for(int i=0; i<songs.length; i++) {
                pidsEnc += "\"" + songs[i] + "\"";
                if(i < songs.length-1)
                    pidsEnc += ",";
            }
        }
        pidsEnc += "]";
        System.out.println("enco:" + pidsEnc);
        reqSpec.queryParam("pids", pidsEnc);
        System.out.println("resSpec: " + resSpec.toString());
        resp = reqSpec.given().log().all().when().get("/api.php").then().log().all().extract().response();
        System.out.println( resp.asString());

        logResponseTime(resp);
    }

    @Then("check rights api must respond with status code {string}")
    public void check_rights_api_must_respond_with_status_code(String statusCode) {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
    }

    @Then("check rights api response must be validated successfully")
    public void check_rights_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.SubsCheckSongRights.CheckSongsRights rights = mapper.readValue(resp.asString(), pojos.SubsCheckSongRights.CheckSongsRights.class);
        SoftAssert sa = new SoftAssert();
        new CheckSongsRightsValidator().validate(rights, sa, songsParam);
        sa.assertAll();
    }
}
