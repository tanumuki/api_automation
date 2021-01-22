package validators;

import entities.PlaylistMini;
import entities.PlaylistMiniMoreInfo;
import org.testng.asserts.SoftAssert;
import validators.genericValidators.EntityValidator;

import java.util.List;

public class PlaylistMiniValidator extends EntityValidator {

    final String className = getClass().getName();

    public void validate(PlaylistMini ch, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(ch, sa);

        if(Validate.isNonEmptyString(ch.getUid()))
            sa.assertTrue(Validate.asString(ch.getUid()), AssertionMsg.print(className, methodName, "mix/playlist", "entity.uid", ch.getUid()));

        if(ch.getMini_obj() != null) {
            sa.assertTrue(Validate.asBoolean(ch.getMini_obj()), AssertionMsg.print(className, methodName, "mix/playlist", "entity.mini_obj", String.valueOf(ch.getMini_obj())));
        }

        if(Validate.isNonEmptyString(ch.getExplicit_content())){
            sa.assertTrue(Validate.asBoolean(ch.getExplicit_content()), AssertionMsg.print(className, methodName, "chart/playlist", "entity.explicit_content", ch.getExplicit_content()));
        }

        if(Validate.isNonEmptyString(ch.getDescription()))
            sa.assertTrue(Validate.asString(ch.getDescription()), AssertionMsg.print(className, methodName, "playlist.description", ch.getDescription()));

        if(ch.getNumsongs() != null){
            //TODO: Add validation for numsongs, for now it's coming up as null
        }

        if(ch.getMoreInfo() instanceof PlaylistMiniMoreInfo){
            PlaylistMiniMoreInfo mi = (PlaylistMiniMoreInfo) ch.getMoreInfo();
            validatePlaylistMiniMoreInfo(mi, sa);
        }else if(ch.getMoreInfo() instanceof List){
            sa.assertTrue(((List<?>) ch.getMoreInfo()).size() == 0, "Playlist Mini more_info of type list has contents");
        } else {
            sa.fail("Unsupported type for Playlist mini more_info - " + ch.getMoreInfo().getClass().getName());
        }


    }

    void validatePlaylistMiniMoreInfo(PlaylistMiniMoreInfo mi, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
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

        if(Validate.isNonEmptyString(mi.getFanCount()))
            sa.assertTrue(Validate.asNum(mi.getFanCount()), AssertionMsg.print(className, methodName, "playlist.more_info.fan_count", mi.getFanCount()));

        if(mi.getArtist_name() != null){
            for(String artist : mi.getArtist_name()){
                sa.assertTrue(Validate.asString(artist), AssertionMsg.print(className, methodName, "chart", "more_info.artist_name", artist));
            }
        }

        if(Validate.isNonEmptyString(mi.getIsWeekly()))
            sa.assertTrue(Validate.asBoolean(mi.getIsWeekly()), AssertionMsg.print(className, methodName, "playlist.more_info.is_weekly", mi.getIsWeekly()));

        if(Validate.isNonEmptyString(mi.getReward()))
            sa.assertTrue(Validate.asString(mi.getReward()), AssertionMsg.print(className, methodName, "playlist.more_info.reward", mi.getReward()));



        if(Validate.isNonEmptyString(mi.getLastname())){
            sa.assertTrue(Validate.asString(mi.getLastname()), AssertionMsg.print(className, methodName, "chart", "more_info.lastname", mi.getLastname()));
        }

        if(Validate.isNonEmptyString(mi.getEntity_type())){
            sa.assertTrue(Validate.asString(mi.getEntity_type()), AssertionMsg.print(className, methodName, "chart", "more_info.entity_type", mi.getEntity_type()));
        }

        if(Validate.isNonEmptyString(mi.getEntity_sub_type())){
            sa.assertTrue(Validate.asString(mi.getEntity_sub_type()), AssertionMsg.print(className, methodName, "chart", "more_info.entity_sub_type", mi.getEntity_sub_type()));
        }

        if(Validate.isNonEmptyString(mi.getVideo_available())){
            sa.assertTrue(Validate.asBoolean(mi.getVideo_available()), AssertionMsg.print(className, methodName, "chart", "more_info.video_available", mi.getVideo_available()));
        }

        if(Validate.isNonEmptyString(mi.getShare())){
            sa.assertTrue(Validate.asString(mi.getShare()), AssertionMsg.print(className, methodName, "chart", "more_info.share", mi.getShare()));
        }

        if(Validate.isNonEmptyString(mi.getLanguage())){
            sa.assertTrue(Validate.asMusicLanguages(mi.getLanguage()), AssertionMsg.print(className, methodName, "chart", "more_info.language", mi.getEntity_type()));
        }
    }


}
