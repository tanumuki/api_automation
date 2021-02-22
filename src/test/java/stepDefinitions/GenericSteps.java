package stepDefinitions;


import endPoints.APIResources;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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
    static RequestSpecification request = null;
    static Response resp;
    static String apiResource;
    static String cookie;

    @Given("I have the endpoint for {string}")
    public void iHaveTheEndopointFor(String endPoint) throws FileNotFoundException {
        apiResource = APIResources.valueOf(endPoint).getResource();
        request = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), apiResource, cookie));
    }

    @When("I make the {string} request with the following query parameters")
    public void iMakeTheRequestWithTheFollowingQueryParameters(String method, DataTable queryParams) throws IOException {
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


    public static void  iMakeTheRequestWithParameterPassedInMethod(HashMap<String, String> params) {
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
