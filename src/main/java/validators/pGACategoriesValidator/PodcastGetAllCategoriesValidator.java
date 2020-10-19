package validators.pGACategoriesValidator;

import org.testng.asserts.SoftAssert;
import pojos.podcastGetAllCategories.PodcastGetAllCategories;
import pojos.podcastsGetAll.PodcastCategory;
import validators.AssertionMsg;
import validators.PodcastGetAllValidator.PodcastCategoryValidator;
import validators.Validate;

public class PodcastGetAllCategoriesValidator {
    final String className = getClass().getName();

    public void validate(PodcastGetAllCategories pc, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        for(PodcastCategory  podcastCategory : pc.getData()){
            new PodcastCategoryValidator().validate(podcastCategory, sa);
        }

        if(pc.getLastPage() != null){
            sa.assertTrue(Validate.asBoolean(pc.getLastPage()), AssertionMsg.print(className, methodName, "last_page", String.valueOf(pc.getLastPage())));
        }
    }
}
