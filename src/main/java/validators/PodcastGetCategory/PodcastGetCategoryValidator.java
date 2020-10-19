package validators.PodcastGetCategory;

import entities.ShowDetails;
import entities.ShowMini;
import org.testng.asserts.SoftAssert;
import pojos.podcastGetCategory.PodcastGetCategory;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.ShowMiniValidator;
import validators.showGetHome.ShowDetailsValidator;

public class PodcastGetCategoryValidator {
    final String className = getClass().getName();

    public void validate(PodcastGetCategory pgc, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(pgc != null) {
            for(ShowMini show : pgc.getShows()) {
                new ShowMiniValidator().validate(show, sa);
            }
        }

        if(pgc.getLast_page() != null) {
            sa.assertTrue(Validate.asBoolean(pgc.getLast_page()), AssertionMsg.print(className, methodName, "last_page", String.valueOf(pgc.getLast_page())));
        }
    }
}
