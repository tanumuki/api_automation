package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.Song;
import entities.UserProfilePlaylists;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.user_pojos.UserChangePassword.UserChangePasswordFailure;
import pojos.user_pojos.UserChangePassword.UserChangePasswordSuccess;
import pojos.user_pojos.UserGetProfile;
import pojos.user_pojos.UserProfileUpdate;
import resources.ConfigReader;
import resources.Util;
import validators.UserPofileDataValidator;
import validators.genericValidators.PlaylistValidator;
import validators.genericValidators.SongValidator;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static cookieManager.GetCookies.initCookies;
import static io.restassured.RestAssured.given;

@Slf4j
public class User extends Util {

    @Then("The User Update API returns {string} with status code {int}")
    public void theUserUpdateAPIReturnsWithStatusCode(String expectedStatus, int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for user update API");
        Assert.assertEquals(expectedStatus, GenericSteps.resp.jsonPath().get("status"), "Status validation failed for user update API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        UserProfileUpdate profileUpdate = objectMapper.readValue(GenericSteps.resp.asString(), UserProfileUpdate.class);

        new UserPofileDataValidator().validate(profileUpdate, sa);
        sa.assertAll();

    }

    @Then("The User Get Profile API returns response with status code {int}")
    public void theUserGetProfileAPIReturnsWithStatusCode(int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for user update API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        UserGetProfile userGetProfile = objectMapper.readValue(GenericSteps.resp.asString(), UserGetProfile.class);
        List<UserProfilePlaylists> playlists = objectMapper.convertValue(GenericSteps.resp.jsonPath().get("playlists"), new TypeReference<List<UserProfilePlaylists>>() {
        });

        new PlaylistValidator().validate(playlists.get(0), sa);

        new UserPofileDataValidator().validateUserProfileInfo(userGetProfile, sa);
        for (UserProfilePlaylists playlist : playlists) {
            new PlaylistValidator().validate(playlist, sa);
        }

        List<Song> songs = objectMapper.convertValue(GenericSteps.resp.jsonPath().get("recent_songs"), new TypeReference<List<Song>>() {
        });
        for (Song song : songs) {
            if (song.getType().equals("song"))
                new SongValidator().validate(song, sa);
        }
        sa.assertAll();

    }

    @Then("The User Logout API returns {string} with status code {int}")
    public void theUserLogoutAPIReturnsResponseWithStatusCode(String expectedStatus, int expectedStatusCode) {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for user update API");
        Assert.assertEquals(expectedStatus, GenericSteps.resp.jsonPath().get("status"), "Status validation failed for user update API");
        sa.assertAll();
    }

    @Then("The User Change Password API returns {string} with status code {int} and response message as {string}")
    public void theUserChangePasswordAPIReturnsResponseWithStatusCode(String expectedStatus, int expectedStatusCode, String responseMessage) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();


        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for user update API");
        if (expectedStatus.equalsIgnoreCase("success")) {
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
            UserChangePasswordSuccess changePasswordSuccess = objectMapper.readValue(GenericSteps.resp.asString(), UserChangePasswordSuccess.class);
            Assert.assertEquals(responseMessage, changePasswordSuccess.getSuccess().getMsg());
        } else
        {
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
            UserChangePasswordFailure changePasswordFailure = objectMapper.readValue(GenericSteps.resp.asString(), UserChangePasswordFailure.class);
            Assert.assertEquals(responseMessage, changePasswordFailure.getError().getMsg());
        }

    }

    @And("I change {string} back to {string}")
    public void iChangeTheBackTo(String currentPassword, String newPassword) throws IOException {
        RequestSpecification request = null;
        Response resp;
        String apiResource = APIResources.valueOf("UserChangePasswordApi").getResource();
        HashMap<String, String> user = new HashMap<String, String>();
        user.put("username", "sun@s.in");
        user.put("password", currentPassword);

        String cookie = initCookies(user.get("username"), user.get("password"));

        request = given().spec(requestSpecificationWithHeaders(ConfigReader.getInstance().getCtx(), apiResource, cookie));

        request.queryParam("oldpassword", currentPassword);
        request.queryParam("password", newPassword);
        resp = request.given()
                .log()
                .all()
                .when()
                .get("/api.php")
                .then()
                .log()
                .all()
                .extract()
                .response();
        logResponseTime(resp);
        System.out.println(resp.asString());
    }
}
