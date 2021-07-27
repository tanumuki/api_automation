package validators.JiotunepageCallerTunes;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Entity;
import entities.ModulesData;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.JiotunepageCallerTune.ArtistCallerTuneContainer;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.ModulesDataValidator;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class JiotunepageArtistCallerTuneHomeValidator extends EntityValidator {
    final String className = getClass().getName();

    public void validate(ArtistCallerTuneContainer artistCaller, SoftAssert sa) throws IOException {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asNum(artistCaller.getLastPage()), AssertionMsg.print(className, methodName, "last_page", (artistCaller.getLastPage()).toString()));
        log.info("Last_page field is validated.");

        /**
         * Validation for popular_artist_tune array of object
         */
        if(artistCaller.getPopularArtistTune().size() > 0) {
            for (Entity entity : artistCaller.getPopularArtistTune()) {
                super.validate(entity, sa);
            }
        }else {
            sa.fail("Popular Artist Tune section is empty.");
        }

        /**
         * Validation for all_artist_tune array of object
         */
        if(artistCaller.getAllArtistTune().entrySet().size() > 0) {
            for (Map.Entry<String, Entity[]> data : artistCaller.getAllArtistTune().entrySet()) {
                for (Entity entity : data.getValue()) {
                    super.validate(entity, sa);
                }
            }
        }else {
            sa.fail("All Artist Tune section is empty.");
        }

        /**
         * Validation for modules.popular_artist_tune object
         */
        ModulesData modulesData = artistCaller.getModules().getPopularArtistTune();
        ModulesDataValidator.validate(modulesData, sa);

        /**
         * Validation for modules.all_artist_tune
         */
        ModulesData modulesData1 = artistCaller.getModules().getAllArtistTuneInModules();
        ModulesDataValidator.validate(modulesData1, sa);
    }
}

