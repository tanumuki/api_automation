package validators.genericValidators;

import entities.PlaylistMoreInfo;
import org.testng.asserts.SoftAssert;

import entities.Playlist;
import entities.Song;
import validators.AssertionMsg;
import validators.Validate;

public class PlaylistValidator extends EntityValidator {

    final String className = PlaylistValidator.class.getName();

    public void validate(Playlist playlistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(playlistObj, sa);

        for (Song song : playlistObj.getList()) {
            new SongValidator().validate(song, sa, playlistObj.getId(), "playlist");
        }
        validateMoreInfo(playlistObj, sa);
    }

    void validateMoreInfo(Playlist plObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        PlaylistMoreInfo moreInfo = plObj.getMore_info();
        sa.assertTrue(Validate.asString(moreInfo.getUid()), AssertionMsg.print(className, methodName, "playlist.more_info.uid", moreInfo.getUid()));

        sa.assertTrue(Validate.asNum(moreInfo.getLast_updated()), AssertionMsg.print(className, methodName, "playlist.more_info.last_updated", moreInfo.getLast_updated()));

        sa.assertTrue(Validate.asString(moreInfo.getUsername()), AssertionMsg.print(className, methodName, "playlist.more_info.username", moreInfo.getUsername()));

        sa.assertTrue(Validate.asString(moreInfo.getFirstname()), AssertionMsg.print(className, methodName, "playlist.more_info.firstname", moreInfo.getFirstname()));

        sa.assertTrue(Validate.asString(moreInfo.getLastname()), AssertionMsg.print(className, methodName, "playlist.more_info.lastname", moreInfo.getLastname()));

        sa.assertTrue(Validate.asString(moreInfo.getIs_followed()), AssertionMsg.print(className, methodName, "playlist.more_info.is_followed", moreInfo.getIs_followed()));

        sa.assertTrue(Validate.asNum(moreInfo.getFollower_count()), AssertionMsg.print(className, methodName, "playlist.more_info.follower_count", moreInfo.getFollower_count()));

        sa.assertTrue(Validate.asNum(moreInfo.getFan_count()), AssertionMsg.print(className, methodName, "playlist.more_info.fan_count", moreInfo.getFan_count()));

        sa.assertTrue(Validate.asString(moreInfo.getPlaylist_type()), AssertionMsg.print(className, methodName, "playlist.more_info.playlist_type", moreInfo.getPlaylist_type()));

        sa.assertTrue(Validate.asString(moreInfo.getShare()), AssertionMsg.print(className, methodName, "playlist.more_info.share", moreInfo.getShare()));


    }

}
