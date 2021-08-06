package validators.JiotunepageCallerTunes;
import entities.Entity;
import entities.ModulesData;
import entities.MultipleTunes;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.JiotunepageCallerTune.ArtistCallerTuneContainer;
import pojos.JiotunepageCallerTune.NameCallerTuneContainer;
import validators.AssertionMsg;
import validators.MultipleTunesValidator;
import validators.Validate;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.ModulesDataValidator;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class JTPageCallerTuneHomeValidator extends EntityValidator {
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
            if (artistCaller.getModules().getCallerTuneModules().entrySet().size() > 0) {
                for (Map.Entry<String, ModulesData> entry : artistCaller.getModules().getCallerTuneModules().entrySet()) {
                    sa.assertEquals(entry.getKey(), entry.getValue().getSource(),
                            AssertionMsg.print(className, methodName, "artist_tune_modules", entry.getValue().getSource()));
                    log.info("The key " + entry.getKey() + " matches with the source value " + entry.getValue().getSource());
                    new ModulesDataValidator();
                    ModulesDataValidator.validate(entry.getValue(), sa);
                    log.info("Validation done for " + entry.getKey());
                }
            } else {
                sa.fail("Validation failed, the size of the map with modules objects should not be empty.");
            }
        } else {
            sa.fail("Validation failed, modules object should not be empty");
        }
    }

    public void validateNameTune(NameCallerTuneContainer nameTune, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asBoolean(nameTune.getLastPageBool()), AssertionMsg.print(className, methodName, "last_page", (nameTune.getLastPageBool()).toString()));
        log.info("Last_page field is validated.");

        /**
         * Validation for all_name_tune array of objects
         */
        if (nameTune.getAllNameTune().entrySet().size() > 0) {
            for (Map.Entry<String, MultipleTunes[]> data : nameTune.getAllNameTune().entrySet()) {
                for (MultipleTunes tune : data.getValue()) {
                    new MultipleTunesValidator().validate(tune, sa);
                }
            }
        } else {
            sa.fail("All Name Tunes list is empty, Validation fails.");
        }

        /**
         * Validation for modules.all_artist_tune_* object
         */
        if (nameTune.getModules() != null) {
            if (nameTune.getModules().getCallerTuneModules().entrySet().size() > 0) {
                for (Map.Entry<String, ModulesData> entry : nameTune.getModules().getCallerTuneModules().entrySet()) {
                    sa.assertEquals(entry.getKey(), entry.getValue().getSource(),
                            AssertionMsg.print(className, methodName, "artist_tune_modules", entry.getValue().getSource()));
                    log.info("The key " + entry.getKey() + " matches with the source value " + entry.getValue().getSource());
                    new ModulesDataValidator();
                    ModulesDataValidator.validate(entry.getValue(), sa);
                    log.info("Validation done for " + entry.getKey());
                }
            } else {
                sa.fail("Validation failed, the size of the map with modules objects should not be empty.");
            }
        } else {
            sa.fail("Validation failed, modules object should not be empty");
        }

    }
}

