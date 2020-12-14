package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.searchGetResultsFromEntities.SearchGetResultsFromEntities;
import validators.SearchGetResultsFromEntitiesValidator;

public class SearchGetResultsFromEntitiesSteps {
    @Then("The Search Get Results from Entities API returns response with status code {int}")
    public void theSearchGetResultsFromEntitiesAPIReturnsResponseWithStatusCode(int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(expectedStatusCode, GenericSteps.resp.getStatusCode(), "Response code validation failed for user update API");

        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        SearchGetResultsFromEntities searchGetResultsFromEntities = objectMapper.readValue(GenericSteps.resp.asString(), SearchGetResultsFromEntities.class);

        new SearchGetResultsFromEntitiesValidator().validate(searchGetResultsFromEntities,sa);

        sa.assertAll();

    }
}
