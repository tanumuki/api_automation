package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Album;
import entities.AlbumData;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import resources.ConfigReader;
import resources.Util;
import validators.Content.ContentGetALbiumsValidator;
import validators.genericValidators.AlbumValidator;
import java.util.List;

public class ContentGetAlbums extends Util {

    @Then("Get albums api response must be validated successfully")
    public void get_albums_api_response_must_be_validated_successfully() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        SoftAssert sa = new SoftAssert();
        String ctx = ConfigReader.getInstance().getCtx();
        if (ctx.equalsIgnoreCase("androidgo")) {
            List<Album> albums = mapper.readValue(GenericSteps.resp.asString(), new TypeReference<List<Album>>() {
            });
            for (Album album : albums) {
                new AlbumValidator().validate(album, sa);
            }
        } else {
            AlbumData albumData = mapper.readValue(GenericSteps.resp.asString(), AlbumData.class);
            new ContentGetALbiumsValidator().validate(albumData, sa);
        }
        sa.assertAll();
    }
}
