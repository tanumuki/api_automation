package testcases;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class BaseTest {

	
	@Test
	public void requestSpecBuilder() throws JsonMappingException, JsonProcessingException {
		
//		
//		
//
//		RequestSpecification req	=new RequestSpecBuilder().setBaseUri("https://www.saavn.com")
//			.addQueryParam("__call", "user.login")
//			.addQueryParam("username", "tanu@saavn.com")
//			.addQueryParam("password", "Tanu1234")
//			.addQueryParam("api_version", "4")
//			.addQueryParam("_format", "json")
//			.addQueryParam("_marker", "0")
//			.addQueryParam("ctx", "android").setContentType(ContentType.JSON).build();
//			
//		
//		ResponseSpecification respec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.fromContentType("text/html; charset=UTF-8")).build();
//		
//		RequestSpecification res = given().spec(req);
//		Response resp = res.when().get("/api.php").then().spec(respec).extract().response();
//			
//		String response= resp.asString();
//		System.out.println("meow "+response);
//		
		
	}
	
	
	
	
}
