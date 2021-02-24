package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.channelGetDetailsPojos.ChannelGetDetails;
import validators.Artist.ArtistPageValidator;
import validators.ChannelGetDetails.ChannelGetDetailsValidator;
import validators.genericValidators.AlbumValidator;
import validators.genericValidators.MixDetailsValidator;
import validators.genericValidators.SongValidator;
import validators.showGetHome.ShowGetHomeValidator;

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
        System.out.println(deeplink);
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


//            Artist contentDecodeTokenAndFetchResultsPojo = objectMapper.readValue(GenericSteps.resp.asString(), Artist.class);
//            new ArtistPageValidator().validateAll(contentDecodeTokenAndFetchResultsPojo, sa);
    }

    @Then("The Content Decode and Fetch Token API returns response with status code {int} for entity type {string}")
    public void theContentDecodeAndFetchTokenAPIReturnsResponseWithStatusCodeForEntityType(int expectedStatusCode, String entity_type) throws JsonProcessingException {
        SoftAssert sa = new SoftAssert();
        Assert.assertEquals(GenericSteps.resp.getStatusCode(), expectedStatusCode, "Response code validation failed for user update API");
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        Object contentDecodeTokenAndFetchResultsPojo;
        switch (entity_type) {
            case "Shorties":
                contentDecodeTokenAndFetchResultsPojo = objectMapper.readValue(GenericSteps.resp.asString(), ChannelGetDetails.class);
                new ChannelGetDetailsValidator().validate((ChannelGetDetails) contentDecodeTokenAndFetchResultsPojo, sa);
                sa.assertAll();
                break;
            case "Artists":
                contentDecodeTokenAndFetchResultsPojo = objectMapper.readValue(GenericSteps.resp.asString(), Artist.class);
                new ArtistPageValidator().validate((Artist)contentDecodeTokenAndFetchResultsPojo, sa);
                sa.assertAll();
                break;
            case "Songs":
                contentDecodeTokenAndFetchResultsPojo = objectMapper.readValue(GenericSteps.resp.asString(), Song.class);
                for (Song song : ((Song) contentDecodeTokenAndFetchResultsPojo).getSongs())
                {
                    new SongValidator().validate(song, sa);
                }
                sa.assertAll();
                break;
            case "Albums":
                contentDecodeTokenAndFetchResultsPojo= objectMapper.readValue(GenericSteps.resp.asString(), Album.class);
                new AlbumValidator().validate((Album)contentDecodeTokenAndFetchResultsPojo, sa);
                sa.assertAll();
                break;
            case "Playlists":
                contentDecodeTokenAndFetchResultsPojo= objectMapper.readValue(GenericSteps.resp.asString(), MixDetails.class);
                new MixDetailsValidator().validate((MixDetails) contentDecodeTokenAndFetchResultsPojo,sa);
                sa.assertAll();
                break;
            case "Shows":
                contentDecodeTokenAndFetchResultsPojo= objectMapper.readValue(GenericSteps.resp.asString(), ShowGetHome.class);
                new ShowGetHomeValidator().validate((ShowGetHome)contentDecodeTokenAndFetchResultsPojo, sa);
                sa.assertAll();
                break;
        }
    }

}
