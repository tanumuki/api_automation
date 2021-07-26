package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.login_pojos.UserLogin;
import resources.UserGenerator;
import resources.Util;
import validators.UserLoginValidator;

import java.util.HashMap;


@Slf4j
public class UserCreateV2 extends Util {
	Response resp;
	HashMap<String, String> userMap;


	@When("I make the {string} request for the userCreateV2 API")
	public void i_make_the_request_for_the_user_create_v2_api(String method) throws Exception {
		UserGenerator user = UserGenerator.getInstance();
		userMap = user.getRandomUsernameEmail();
		GenericSteps.iMakeTheRequestWithParameterPassedInMethod(userMap);
	}

	@And("The user account was created successfully")
	public void the_user_account_was_created_successfully() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		SoftAssert sa = new SoftAssert();

		UserLogin login = mapper.readValue(GenericSteps.resp.asString(), UserLogin.class);

//		Mandatory validations for signup
		String createdUsername = login.getData().getUsername();
		String createdEmail = login.getData().getEmail();
		String emailVerifiedStatus = login.getData().getEmailVerifiedStatus();
		boolean requireOTP = login.getData().getRequireOtp();

//		Validate email
		sa.assertEquals(createdEmail, userMap.get("email"),
				"Requested email: " + userMap.get("email")
						+ ", but created email: " + createdEmail);

//		Validate username
		sa.assertEquals(createdUsername, userMap.get("username"),
				"Requested username: " + userMap.get("username")
						+ ", but created username: " + createdUsername);

//		Validate email verified status
		sa.assertEquals(emailVerifiedStatus, "new_unverified",
				"Expected new_unverified, but found: " + emailVerifiedStatus);

//		Validate require OTP
		sa.assertTrue(requireOTP, "Expected true, but found: " + requireOTP);

		new UserLoginValidator().validateData(login, sa);
		sa.assertAll();
	}

	@But("The user account does not get created and responds with {string}")
	public void the_user_account_does_not_get_created(String expectedErrorMessage) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		SoftAssert sa = new SoftAssert();

		UserLogin login = mapper.readValue(GenericSteps.resp.asString(), UserLogin.class);
		new UserLoginValidator().validateError(login, sa, expectedErrorMessage);

		sa.assertAll();
	}


}
