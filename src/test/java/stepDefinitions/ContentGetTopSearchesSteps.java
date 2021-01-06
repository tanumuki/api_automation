package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.appGetLaunchData.TopSearch;
import validators.AppGetLaunchData.GetLaunchDataValidator;

import java.util.List;

public class ContentGetTopSearchesSteps {
    @Then("The Content Get Top Searches API returns response with status code {int}")
    public void theContentGetTopSearchesAPIReturnsResponseWithStatusCode(int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for user update API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        List<TopSearch> contentGetTopSearchesObj = objectMapper.readValue(GenericSteps.resp.asString(), new TypeReference<List<TopSearch>>() {
        });

        int i=0;
        for (TopSearch contentGetTopSearchesPojo : contentGetTopSearchesObj)
        {
            System.out.println("Validating response for entity: "+ ++i);
            new GetLaunchDataValidator().validateTopSearches(contentGetTopSearchesPojo,sa);
        }
        sa.assertAll();
    }
}
