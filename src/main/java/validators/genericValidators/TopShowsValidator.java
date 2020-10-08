package validators.genericValidators;

import entities.ShowDetails;
import org.testng.asserts.SoftAssert;
import pojos.getTopShows.TopShows;
import pojos.getTopShows.TopShowsData;
import pojos.libraryOps.SongData;
import validators.AssertionMsg;
import validators.Validate;
import validators.showGetHome.ShowDetailsValidator;

public class TopShowsValidator {
    final String className = getClass().getName();
    public void validate(TopShows topShows, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(topShows.getBadge()))
            sa.assertTrue(Validate.asString(topShows.getBadge()), AssertionMsg.print(className, methodName, "topshows.badge", topShows.getBadge()));

        if(topShows.getLast_page())
            sa.assertTrue(topShows.getLast_page() , AssertionMsg.print(className, methodName, "topshows.last_page", String.valueOf(topShows.getLast_page())));
        else
            sa.assertFalse(topShows.getLast_page() , AssertionMsg.print(className, methodName, "topshows.last_page", String.valueOf(topShows.getLast_page())));
        
        for(ShowDetails show : topShows.getShows()) {
            new ShowDetailsValidator().validate(show, sa);
        }
    }

    public void validate(TopShowsData topShows, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(topShows.getBadge()))
            sa.assertTrue(Validate.asString(topShows.getBadge()), AssertionMsg.print(className, methodName, "topshows.badge", topShows.getBadge()));

        if(topShows.getLast_page())
            sa.assertTrue(topShows.getLast_page() , AssertionMsg.print(className, methodName, "topshows.last_page", String.valueOf(topShows.getLast_page())));
        else
            sa.assertFalse(topShows.getLast_page() , AssertionMsg.print(className, methodName, "topshows.last_page", String.valueOf(topShows.getLast_page())));

        for(ShowDetails show : topShows.getData()) {
            new ShowDetailsValidator().validate(show, sa);
        }
    }
}
