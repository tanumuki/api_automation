package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.MatchingMatch.MatchingMatchPojo;
import validators.MatchingMatchValidator;

public class MatchingMatchSteps {
    @Then("The Matching Match API returns response with status code {int} and the entity type matches with the {string}")
    public void theMatchingMatchAPIReturnsResponseWithStatusCodeAndTheEntityTypeMatchesWithUrl(int expectedStatusCode, String url) throws JsonProcessingException {
        String entityType = url.split("/")[4];
        if (entityType.equalsIgnoreCase("playlist") || entityType.equalsIgnoreCase("featured"))
            entityType = "playlists";
        else if (entityType.equalsIgnoreCase("song"))
            entityType = "songs";
        else if (entityType.equalsIgnoreCase("album"))
            entityType = "albums";
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(GenericSteps.resp.getStatusCode(), expectedStatusCode, "Response code validation failed for user update API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        MatchingMatchPojo matchingMatchPojo = objectMapper.readValue(GenericSteps.resp.asString(), MatchingMatchPojo.class);
        new MatchingMatchValidator().validate(matchingMatchPojo, sa, entityType);
        sa.assertAll();
    }
}
