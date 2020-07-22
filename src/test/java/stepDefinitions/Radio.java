package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import cookieManager.GetCookies;
import endPoints.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import resources.ConfigReader;
import resources.Util;

public class Radio extends Util {
	
	

	@Given("Add payload with get create station endpoint {string} and language {string}")
	public void add_payload_with_get_create_station_endpoint_and_language(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("stepDefinitions.stepDefinitions.User calls endpoint {string} with the stationId and next=1")
	public void user_calls_endpoint_with_the_stationId_and_next_1(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	

}
