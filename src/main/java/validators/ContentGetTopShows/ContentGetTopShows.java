package validators.ContentGetTopShows;

import entities.ShowDetails;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;
import validators.showGetHome.ShowDetailsValidator;

public class ContentGetTopShows {
    final String className = getClass().getName();
    public void validate(pojos.getTopShows.ContentGetTopShows shows, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        sa.assertTrue(Validate.asString(shows.getBadge()), AssertionMsg.print(className, methodName, "show", "topShows.badge", shows.getBadge() ));
        for(ShowDetails show : shows.getShows()) {
            new ShowDetailsValidator().validate(show, sa);
        }
    }

}
