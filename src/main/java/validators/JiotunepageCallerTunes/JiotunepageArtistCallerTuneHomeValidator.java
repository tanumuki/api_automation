package validators.JiotunepageCallerTunes;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Entity;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.JiotunepageCallerTune.ArtistCallerTuneContainer;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class JiotunepageArtistCallerTuneHomeValidator extends EntityValidator {
    final String className = getClass().getName();

    public void validate(Response response, ArtistCallerTuneContainer artistCaller, SoftAssert sa) throws IOException {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asNum(artistCaller.getLastPage()), AssertionMsg.print(className, methodName, "last_page", (artistCaller.getLastPage()).toString()));
        log.info("Last_page field is validated.");

        /**
         * Validation for popular_artist_tune array of object
         */
        for (Entity entity : artistCaller.getPopularArtistTune()) {
            super.validate(entity, sa);
        }

        /**
         * Validation for popular_artist_tune array of object
         */
        for (Map.Entry<String, Entity[]> data : artistCaller.getAllArtistTune().entrySet()) {
            for (Entity entity : data.getValue()) {
                super.validate(entity, sa);
            }
        }

        /**
         * Validation for modules.popular_artist_tune object
         */
        Entity entity = artistCaller.getModules().getPopularArtistTune();
        super.validate(entity, sa);

        /**
         * Validation for modules.all_artist_tune
         */
//        ObjectMapper objectMapper = new ObjectMapper();
//        Entity entity = objectMapper.readValue(response.jsonPath().getJsonObject("allArtistTuneInModules"), Entity.class);
        Entity entity1 = artistCaller.getModules().getAllArtistTuneInModules();
        super.validate(entity1, sa);
    }
}

