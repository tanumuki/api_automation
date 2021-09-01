package stepDefinitions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import endPoints.Context;
import entities.Entity;
import entities.Song;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.gson.JsonElement;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.testng.asserts.SoftAssert;
import pojos.JiotuneHomePageData.JiotuneHomePageData;
import pojos.jioTuneLogin.DeviceInfo;
import pojos.jioTuneLogin.UserJioLogin;
import pojos.setJioTune.JiotuneSetJioTunePojo;
import resources.APIConstants;
import resources.ConfigReader;
import resources.ScenarioContext;
import resources.Util;
import validators.JiotuneValidator.JiotuneValidator;
import validators.jioLoginValidator.JioLoginValidator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j
public class SetJiotune extends Util {


    public static  String ssoToken;
    Response resp;
    static String apiResource;
    static String cookie =GenericSteps.cookie;


    @Given("I have the endpoint for {string} with params")
    public void iHaveTheEndpointFor(String endPoint, DataTable dataTable) throws FileNotFoundException {
        apiResource = APIResources.valueOf(endPoint).getResource();
             List<Map<String, String>> map= dataTable.asMaps();
             Map<String,String> headerMap = new HashMap<>();
             String ContentType= map.get(0).get("Content-Type");
             String lbcookie= map.get(0).get("lbcookie");
             String apikey= map.get(0).get("api-key");
             String accept = map.get(0).get("Accept");
             ssoToken = (String) testContext.scenarioContext.getContext(Context.SSO_TOKEN);
             headerMap.put("Content-Type", ContentType);
             headerMap.put("lbcookie", lbcookie);
             headerMap.put("api-key", apikey);
             headerMap.put("Accept", accept);
             headerMap.put("ssotoken" ,ssoToken);

        if (cookie != null)
            request = given().spec(requestSpecificationWithHeadersUsingMap(ConfigReader.getInstance().getCtx(), apiResource, cookie, headerMap));
        else
            request = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), apiResource));
    }


    @When("I make the {string} request with the following query parameters for setJioTune")
    public void  iMakeTheRequestWithTheFollowingQueryParametersForSetJiotune(String method, DataTable queryParams) throws IOException {

        /*
        Getting the vcode from the jiotune getHomepage response
         */
        resp= (Response) testContext.scenarioContext.getContext(Context.JIOTUNEGETHOMEPAGERESPONSE);
        /*
        Getting the json array from the response - data_0
         */
        List<String> vCodes = new ArrayList<>();
       JsonPath jsonPath= resp.jsonPath();
        List<Song> dataList= jsonPath.getList("data_0", Song.class);
        for(int i=0 ;i <dataList.size() ;i++){
             String vcodeNumber=   dataList.get(i).getMoreInfo().getVcode();
            log.info("vcode Number is: "+vcodeNumber);
            vCodes.add(vcodeNumber);

         }
       String vCode= Util.getRandomElement(vCodes);
        log.info("VCode : "+vCode);
        List<Map<String, String>> params = queryParams.asMaps();
        log.info("sso token is " +ssoToken);
        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
            request.queryParams(params.get(0));
            request.queryParam("vcode", vCode);
        }

        resp = request.given()
                .log()
                .all()
                .when()
                .get("/api.php")
                .then()
                .log()
                .all()
                .spec(responseSpecification("text/html; charset=UTF-8", 200))
                .extract()
                .response();
        logResponseTime(resp);
    }

    @Then("^The Jio Tune API returns \"([^\"]*)\" with status code 200 and response message is validated$")
    public void the_jio_tune_api_returns_something_with_status_code_200_and_response_message_is_validated(String strArg1) throws Throwable {


        log.info("Response of jiotune api is  " +resp.getBody().asString());
        log.info( " Validating Jiotune api response");
        SoftAssert sa = new SoftAssert();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);
        System.out.println("response " +resp.asString());
        JiotuneSetJioTunePojo setJioTunePojo= mapper.readValue(resp.asString(), pojos.setJioTune.JiotuneSetJioTunePojo.class);
        new JiotuneValidator().validate(setJioTunePojo,sa);
        log.info("Jiotune set and validated!");
    }

}
