package validators.genericValidators;

import entities.ShowDetails;
import org.testng.asserts.SoftAssert;
import pojos.getTopShows.TopShows;
import validators.AssertionMsg;
import validators.Validate;
import validators.showGetHome.ShowDetailsValidator;

public class TopShowsValidator {
    final String className = getClass().getName();
    public void validate(TopShows topShows, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asString(topShows.getBadge()), AssertionMsg.print(className, methodName, "topshows.badge", topShows.getBadge()));

        sa.assertFalse(topShows.getLast_page(), AssertionMsg.print(className, methodName, "topshows.last_page", String.valueOf(topShows.getLast_page())));

        for(ShowDetails show : topShows.getShows()) {
            new ShowDetailsValidator().validate(show, sa);
        }
    }
}
