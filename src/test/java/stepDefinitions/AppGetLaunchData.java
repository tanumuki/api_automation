package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import cookieManager.GetCookies;
import endPoints.APIResources;
import enums.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import resources.ConfigReader;
import resources.Util;
import validators.AppGetLaunchData.GetLaunchDataValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

@Slf4j
public class AppGetLaunchData extends Util {

    @Then("App get launch data response must be validated successfully")
    public void app_get_launch_data_response_must_be_validated_successfully() throws JsonProcessingException {
        System.setProperty("ctx", ConfigReader.getInstance().getCtx());
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.appGetLaunchData.AppGetLaunchData agld = mapper.readValue(GenericSteps.resp.asString(), pojos.appGetLaunchData.AppGetLaunchData.class);
        SoftAssert sa  = new SoftAssert();
        log.info("from config appversion2: " + ConfigReader.getInstance().getAppVersion());
        System.setProperty("app_version", ConfigReader.getInstance().getAppVersion());
        new GetLaunchDataValidator().validate(agld, sa);
        sa.assertAll();
    }
}
