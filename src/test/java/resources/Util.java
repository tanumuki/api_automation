package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import login_pojos.UserLogin;

public class Util {
	
	public static RequestSpecification  request ;
	
	public RequestSpecification requestSpecification(String ctx, String endPoint) throws IOException {
		
		if(request==null) {
			PrintStream log = new PrintStream(new FileOutputStream("Output.txt"));

			 request	=new RequestSpecBuilder().setBaseUri(ConfigReader.getInstance().getBaseUrl())
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.addQueryParam("__call", endPoint)
				.addQueryParam("api_version", "4")
				.addQueryParam("_format", "json")
				.addQueryParam("_marker", "0")
				.addQueryParam("app_version", ConfigReader.getInstance().getAppVersion())
				.addQueryParam("v", ConfigReader.getInstance().getVersion())
				.addQueryParam("ctx", ctx).setContentType(ContentType.JSON).build();
		}
		 return request;
		
	}
	
	public static void getOpsWithQueryParams(String url, Map <String, String> queryParam) {
		
		//request.q
		
		
	}
	
	
	public RequestSpecification  requestSpecificationWithHeaders(String ctx, String endPoint, String username, String password, String cookie) throws FileNotFoundException {
		
		if(request==null) {
			PrintStream log = new PrintStream(new FileOutputStream("Output.txt"));

			 request	=new RequestSpecBuilder().setBaseUri(ConfigReader.getInstance().getBaseUrl())
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.addQueryParam("__call", endPoint)
				.addQueryParam("username", username)
				.addQueryParam("password", password)
				.addQueryParam("api_version", "4")
				.addQueryParam("_format", "json")
				.addQueryParam("_marker", "0")
				.addQueryParam("app_version", "6.1")
				.addQueryParam("v", "211.0")
				.addQueryParam("ctx", ctx).setContentType(ContentType.JSON).build();
		}
		 return request;
	}
	
	//https://www.baeldung.com/rest-assured-header-cookie-parameter
	
	
	public static String getGlobalValue(String key) throws IOException {
		
		Properties property = new Properties();
		FileInputStream fs = new FileInputStream("src/test/java/resources/global.properties");
		property.load(fs);
		return property.getProperty(key);	 
	
	}
	
	public static String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js= new JsonPath(resp);
		return js.get(key).toString();			
	}
	
	
//	public static objectMapper() {
//		
//		
//		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
//		UserLogin login= objectMapper.readValue(resp.asString(), UserLogin.class);
//		
//		
//	}
//	

}
