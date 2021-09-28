package stepDefinitions;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import endPoints.Context;
import entities.*;
import enums.StatusCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.asserts.SoftAssert;
import pojos.playlistOps.PlaylistMakePrivatePublic;
import resources.APIConstants;
import resources.ConfigReader;
import resources.ScenarioContext;
import resources.UserGenerator;
import resources.Util;
import validators.PlaylistOpsValidator;
import validators.Validate;
import validators.genericValidators.MixDetailsValidator;

@Slf4j
public class MakePrivatePlaylist extends Util {
    Response resp;
    String listID;


    @When("I make thr {string} request with param listID of the created playlist")
    public void user_calls_method_with_below_params_for_MakePrivatePlaylist(String method) {
        if (method.equalsIgnoreCase(APIConstants.ApiMethods.GET)) {
            listID = (String) testContext.scenarioContext.getContext(Context.PLAYLIST_ID);
            log.info("List ID: "+listID);
            GenericSteps.request.queryParam("listid", listID);
        }

        resp = GenericSteps.request.given()
                .log()
                .all()
                .when()
                .get("/api.php")
                .then()
                .log()
                .all()
                .extract()
                .response();
        log.info(resp.asString());
    }

    @Then("I validate the status code {string} and validate the response")
    public void makePrivatePlaylistReturnsSuccessWithStatusCode(String statusCode) throws JsonProcessingException {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
        log.info("The status is "+ resp.getStatusCode());
        SoftAssert sa = new SoftAssert();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        PlaylistMakePrivatePublic playlist = mapper.readValue(resp.asString(), PlaylistMakePrivatePublic.class);
        new PlaylistOpsValidator().validatePrivatePlaylist(playlist, sa);
        log.info("Validation done for playlist ID "+ playlist.getDetails().getId() +" after making private playlist.");



    }



}



