package validators;

import entities.ContentMini;
import entities.ContentMiniMoreInfo;
import org.testng.asserts.SoftAssert;
import validators.genericValidators.EntityValidator;

public class ContentMiniValidator extends EntityValidator {

    final String className = getClass().getName();

    public void validate(ContentMini ch, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(ch, sa);

        ContentMiniMoreInfo mi = ch.getMoreInfo();
        if(mi.getFirstname() != null)
            sa.assertTrue(Validate.asString(mi.getFirstname()), AssertionMsg.print(className, methodName, "chart", "getAllCharts.more_info.firstname", mi.getFirstname()));

        if(mi.getSong_count() != null)
            sa.assertTrue(Validate.asNum(mi.getSong_count()), AssertionMsg.print(className, methodName, "playlist", "getFeaturedPlaylists.more_info.song_count", mi.getSong_count()));
    }



}
