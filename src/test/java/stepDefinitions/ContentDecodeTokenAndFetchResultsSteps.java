package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Artist;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import validators.Artist.ArtistPageValidator;
import validators.ChannelGetDetails.ChannelGetDetailsValidator;
import pojos.channelGetDetailsPojos.ChannelGetDetails;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class ContentDecodeTokenAndFetchResultsSteps {
    private String token = null;
    private String type = null;
    private String mainTitle = null;

    @SuppressWarnings("unchecked")
    @And("I fetch token for module {string}")
    public void iFetchTokenForModule(String title) {
        mainTitle = title;
        String deeplink = null;
        LinkedHashMap<String, LinkedHashMap<String, Object>> jsonResponse = GenericSteps.resp.jsonPath().get("modules");
//        if (title.equalsIgnoreCase("Shorties")) {
        for (Map.Entry<String, LinkedHashMap<String, Object>> module : jsonResponse.entrySet()) {
            if (module.getValue().get("title").toString().equalsIgnoreCase(title) || module.getValue().get("source").toString().contains("topic^zs^" + title.toLowerCase() + "^")) {
                System.out.println(module.getValue());
                LinkedHashMap<String, String> view_more = (LinkedHashMap<String, String>) module.getValue().get("view_more");
                deeplink = view_more.get("deeplink");
            }
        }
        type = deeplink.split("/")[3];
        if (type.equalsIgnoreCase("channels"))
            type = "channel";
        token = deeplink.split("/")[4];
    }

    @When("I make the GET request with token")
    public void iMakeTheRequestWithToken() {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", type);
        params.put("token", token);
        GenericSteps.iMakeTheRequestWithParameterPassedInMethod(params);
    }

    @Then("The Content Decode and Fetch Token API returns response with status code {int}")
    public void theContentDecodeAndFetchTokenAPIReturnsResponseWithStatusCode(int expectedStatusCode) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(GenericSteps.resp.getStatusCode(), expectedStatusCode, "Response code validation failed for user update API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        if (mainTitle.equalsIgnoreCase("Shorties")) {
            ChannelGetDetails contentDecodeTokenAndFetchResultsPojo = objectMapper.readValue(GenericSteps.resp.asString(), ChannelGetDetails.class);
            new ChannelGetDetailsValidator().validate(contentDecodeTokenAndFetchResultsPojo, sa);
        }
        else if (mainTitle.equalsIgnoreCase("Artist")){
            Artist contentDecodeTokenAndFetchResultsPojo = objectMapper.readValue(GenericSteps.resp.asString(), Artist.class);
            new ArtistPageValidator().validateAll(contentDecodeTokenAndFetchResultsPojo, sa);
        }
    }
}
