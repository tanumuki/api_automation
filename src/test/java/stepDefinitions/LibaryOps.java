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

import endPoints.APIResources;
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
import resources.UserGenerator;
import resources.Util;
import statusCodes.StatusCode;
import validators.LibraryValidator;

@Slf4j
public class LibaryOps extends Util {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;
	 String cookie = "";
	String resource ; 


	@Given("Add payload with get library endpoint {string} and account credentials for cookie")
	public void add_payload_with_get_library_endpoint_and_account_credentials_for_cookie(String endPoint)
			throws Exception {
		
		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		UserGenerator user = UserGenerator.getInstance();
		HashMap<String, String> userMap = user.generateNewUser();
		cookie = userMap.get("cookie");
		System.setProperty("cookie", cookie);
		res = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
		log.info("MYCOOKIE1 "+cookie);

	}

	@When("User calls method with below params")
	public void user_calls_method_with_below_params(io.cucumber.datatable.DataTable table) {
		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF-8")).build();
		// code to handle Data Table
		List<Map<String, String>> data = table.asMaps();
		System.out.println("data" + data.get(0));
		String method = data.get(0).get("method");

		if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {

			res.queryParam("n", data.get(0).get("n"));
			res.queryParam("p", data.get(0).get("p"));
			resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
		}

		resp = res.given().log().all().when().get("/api.php").then().log().all().spec(resspec).extract().response();

	}

	@Then("The Library API returns success with a status code {string}")
	public void the_Library_API_returns_success_with_a_status_code(String statusCode) {

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

		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				true);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		LibraryData library = objectMapper.readValue(resp.asString(), LibraryData.class);
		new LibraryValidator().validate(library, sa);
		sa.assertAll();

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Given("Add payload with add library endpoint {string} with the same account credentials")
		public void add_payload_with_add_library_endpoint_with_the_same_account_credentials(String endPoint) throws Exception {
		
		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		cookie = System.getProperty("cookie");
		log.info("MYCOOKIE2 "+cookie);
		res = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));

		
	}

	


	@When("User calls method with below param")
		public void user_calls_method_with_below_param(io.cucumber.datatable.DataTable table) {
			
			resspec = new ResponseSpecBuilder().expectStatusCode(200)
					.expectContentType(io.restassured.http.ContentType.fromContentType("text/html;charset=UTF8")).build();
	
			
			//steps to handle Data Table
			List<Map<String,String>> data = table.asMaps();
			System.out.println("my data" +data.get(0));
			String method= data.get(0).get("method");	
			System.out.println("yo 1 " +data.get(0).get("entity_ids") );
			System.out.println("yo 2 " +data.get(0).get("entity_type") );
	
			
			if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
	
					res.queryParam("entity_ids",data.get(0).get("entity_ids") );
					res.queryParam("entity_type",data.get(0).get("entity_type") );
					System.out.println("res3 " +res.toString());
					resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();
				
			
		}
		}
	
	@Then("The Library API returns success with status code {string}")
	public void the_Library_API_returns_success_with_status_code(String statusCode) {
		 
		System.out.println("cookie here " +cookie);
		StatusCode code = StatusCode.valueOf(statusCode);
		int resource = code.getResource();
		System.out.println("the code is  " + resource);
		
		
		}
	
	@Then("Validate the library data by calling endpoint {string} using same cookie")
	public void validate_the_library_data_by_calling_endpoint_using_same_cookie(String endPoint) throws IOException {
		   
		APIResources resourceAPI = APIResources.valueOf(endPoint);
		resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		cookie= System.getProperty("cookie");
		res = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), resource, cookie));
	}
}
