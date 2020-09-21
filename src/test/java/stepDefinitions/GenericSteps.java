package stepDefinitions;

import endPoints.APIResources;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static cookieManager.GetCookies.initCookies;
import static io.restassured.RestAssured.given;

import resources.APIConstants;
import resources.ConfigReader;
import resources.Util;

public class GenericSteps extends Util{
    static RequestSpecification request = null;
    static Response resp;
    static String apiResource;

    @Given("I have the endpoint for {string}")
    public void iHaveTheEndopointFor(String endPoint, DataTable userDetails) throws IOException {
        List<Map<String, String>> user = userDetails.asMaps();
        apiResource = APIResources.valueOf(endPoint).getResource();
        String cookie = initCookies(user.get(0).get("username"), user.get(0).get("password"));
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
}
