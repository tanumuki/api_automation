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
import java.util.List;
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
        if (artistCaller.getPopularArtistTune().size() > 0) {
            for (Entity entity : artistCaller.getPopularArtistTune()) {
                super.validate(entity, sa);
            }
        } else {
            sa.fail("Popular Artist Tune section is empty.");
        }

        /**
         * Validation for all_artist_tune array of object
         */
        if (artistCaller.getAllArtistTune().entrySet().size() > 0) {
            for (Map.Entry<String, Entity[]> data : artistCaller.getAllArtistTune().entrySet()) {
                for (Entity entity : data.getValue()) {
                    super.validate(entity, sa);
                }
            }
        } else {
            sa.fail("All Artist Tune section is empty.");
        }

        /**
         * Validation for modules.popular_artist_tune object
         */
        if (artistCaller.getModules() != null) {
            for (Map.Entry<String, ModulesData> entry : artistCaller.getModules().getPopularArtistTune().entrySet()) {
                sa.assertEquals(entry.getKey(), entry.getValue().getSource(),
                        AssertionMsg.print(className, methodName, "modules.popular_artist_tune", entry.getValue().getSource()));
                log.info("The key " + entry.getKey() + " matches with the source value " + entry.getValue().getSource());
                new ModulesDataValidator();
                ModulesDataValidator.validate(entry.getValue(), sa);
                log.info("Validation done for " + entry.getKey());
            }

            /**
             * Validation for modules.all_artist_tune_* object
             */
            for (Map.Entry<String, ModulesData> entry : artistCaller.getModules().getAllArtistTuneInModules().entrySet()) {
                sa.assertEquals(entry.getKey(), entry.getValue().getSource(),
                        AssertionMsg.print(className, methodName, "modules.all_artist_tune_*", entry.getValue().getSource()));
                log.info("The key " + entry.getKey() + " matches with the source value " + entry.getValue().getSource());
                ModulesDataValidator.validate(entry.getValue(), sa);
                log.info("Validation done for " + entry.getKey());
            }

        }
        else{
            sa.fail("Validation failed, modules object should not be empty");
        }
    }
}

