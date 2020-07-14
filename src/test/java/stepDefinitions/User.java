package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

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
import login_pojos.UserLogin;
import resources.ConfigReader;
import resources.Util;





public class User extends Util {


	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;

	
	
	
//	@Given("Add login payload with context {string} and user calls {string} with get http request with username as {string} and password as {string}")
//	public void add_login_payload_with_context_and_user_calls_with_get_http_request_with_username_as_and_password_as(String endPoint) throws IOException {
//		 APIResources resourceAPI  = APIResources.valueOf(endPoint); 
//		 String resource = resourceAPI.getResource();
//		 System.out.println("respurce api "+resourceAPI.getResource());
//		 res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(),resource));	
//			
//	}
	
	
	@Given("Add payload with login endpoint {string}")
	public void add_payload_with_login_endpoint(String endPoint) throws IOException {
		APIResources resourceAPI  = APIResources.valueOf(endPoint); 
		 String resource = resourceAPI.getResource();
		 System.out.println("respurce api "+resourceAPI.getResource());
		 res = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(),resource));		    throw new io.cucumber.java.PendingException();
	}
	
	
//	
//	@When("User calls {string} https request")
//	public void user_calls_https_request(String method) {
//		 resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
//
//		 
//		 if(method.equalsIgnoreCase("GET")) {
//			 System.out.println("tan3 "+resspec);
//			res.queryParam("username", "tanu@saavn.com");
//			res.queryParam("password", "Tanu1234");
//	  		 resp= res.when().get("/api.php").then().log().all().spec(resspec).extract().response(); 
//	  		 
//		 }
//		 if(method.equalsIgnoreCase("POST")) {
//			 
//		 }
//			
//	}
	
	@When("User calls {string} https request with username {string} and password {string}")
	public void user_calls_https_request_with_username_and_password(String method, String username, String password) {
 resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
		 
		 if(method.equalsIgnoreCase("GET")) {
			 System.out.println("tan3 "+resspec);
			res.queryParam("username", username);
			res.queryParam("password", password);
	  		 resp= res.when().get("/api.php").then().log().all().spec(resspec).extract().response(); 
	  		 
		 }
		 if(method.equalsIgnoreCase("POST")) {
			 
		 }	    throw new io.cucumber.java.PendingException();
	}
	

	

	@Then("The API returns success with status code {string}")
	public void the_API_returns_success_with_status_code(String string) throws JsonMappingException, JsonProcessingException {
		
			System.out.println("the response is  " +resp.asString());
			
			assertEquals(resp.getStatusCode() , 200);
			
			
			
			ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
			UserLogin login= objectMapper.readValue(resp.asString(), UserLogin.class);
			
			String product = login.getProstatus().getProduct();
			System.out.println("get pro status " +login.getProstatus().toString());

			System.out.println("product  is " +product);
			
			//get product type
			System.out.println("pro sta " +login.getProstatus().getOfferTrial());
				Integer time = login.getProstatus().getExpirationTimestamp();
				System.out.println("exp time stamp is " +time);
			//get data -email
				System.out.println("email " +login.getData().getEmail());
				//get network
				System.out.println("network " +login.getData().getNetwork());
				
				//get fbid
				System.out.println("fb id " +login.getData().getFbid());
				
				//get reg date
				System.out.println("reg date " +login.getData().getRegdate());
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String Expectedvalue) {
		
			String response = resp.asString();
		JsonPath js = new JsonPath(response);
		System.out.println("username "+js.get("data.username"));
		
		//check username
		
		
		

	}



	
}
