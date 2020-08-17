package validators.genericValidators;

import entities.Playlist;
import entities.PlaylistMoreInfo;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

/**
 * @author ashwinsriv
 *
 */

public class PlaylistMiniValidator extends EntityValidator {
    public void validate(Playlist playlistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(playlistObj, sa);

        validateMoreInfo(playlistObj, sa);
    }

    void validateMoreInfo(Playlist plObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        PlaylistMoreInfo moreInfo = plObj.getMore_info();

        if(Validate.isNonEmptyString(moreInfo.getFirstname())) {
            sa.assertTrue(Validate.asString(moreInfo.getFirstname()), AssertionMsg.print(className, methodName, "playlist.more_info.firstname", moreInfo.getFirstname()));
        }

        if(Validate.isNonEmptyString(moreInfo.getLastname())) {
            sa.assertTrue(Validate.asString(moreInfo.getLastname()), AssertionMsg.print(className, methodName, "playlist.more_info.lastname", moreInfo.getLastname()));
        }

        if(Validate.isNonEmptyString(moreInfo.getDescription())) {
            sa.assertTrue(Validate.asString(moreInfo.getDescription()), AssertionMsg.print(className, methodName, "playlist.more_info.description", moreInfo.getDescription()));
        }

        if(Validate.isNonEmptyString(moreInfo.getFollower_count())) {
            sa.assertTrue(Validate.asNum(moreInfo.getFollower_count()), AssertionMsg.print(className, methodName, "playlist.more_info.follower_count", moreInfo.getFollower_count()));
        }

        sa.assertTrue(Validate.asNum(moreInfo.getSong_count()), AssertionMsg.print(className, methodName, "playlist.more_info.song_count", moreInfo.getSong_count()));


    }
}