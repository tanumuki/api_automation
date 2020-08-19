package validators;

import entities.PlaylistMini;
import entities.PlaylistMiniMoreInfo;
import org.testng.asserts.SoftAssert;
import validators.genericValidators.EntityValidator;

public class PlaylistMiniValidator extends EntityValidator {

    final String className = getClass().getName();

    public void validate(PlaylistMini ch, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(ch, sa);

        PlaylistMiniMoreInfo mi = ch.getMoreInfo();
        if(mi.getFirstname() != null)
            sa.assertTrue(Validate.asString(mi.getFirstname()), AssertionMsg.print(className, methodName, "chart", "more_info.firstname", mi.getFirstname()));

        if(mi.getSongCount() != null)
            sa.assertTrue(Validate.asNum(mi.getSongCount()), AssertionMsg.print(className, methodName, "playlist", "more_info.song_count", mi.getSongCount()));

        if(mi.getFollowerCount() != null)
            sa.assertTrue(Validate.asNum(mi.getFollowerCount()), AssertionMsg.print(className, methodName, "playlist", "more_info.follower_count", mi.getFollowerCount()));

        if(mi.getLastUpdated() != null)
            sa.assertTrue(Validate.asNum(mi.getLastUpdated()), AssertionMsg.print(className, methodName, "playlist", "more_info.last_updated", mi.getLastUpdated()));

        if(mi.getUid() != null)
            sa.assertTrue(Validate.asString(mi.getUid()), AssertionMsg.print(className, methodName, "playlist", "more_info.uid", mi.getUid()));


    }



}
