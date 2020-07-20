package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import com.sun.xml.xsom.impl.Ref.ContentType;

import cookieManager.GetCookies;
import endPoints.APIResources;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIConstants;
import resources.ConfigReader;
import resources.Util;
import statusCodes.StatusCode;

public class LibaryOps extends Util {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;


	@Given("Add payload with get library endpoint {string} and account credentials for cookie")
	public void add_payload_with_get_library_endpoint_and_account_credentials_for_cookie(String endPoint) throws IOException {
		
		APIResources resourceAPI = APIResources.valueOf(endPoint);
		String resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		String cookie = GetCookies.initCookies(ConfigReader.getInstance().getUsername(), ConfigReader.getInstance().getPassword());
		System.out.println("Cookie "+cookie);
		res = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));	

	}

	@When("User calls method with below params")
	public void user_calls_method_with_below_params(io.cucumber.datatable.DataTable table) throws Throwable {
		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();

		String method = "";

		method = table.cell(1, 0);
		System.out.println("method is " + method);
		System.out.println("The value is : " + table.cell(1, 0));
		System.out.println("The value is : " + table.cell(1, 1));

		List<List<String>> cells = table.cells();

		System.out.println("The value is : " + cells.get(1).get(0));
		System.out.println("The value is : " + cells.get(1).get(1));

		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
			System.out.println("tan3 " + resspec);

			System.out.println("toto" + table.asList().toString());
			res.queryParam("username", ConfigReader.getInstance().getUsername());
			res.queryParam("password",  ConfigReader.getInstance().getPassword());
			resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();

		}
		if (method.equalsIgnoreCase("POST")) {

		}
	}

	@Then("The API returns success with status code {string}")
	public void the_API_returns_success_with_status_code( String statusCode) throws Throwable {


		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		System.out.println("the code is  " + resource);

		System.out.println("the response is  " + resp.body().asString());

		assertEquals(resp.getStatusCode(), resource);
	}


}
