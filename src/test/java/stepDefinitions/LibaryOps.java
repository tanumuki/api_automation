package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import lombok.extern.slf4j.Slf4j;
import pojos.libraryOps.LibraryData;
import resources.APIConstants;
import resources.ConfigReader;
import resources.Context;
import resources.TestContext;
import resources.Util;
import statusCodes.StatusCode;
import validators.LibraryValidator;

@Slf4j
public class LibaryOps extends Util {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;
	String cookie;
	TestContext testContext;
	
	
	
	
	
	
	@Given("user hits {string}")
	public void user_hits(String endPoint) throws Exception {
		APIResources resourceAPI = APIResources.valueOf(endPoint);
		String resource = resourceAPI.getResource();
		HashMap<String, String> userMap = Util.generateNewUser();
		 cookie = userMap.get("cookie");
		 System.out.println("Coookie "+cookie);
		//testContext.scenarioContext.setContext(resources.Context.COOKIE, cookie);
		// new TestContext().scenarioContext.setContext(Context.COOKIE, userMap);
		log.info("Username is " + userMap.get("username"));
		res = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
	}

//	@When("user calls GET method")
//	public void user_calls_GET_method() {
//		resp = res.given().log().all().when().get("/api.php").then().log().all().spec(resspec).extract().response();
//
//		
//	}
//
//	@Then("user gets cookie with status code {string}")
//	public void user_gets_cookie_with_status_code(String statusCode) {
//		StatusCode code = StatusCode.valueOf(statusCode);
//		int resource = code.getResource();
//		System.out.println("the code is  " + resource);
//		System.out.println("cookie in response " + resp.getHeaders());
//		System.out.println("the response is  " + resp.body().asString());
//
//		assertEquals(resp.getStatusCode(), resource);
//		
//	}
//	
//	
	
	
	
	
	
	
	


	@Given("Add payload with get library endpoint {string} and account credentials for cookie")
	public void add_payload_with_get_library_endpoint_and_account_credentials_for_cookie(String endPoint)
			throws Exception {

		APIResources resourceAPI = APIResources.valueOf(endPoint);
		String resource = resourceAPI.getResource();
		//HashMap<String, String> userMap = Util.generateNewUser();
		 //cookie = userMap.get("cookie");
		//testContext.scenarioContext.setContext(resources.Context.COOKIE, cookie);
		// new TestContext().scenarioContext.setContext(Context.COOKIE, userMap);
		//log.info("Username is " + userMap.get("username"));
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
			res.queryParam("password", ConfigReader.getInstance().getPassword());
			resp = res.given().log().all().when().get("/api.php").then().log().all().spec(resspec).extract().response();

		}
		if (method.equalsIgnoreCase("POST")) {

		}
		logResponseTime(resp);
	}

	@Then("The Library API returns success with status code {string}")
	public void the_Library_API_returns_success_with_status_code(String statusCode) throws Throwable {

		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		System.out.println("the code is  " + resource);
		System.out.println("cookie in response " + resp.getHeaders());
		System.out.println("the response is  " + resp.body().asString());

		assertEquals(resp.getStatusCode(), resource);
	}

	@And("Validate the library data for new user")
	public void validate_the_library_data_for_new_user() throws JsonMappingException, JsonProcessingException {
		SoftAssert sa = new SoftAssert();

	
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);				
		LibraryData library = objectMapper.readValue(resp.asString(), LibraryData.class);	
		new LibraryValidator().validate(library, sa);
		sa.assertAll();
	
	}
	

	
	
	@Given("Add payload with add library endpoint {string} with the same account credentials")
	public void add_payload_with_add_library_endpoint_with_the_same_account_credentials(String endPoint) throws Exception {

		System.out.println("cookie here " +cookie);
		// String cookie1 =(String) testContext.scenarioContext.getContext(Context.COOKIE);
		//	System.out.println("cookie 2 " +cookie1);

			APIResources resourceAPI = APIResources.valueOf(endPoint);
			String resource = resourceAPI.getResource();
			res = given().spec(
					requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
			System.out.println("res2 "+res.toString());

		}
		
	

	@When("User calls method with below param")
	public void user_calls_method_with_below_param(io.cucumber.datatable.DataTable table) {
		
		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();

		
		//steps to handle Data Table
		List<Map<String,String>> data = table.asMaps();
		System.out.println("my data" +data.get(0));
		String method= data.get(0).get("method");	
		System.out.println("yo 1 " +data.get(0).get("entity_ids") );
		System.out.println("yo 2 " +data.get(0).get("entity_type") );

		
		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {

				res.queryParam("entity_ids",data.get(0).get("entity_ids") );
				res.queryParam("entity_type",data.get(0).get("entity_type") );
				System.out.println("res3 "+res.toString());
				resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
			
		
	}
	}
	
	

	@Then("Validate the library data by calling endpoint {string}")
	public void validate_the_library_data_by_calling_endpoint(String statusCode) {
	   
		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		System.out.println("the code is  " + resource);
		System.out.println("cookie in response " + resp.getHeaders());
		System.out.println("the response is  " + resp.body().asString());

		assertEquals(resp.getStatusCode(), resource);
		
		
	}


}
