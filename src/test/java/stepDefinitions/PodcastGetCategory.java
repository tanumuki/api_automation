package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;
import resources.Util;
import validators.PodcastGetAllCategories.PodcastGetAllCategoriesValidator;
import validators.PodcastGetCategory.PodcastGetCategoryValidator;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PodcastGetCategory extends Util {
    Response resp;


    @Then("Podcasts get category response must be validated successfully")
    public void podcasts_get_category_response_must_be_validated_successfully() throws JsonProcessingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        pojos.podcastGetCategory.PodcastGetCategory pg = mapper.readValue(GenericSteps.resp.asString(), pojos.podcastGetCategory.PodcastGetCategory.class);
        SoftAssert sa  = new SoftAssert();
        new PodcastGetCategoryValidator().validate(pg, sa);
        sa.assertAll();
    }
}
