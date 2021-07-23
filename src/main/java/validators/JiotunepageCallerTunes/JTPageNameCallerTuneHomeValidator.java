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
public class JTPageNameCallerTuneHomeValidator extends EntityValidator {
    final String className = getClass().getName();

    public void validate(NameCallerTuneContainer nameCaller, SoftAssert sa) throws IOException {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asBoolean(nameCaller.getLastPageBool()), AssertionMsg.print(className, methodName, "last_page", String.valueOf(nameCaller.getLastPageBool())));
        log.info("Last_page field is validated.");

        /**
         * Validation for all_name_caller_tune array of object
         */
        validateNameTune(nameCaller, sa);

        /**
         * Validation for modules.all_name_caller_tune
         */
        ModulesData modulesData = nameCaller.getModules().getAllNameCallerTuneInModules();
        ModulesDataValidator.validate(modulesData, sa);
    }

    public void validateNameTune(NameCallerTuneContainer nameCaller, SoftAssert sa) throws IOException {
        for (Map.Entry<String, MultipleTunes[]> data : nameCaller.getAllNameTune().entrySet()) {
            for (MultipleTunes nameTune : data.getValue()) {
                new MultipleTunesValidator().validate(nameTune, sa);
            }
        }
    }
}

