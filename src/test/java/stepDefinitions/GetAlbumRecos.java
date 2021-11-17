package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import endPoints.APIResources;
import entities.AlbumMiniObject;
import entities.AlbumReco;
import enums.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.asserts.SoftAssert;
import resources.ConfigReader;
import resources.Util;
import validators.Validate;
import validators.genericValidators.AlbumMiniValidator;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetAlbumRecos extends Util {

    @Then("User should see the recommendations response validated")
    public void user_should_see_the_recommendations_response_validated() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        SoftAssert sa = new SoftAssert();

        if (ConfigReader.getInstance().getCtx().equalsIgnoreCase("androidgo")) {
            List<AlbumMiniObject> albumMiniObjects = mapper.readValue(GenericSteps.resp.asString(), new TypeReference<List<AlbumMiniObject>>() {
            });
            for (AlbumMiniObject albumMiniObject : albumMiniObjects) {
                new AlbumMiniValidator().validate(albumMiniObject, sa);
            }
        } else {
            AlbumReco albumReco = mapper.readValue(GenericSteps.resp.asString(), AlbumReco.class);

//        Validators
            sa.assertTrue(albumReco.getStatus().equalsIgnoreCase(Validate.API_STATUS_SUCCESS),
                    "Expected \"" + Validate.API_STATUS_SUCCESS + "\", but found: \"" + albumReco.getStatus() + "\"");
            for (AlbumMiniObject album : albumReco.getData()) {
                new AlbumMiniValidator().validate(album, sa);
            }
        }
        sa.assertAll();
    }

}
