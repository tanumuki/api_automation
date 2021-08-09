package stepDefinitions;


import endPoints.APIResources;
import enums.StatusCode;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;
import pojos.jioTuneLogin.ssoPojo.SsoObjectToJson;
import resources.APIConstants;
import resources.ConfigReader;
import resources.Util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cookieManager.GetCookies.initCookies;
import static io.restassured.RestAssured.given;

public class GenericSteps extends Util {

    //static RequestSpecification request = null;
    static Response resp;
    static String apiResource;
    static String cookie;

    @Given("I have the endpoint for {string}")
    public void iHaveTheEndopointFor(String endPoint) throws FileNotFoundException {
        apiResource = APIResources.valueOf(endPoint).getResource();
        if (cookie != null)
            request = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), apiResource, cookie));
        else
            request = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), apiResource));
    }

    @When("I make the {string} request with the following query parameters")
    public void  iMakeTheRequestWithTheFollowingQueryParameters(String method, DataTable queryParams) throws IOException {
        List<Map<String, String>> params = queryParams.asMaps();
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
        logResponseTime(resp);
        System.out.println(resp.asString());
    }

    @Given("I have the cookie for the following user")
    public void iHaveTheCookieForTheFollowingUser(DataTable userDetails) throws IOException {
        List<Map<String, String>> user = userDetails.asMaps();
        cookie = initCookies(user.get(0).get("username"), user.get(0).get("password"));
        System.setProperty("ctx", ConfigReader.getInstance().getCtx());
    }

    @Given("^I have the following params for SSO Token generation$")
    public void i_have_the_following_params_for_sso_token_generation(DataTable table) throws Throwable {

        RequestSpecification requestSpecification;
        ResponseSpecification responseSpecification;
        Response response;

        List<Map<String, String>> tokenDetails =table.asMaps();
        String  jToken =tokenDetails.get(0).get("JTOKEN");
        System.out.println("jtoeken "+jToken);
        String  contentType =tokenDetails.get(0).get("Content-Type");
        String  xApiKey =tokenDetails.get(0).get("x-api-key");
        String  appName =tokenDetails.get(0).get("app-name");


        requestSpecification =given().spec(requestSpecificationForSsoToken(jToken,contentType,xApiKey,appName));

        //Adding the variables to request spec object

       responseSpecification= responseSpecificationForSsoToken(contentType, StatusCode.valueOf("OK").getResource());


        JSONObject params = new JSONObject();
        requestSpecification.body(SsoObjectToJson.parseSso());

       response= requestSpecification.given().log().all().when().post().then().log().all().spec(responseSpecification).extract().response();

        System.out.println("tanu22");
        System.out.println("Response of token "+response.getBody().asString());








    }

    @When("I make the {string} request")
    public void iMakeTheRequest(String method) {
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
        System.out.println(resp.asString());
    }
}
