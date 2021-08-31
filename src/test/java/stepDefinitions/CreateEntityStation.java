package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.WebRadioDataSingle;
import enums.StatusCode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import resources.Util;
import validators.GoogleAssistant.GoogleAssistantValidator;

import static org.testng.Assert.assertEquals;

@Slf4j
public class CreateEntityStation extends Util {

    String stationID;
    Response resp;

    @Then("CreateEntityStation response should be validated against the query")
    public void createEntityStationResponseShouldBeValidatedAgainstTheQuery() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        entities.GoogleAssistantGet entityStation = objectMapper.readValue(GenericSteps.resp.asString(), entities.GoogleAssistantGet.class);
        SoftAssert sa = new SoftAssert();
        new GoogleAssistantValidator().validateEntityStationID(entityStation, sa);
        this.stationID = entityStation.stationid;
        sa.assertAll();
    }

    @And("User calls the WebRadioGetSong request with received stationID")
    public void userCallsTheWebRadioGetSongRequestWithReceivedStationID() {
        GenericSteps.request.queryParam("stationid", this.stationID);

        resp = GenericSteps.request.given().log()
                .all()
                .when()
                .get("/api.php")
                .then()
                .log()
                .all()
                .extract()
                .response();
        log.info(resp.asString());
        logResponseTime(resp);

    }

    @And("WebRadioGetSong response should be validated with statuscode {string}")
    public void webradiogetsongResponseShouldBeValidatedWithStatuscode(String statusCode) throws JsonProcessingException {
        StatusCode code = StatusCode.valueOf(statusCode);
        int resource = code.getResource();
        assertEquals(resp.getStatusCode(), resource);
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        WebRadioDataSingle webRadioData = objectMapper.readValue(resp.asString(), WebRadioDataSingle.class);
        SoftAssert sa = new SoftAssert();
        new GoogleAssistantValidator().validateWebRadioSingle(webRadioData, sa, this.stationID);
        sa.assertAll();

    }
}
