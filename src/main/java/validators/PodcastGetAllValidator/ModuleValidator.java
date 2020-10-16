package validators.PodcastGetAllValidator;

import entities.ModulesWithViewMoreObj;
import org.testng.asserts.SoftAssert;
import pojos.podcastsGetAll.PodcastsGetAllModules;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.ModuleViewMoreValidator;
import validators.genericValidators.ModulesDataValidator;

import java.util.Map;

public class ModuleValidator {
    final String className = getClass().getName();

    public void validateModules(PodcastsGetAllModules pgm, SoftAssert sa) {
        validateModulesBaseMenu(pgm.getBaseMenu(), sa);

        validateModulesNewTrending(pgm.getNewTrending(), sa);

        validatePodcastHomeModule(pgm.getPodcasts(), sa);
    }

    void validateModulesBaseMenu(ModulesWithViewMoreObj bm, SoftAssert sa) {
        // validate module data
        new ModulesDataValidator().validate(bm, sa);
    }

    void validateModulesNewTrending(ModulesWithViewMoreObj nt, SoftAssert sa) {
        new ModulesDataValidator().validate(nt, sa);

        new ModuleViewMoreValidator().validate(nt, sa);
    }

    void validatePodcastHomeModule(Map<String, ModulesWithViewMoreObj> podcasts, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        for(Map.Entry<String, ModulesWithViewMoreObj> entry : podcasts.entrySet()) {
            String key = entry.getKey();
            sa.assertTrue(Validate.asString(key), AssertionMsg.print(className, methodName, "modules", key));
            ModulesWithViewMoreObj val = entry.getValue();
            new ModulesDataValidator().validate(val, sa);
            new ModuleViewMoreValidator().validate(val, sa);
        }
    }
}
