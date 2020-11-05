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

        if(Validate.isNonEmptyString(ch.getUid()))
            sa.assertTrue(Validate.asString(ch.getUid()), AssertionMsg.print(className, methodName, "mix/playlist", "entity.uid", ch.getUid()));

        if(ch.getMini_obj() != null) {
            sa.assertTrue(Validate.asBoolean(ch.getMini_obj()), AssertionMsg.print(className, methodName, "mix/playlist", "entity.mini_obj", String.valueOf(ch.getMini_obj())));
        }

        if(Validate.isNonEmptyString(ch.getExplicit_content())){
            sa.assertTrue(Validate.asBoolean(ch.getExplicit_content()), AssertionMsg.print(className, methodName, "chart/playlist", "entity.explicit_content", ch.getExplicit_content()));
        }



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

        if(Validate.isNonEmptyString(mi.getArtist_name())){
            sa.assertTrue(Validate.asString(mi.getArtist_name()), AssertionMsg.print(className, methodName, "chart", "more_info.artist_name", mi.getArtist_name()));
        }

        if(Validate.isNonEmptyString(mi.getLastname())){
            sa.assertTrue(Validate.asString(mi.getLastname()), AssertionMsg.print(className, methodName, "chart", "more_info.lastname", mi.getLastname()));
        }

        if(Validate.isNonEmptyString(mi.getEntity_type())){
            sa.assertTrue(Validate.asString(mi.getEntity_type()), AssertionMsg.print(className, methodName, "chart", "more_info.entity_type", mi.getEntity_type()));
        }

        if(Validate.isNonEmptyString(mi.getShare())){
            sa.assertTrue(Validate.asString(mi.getShare()), AssertionMsg.print(className, methodName, "chart", "more_info.share", mi.getShare()));
        }

        if(Validate.isNonEmptyString(mi.getLanguage())){
            sa.assertTrue(Validate.asMusicLanguages(mi.getLanguage()), AssertionMsg.print(className, methodName, "chart", "more_info.language", mi.getEntity_type()));
        }

    }



}
