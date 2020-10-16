package validators.PodcastGetAllValidator;

import org.testng.asserts.SoftAssert;
import pojos.podcastsGetAll.PodcastGetAllPojo;
import pojos.podcastsGetAll.PodcastsGetAllModules;

public class PodcastGetAllValidator {
    final String className = getClass().getName();

    public void validate(PodcastGetAllPojo pg, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        //validate modules
        new ModuleValidator().validateModules(pg.getModules(), sa);

        
    }


}
