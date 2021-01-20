package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import endPoints.Context;
import enums.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.asserts.SoftAssert;
import pojos.login_pojos.UserLogin;
import resources.*;
import validators.UserLoginValidator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Login extends Util {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;
	String cookie="";
	public ScenarioContext scenarioContext;
	String username;
	String password;
	

	@Given("Add payload with login endpoint {string}")
	public void add_payload_with_login_endpoint(String endPoint) throws Exception {
		APIResources resourceAPI = APIResources.valueOf(endPoint);
		String resource = resourceAPI.getResource();
		//UserGenerator user = UserGenerator.getInstance();
		//HashMap<String, String> userMap = user.generateNewUserCookie();
		//cookie= userMap.get("cookie");
		//appending cookie with device_id
		String device= "device_id= 8yEi4ih9eJxp9H1IUk6LcVyJnienvB1gnXph5GTxFn8%3D";
		cookie=cookie+device;
		System.out.println("cookie2 is " +cookie);
		//username = userMap.get("username");
		//password = userMap.get("password");
		testContext.scenarioContext.setContext(Context.USERNAME, username);
		testContext.scenarioContext.setContext(Context.PASSWORD, password);
		System.out.println("resource api " + resourceAPI.getResource());
		res = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
	}


	@When("User calls with method with below params")
	public void user_calls_with_method_with_below_params(io.cucumber.datatable.DataTable table) {
		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();

		String method="";

		String username = (String) testContext.scenarioContext.getContext(Context.USERNAME);
		String password = (String) testContext.scenarioContext.getContext(Context.PASSWORD);
		System.out.println("ussername is " +username + "and" +password);

		method = table.cell(1, 0);
		System.out.println("method is "+method);
		 System.out.println("The value1 is : " + table.cell(1, 0));
	        System.out.println("The value2 is : " + table.cell(1, 1));

	        List<List<String>> cells = table.cells();

	        System.out.println("The value3 is : " + cells.get(1).get(2));
	        System.out.println("The value4 is : " + cells.get(1).get(3));
	        //System.out.println("The username is : " + username);
	        //System.out.println("The password is : " + password);

		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
			System.out.println("tan3 " + resspec);

			System.out.println("toto" + table.asList().toString());
			res.queryParam("username", cells.get(1).get(2));
			res.queryParam("password", cells.get(1).get(3));
			resp = res.given().log().all().when().get("/api.php").then().log().all().spec(resspec).extract().response();
			logResponseTime(resp);

		}
	
	}

	@Then("The Login API returns success with status code {string}")
	public void the_Login_API_returns_success_with_status_code(String statusCode)throws JsonMappingException, JsonProcessingException {
		SoftAssert sa = new SoftAssert();
		
		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		System.out.println("the code is  " + resource);

		System.out.println("the response is  " + resp.body().asString());

		assertEquals(resp.getStatusCode(), resource);

		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

				
		UserLogin login = objectMapper.readValue(resp.asString(), UserLogin.class);
		System.out.println("userlogin2 "+login.toString());
		new UserLoginValidator().validate(login, sa);

	}
	@Then("The Login API returns success with status code {string} for invalid credentials")
	public void the_login_api_returns_success_with_status_code_for_invalid_credentials(String statusCode) throws JsonProcessingException {
		// Write code here that turns the phrase above into concrete actions

		SoftAssert sa = new SoftAssert();

		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		System.out.println("the code is  " + resource);

		//System.out.println("the response is  " + resp.body().asString());
		JsonPath path = new JsonPath( resp.body().asString());
	   String error = path.getString("error");
       System.out.println("server error is "+error);
		assertEquals(resp.getStatusCode(), resource);

		String errorString = "[msg:Incorrect username/password. Please try again.]";
		System.out.println("errorString is "+errorString);
		sa.assertTrue(error.equals(errorString), "Error message doesn't match" );
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);


		UserLogin login = objectMapper.readValue(resp.asString(), UserLogin.class);
		sa.assertAll();
	}

}
