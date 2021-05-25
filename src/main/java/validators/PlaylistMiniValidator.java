package validators;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
            /*TODO: Add validation for numsongs, for now it's coming up as null
            * Purposefully failing it for now, so that in case the test fails, we can check the values in JSON, and
            * add the validations - Ashwin */
            sa.fail();
        }

        if(ch.getMoreInfo() instanceof List){
            sa.assertTrue(((List<?>) ch.getMoreInfo()).size() == 0, "Playlist Mini more_info of type list has contents");
        } else {
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

            PlaylistMiniMoreInfo mi = mapper.convertValue(ch.getMoreInfo(), PlaylistMiniMoreInfo.class);
            validatePlaylistMiniMoreInfo(mi, sa);
        }

        if(Validate.isNonEmptyString(ch.getDisabled_topic_module())){
            sa.assertTrue(Validate.asString(ch.getDisabled_topic_module()),
                    AssertionMsg.print(className, methodName, "playlist.disabled_topic_module", ch.getDisabled_topic_module()));
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

        if(Validate.isNonEmptyString(mi.getRelease_date()))
            sa.assertTrue(Validate.asDate(mi.getRelease_date()), AssertionMsg.print(className, methodName, "playlist.more_info.release_date", mi.getRelease_date()));

        if(Validate.isNonEmptyString(mi.getDescription()))
            sa.assertTrue(Validate.asString(mi.getDescription()), AssertionMsg.print(className, methodName, "playlist.more_info.description", mi.getDescription()));

        if(Validate.isNonEmptyString(mi.getPrimaryArtists()))
            sa.assertTrue(Validate.asString(mi.getPrimaryArtists()), AssertionMsg.print(className, methodName, "playlist.more_info.primary_artist", mi.getPrimaryArtists()));

        if(Validate.isNonEmptyString(mi.getSingers()))
            sa.assertTrue(Validate.asString(mi.getSingers()), AssertionMsg.print(className, methodName, "playlist.more_info.singers", mi.getSingers()));

        if(mi.getCtr() != null)
            sa.assertTrue(Validate.asNum(mi.getCtr()), AssertionMsg.print(className, methodName, "playlist.more_info.ctr", String.valueOf(mi.getCtr())));

        if(mi.getScore() != null)
            sa.assertTrue(mi.getScore() instanceof Double, AssertionMsg.print(className, methodName, "playlist.more_info.score", String.valueOf(mi.getScore())));

        if(Validate.isNonEmptyString(mi.getVcode())){
            sa.assertTrue(Validate.asNum(mi.getVcode()), AssertionMsg.print(className, methodName, "playlist.more_info.vcode", mi.getVcode()));
            sa.assertTrue(Validate.asVlinkURL(mi.getVlink()), AssertionMsg.print(className, methodName, "playlist.more_info.vlink", mi.getVlink()));
        }

        if(mi.getSub_types()!=null) {
            /*TODO: Add validation for sub_types, for now it's coming up as null
             * Purposefully failing it for now, so that in case the test fails, we can check the values in JSON, and
             * add the validations - Ashwin */
            sa.fail();
        }

        if(mi.getImages()!=null) {
            /*TODO: Add validation for images, for now it's coming up as null
             * Purposefully failing it for now, so that in case the test fails, we can check the values in JSON, and
             * add the validations - Ashwin */
            sa.fail();
        }

        //WEb release 11-Mar-21
        if(mi.getIs_dolby_content() != null)
            sa.assertTrue(Validate.asBoolean(mi.getIs_dolby_content()), AssertionMsg.print(className, methodName, "playlist.more_info.is_dolby_content", String.valueOf(mi.getIs_dolby_content())));
    }


}
