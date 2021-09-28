package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import pojos.podcastGetAllCategories.PodcastGetAllCategories;

import resources.Util;
import validators.PodcastGetAllCategories.PodcastGetAllCategoriesValidator;


public class PodcastsGetAllCategories extends Util {

    @Then("Podcasts get all categories response must be validated successfully")
    public void podcasts_get_all_categories_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        PodcastGetAllCategories pg = mapper.readValue(GenericSteps.resp.asString(), PodcastGetAllCategories.class);
        SoftAssert sa  = new SoftAssert();
        new PodcastGetAllCategoriesValidator().validate(pg, sa);
        sa.assertAll();
    }
}
