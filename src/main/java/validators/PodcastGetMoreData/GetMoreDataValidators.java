package validators.PodcastGetMoreData;

import org.testng.asserts.SoftAssert;
import pojos.podcastGetMoreData.PodcastGetMoreData;
import pojos.podcastsGetAll.PodcastsMenu;
import validators.AssertionMsg;
import validators.PodcastGetAllValidator.PodcastGetAllValidator;
import validators.Validate;

public class GetMoreDataValidators {
    final String className = getClass().getName();

    public void validate(PodcastGetMoreData md, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(md != null) {
            for(PodcastsMenu menu : md.getData()) {
                new PodcastGetAllValidator().validatePodcastMenu(menu, sa);
            }

            if(md.getLastPage() != null) {
                sa.assertTrue(Validate.asBoolean(md.getLastPage()), AssertionMsg.print(className, methodName, "last_page", String.valueOf(md.getLastPage())));
            }
        }

    }
}
