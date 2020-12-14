package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.contentGetTopSearches.ContentGetTopSearchesPojo;
import validators.ContentGetTopSearchesValidator;

import java.util.List;

public class ContentGetTopSearchesSteps {
    @Then("The Content Get Top Searches API returns response with status code {int}")
    public void theContentGetTopSearchesAPIReturnsResponseWithStatusCode(int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for user update API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        List<ContentGetTopSearchesPojo> contentGetTopSearchesObj = objectMapper.readValue(GenericSteps.resp.asString(), new TypeReference<List<ContentGetTopSearchesPojo>>() {
        });

        int i=0;
        for (ContentGetTopSearchesPojo contentGetTopSearchesPojo : contentGetTopSearchesObj)
        {
            System.out.println("Validating response for entity: "+ ++i);
            new ContentGetTopSearchesValidator().validate(contentGetTopSearchesPojo,sa);
        }
        sa.assertAll();
    }
}
