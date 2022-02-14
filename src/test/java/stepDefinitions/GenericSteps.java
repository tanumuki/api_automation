package stepDefinitions;


import endPoints.APIResources;
import endPoints.Context;
import enums.StatusCode;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import pojos.jioTuneLogin.DeviceInfo;
import pojos.jioTuneLogin.SsoObjectToJson;
import resources.APIConstants;
import resources.ConfigReader;
import resources.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cookieManager.GetCookies.clearCookies;
import static cookieManager.GetCookies.initCookies;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class GenericSteps extends Util {

    static Response resp;
    static String apiResource;
    static String cookie;
    static List<Map<String, String>> params;

    @Given("I have the endpoint for {string}")
    public void iHaveTheEndpointFor(String endPoint) throws Exception {
        apiResource = APIResources.valueOf(endPoint).getResource();
        System.out.println(cookie);
        if (cookie != null)
            request = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), apiResource, cookie));
        else
            request = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), apiResource));
    }

    @When("I make the {string} request with the following query parameters")
    public void  iMakeTheRequestWithTheFollowingQueryParameters(String method, DataTable queryParams) throws IOException {
        params = queryParams.asMaps();
        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
            request.queryParams(params.get(0));
        }

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
        System.out.println("Following response: " + resp.asString());
        logResponseTime(resp);
        log.info(resp.asString());
    }

    @When("I make the {string} request with the following query parameters with response specification")
    public void  iMakeTheRequestWithTheFollowingQueryParametersWithResponseSpecification(String method, DataTable queryParams) throws IOException {
        List<Map<String, String>> params = queryParams.asMaps();
        String ssoToken = (String) testContext.scenarioContext.getContext(Context.SSO_TOKEN);
        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
            request.queryParams(params.get(0));
            request.queryParam("ssotoken", ssoToken);
            request.queryParam("jtoken", new DeviceInfo().getJToken()); //This field(jtoken) is optional
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
        System.out.println(resp.asString());
    }

    @Given("I have the cookie for the following user")
    public void iHaveTheCookieForTheFollowingUser(DataTable userDetails) throws IOException {
        List<Map<String, String>> user = userDetails.asMaps();
        cookie = initCookies(user.get(0).get("username"), user.get(0).get("password"));
        System.setProperty("ctx", ConfigReader.getInstance().getCtx());
    }

    @When("I make the {string} request")
    public void iMakeTheRequest(String method) {
        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
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
            logResponseTime(resp);
            System.out.println(resp.asString());
        }
    }


    public static void iMakeTheRequestWithParameterPassedInMethod(HashMap<String, String> params) {
        request.queryParams(params);
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
        logResponseTime(resp);
        log.info(resp.asString());
    }

    @Then("I validate status code with {string}")
    public static void iValidateStatusCode(String statusCode){
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        System.out.println(resp.getStatusCode());
        assertEquals(resp.getStatusCode(), resource);
        log.info("The status is "+ resp.getStatusCode());
    }

    @Given("^I have the following params for SSO Token generation$")
    public void i_have_the_following_params_for_sso_token_generation(DataTable table) throws Throwable {

        RequestSpecification requestSpecification;
        ResponseSpecification responseSpecification;
        Response response;

        List<Map<String, String>> tokenDetails =table.asMaps();
        String  contentType =tokenDetails.get(0).get("Content-Type");
        String  xApiKey =tokenDetails.get(0).get("x-api-key");
        String  appName =tokenDetails.get(0).get("app-name");


        requestSpecification =given().spec(requestSpecificationForSsoToken(contentType,xApiKey,appName));
        //Adding the variables to request spec object
        responseSpecification= responseSpecification(contentType, StatusCode.valueOf("OK").getResource());
        JSONObject params = new JSONObject();
        requestSpecification.body(SsoObjectToJson.parseSso());
        response= requestSpecification.given().log().all().when().post().then().log().all().spec(responseSpecification).extract().response();
        log.info("Response of token "+response.getBody().asString());
        String ssoToken = response.jsonPath().getString("ssoToken");
        testContext.scenarioContext.setContext(Context.SSO_TOKEN, ssoToken);

    }

    @Then("I request log out API for the uid")
    public void iRequestLogOutAPI(DataTable table) throws IOException {
        List<Map<String, String>> data = table.asMaps();
        clearCookies(data.get(0).get("uid"));
        log.info("Logout is done");
    }

    @Given("I login with randomly generated user credentials")
    public void iLoginWithRandomlyGeneratedUserCredentials() throws Exception {
        cookie = generateNewUser();
    }
}
