package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import endPoints.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojos.login_pojos.UserLogin;
import resources.APIConstants;
import resources.ConfigReader;
import resources.Util;
import statusCodes.StatusCode;
import validators.UserLoginValidator;

public class Login extends Util {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;
	

	@Given("Add payload with login endpoint {string}")
	public void add_payload_with_login_endpoint(String endPoint) throws IOException {
		APIResources resourceAPI = APIResources.valueOf(endPoint);
		String resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
	}


	@When("User calls with method with below params")
	public void user_calls_with_method_with_below_params(io.cucumber.datatable.DataTable table) {
		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();

		String method="";
		
		
		method = table.cell(1, 0);
		System.out.println("method is "+method);
		 System.out.println("The value is : " + table.cell(1, 0));
	        System.out.println("The value is : " + table.cell(1, 1));

	        List<List<String>> cells = table.cells();

	        System.out.println("The value is : " + cells.get(1).get(0));
	        System.out.println("The value is : " + cells.get(1).get(1));
	        System.out.println("The username is : " + cells.get(1).get(2));
	        System.out.println("The password is : " + cells.get(1).get(3));

		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
			System.out.println("tan3 " + resspec);

			System.out.println("toto" + table.asList().toString());
			res.queryParam("username", cells.get(1).get(2));
			res.queryParam("password", cells.get(1).get(3));
			resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();

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
	
		new UserLoginValidator().validate(login, sa);

	}


}
