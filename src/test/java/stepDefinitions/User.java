package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

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
import login_pojos.UserLogin;
import resources.Util;
import validators.UserLoginValidator;

public class User extends Util {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response resp;

	@Given("Add login payload with context {string} and user calls {string} with get http request with username as {string} and password as {string}")
	public void add_login_payload_with_context_and_user_calls_with_get_http_request_with_username_as_and_password_as(
			String ctx, String endPoint, String username, String password) throws IOException {
		System.out.println("tan " + ctx);
		APIResources resourceAPI = APIResources.valueOf(endPoint);
		String resource = resourceAPI.getResource();
		System.out.println("respurce api " + resourceAPI.getResource());
		res = given().spec(requestSpecification(ctx, resource, username, password));

	}

	@When("User calls {string} https request")
	public void user_calls_https_request(String method) {
		resspec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.fromContentType("text/html;charset=UTF-8")).build();

		if (method.equalsIgnoreCase("GET")) {
			System.out.println("tan3 " + resspec);

			resp = res.when().get("/api.php").then().log().all().spec(resspec).extract().response();

		}
		if (method.equalsIgnoreCase("POST")) {

		}

	}

	@Then("The API returns success with status code {string}")
	public void the_API_returns_success_with_status_code(String string)
			throws JsonMappingException, JsonProcessingException {
		SoftAssert sa = new SoftAssert();
		System.out.println("the response is  " + resp.asString());

		assertEquals(resp.getStatusCode(), 200);

		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);
		UserLogin login = objectMapper.readValue(resp.asString(), UserLogin.class);

		new UserLoginValidator().validate(login, sa);
		sa.assertAll();
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String Expectedvalue) {

		String response = resp.asString();
		JsonPath js = new JsonPath(response);
		System.out.println("username " + js.get("data.username"));

		// check username

	}

}
