/**
 * 
 */
package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import endPoints.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ConfigReader;
import resources.Util;

/**
 * @author aswingokulachandran
 *
 */
public class AutoCompleteGet extends Util {
	
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Response resp;
	
	@Given("Add payload with search endpoint {string}")
	public void add_payload_with_search_endpoint(String endpoint) throws IOException {
		APIResources resourceAPI = APIResources.valueOf(endpoint);
		String resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());		
		reqSpec = given().spec(requestSpecification(ConfigReader.getInstance().getCtx(), resource));
	}
	
	@When("User calls {string} https request for queries in file {string}")
	public void user_calls_https_request_for_queries_in_filepath(String method, String queryFilePath) throws FileNotFoundException {
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();
		if(method.equalsIgnoreCase("GET")) {
			System.out.println("resSpec: " + resSpec.toString());
			List<String> queries = readFileInToList(queryFilePath);
			for(String query : queries) {
				
			}
		}
	}
			

}
