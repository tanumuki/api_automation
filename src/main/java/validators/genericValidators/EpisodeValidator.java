package validators.genericValidators;

import entities.*;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class EpisodeValidator extends EntityValidator {
    final String className = SongValidator.class.getName();

    public void validate(Episode episode, SoftAssert sa) {
        super.validate(episode, sa);


    }

    public void validateMoreInfo(Episode episode, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        EpisodeMoreInfo mi = episode.getMoreInfo();
        sa.assertTrue(Validate.asNum(mi.getDuration()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.duration", mi.getDuration(), episode.getId()));

        sa.assertTrue(Validate.asCDNURL(mi.getSquareImageUrl()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.square_image_url", mi.getSquareImageUrl(), episode.getId()));

        sa.assertTrue(Validate.asNum(mi.getLabelId()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.label_id", mi.getLabelId(), episode.getId()));

        sa.assertTrue(Validate.asDateTime(mi.getReleaseDate()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.releaseDate", mi.getReleaseDate(), episode.getId()));

        sa.assertTrue(Validate.asString(mi.getDescription()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.description", mi.getDescription(), episode.getId()));

        sa.assertTrue(Validate.asNum(mi.getSeasonNo()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.season_no", mi.getSeasonNo(), episode.getId()));

        sa.assertTrue(Validate.asNum(mi.getShowId()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.show_id", mi.getShowId(), episode.getId()));

        sa.assertTrue(Validate.asNum(mi.getSeasonId()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.season_id", mi.getSeasonId(), episode.getId()));

        sa.assertTrue(Validate.asString(mi.getShowTitle()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.show_title", mi.getShowTitle(), episode.getId()));

        sa.assertTrue(Validate.asString(mi.getSeasonTitle()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.season_title", mi.getSeasonTitle(), episode.getId()));

        sa.assertTrue(Validate.asCDNURL(mi.getSquareImage()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.square_image", mi.getSquareImage(), episode.getId()));

        ArtistMap artistMap = mi.getArtistMap();

        for(Artist artist : artistMap.getPrimaryArtists()) {
            new ArtistMapValidator().validate(artist, sa, "primary_artists", "episode", episode.getId());
        }

        for(Artist artist : artistMap.getFeaturedArtists()) {
            new ArtistMapValidator().validate(artist, sa, "featured_artists", "episode", episode.getId());
        }

        for(Artist artist : artistMap.getArtists()) {
            new ArtistMapValidator().validate(artist, sa, "artists", "episode", episode.getId());
        }

        sa.assertTrue(Validate.asNum(mi.getEpisodeNumber()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.episode_number", mi.getEpisodeNumber(), episode.getId()));

        sa.assertTrue(Validate.asString(mi.getLabel()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.label", mi.getLabel(), episode.getId()));

        sa.assertTrue(Validate.asString(mi.getOrigin()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.origin", mi.getOrigin(), episode.getId()));

        sa.assertTrue(Validate.asNum(mi.getAdBreaks()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.ad_breaks", mi.getAdBreaks(), episode.getId()));

        sa.assertTrue(Validate.asNum(mi.getStarred()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.starred", mi.getStarred(), episode.getId()));

        sa.assertTrue(Validate.asBoolean(mi.getCacheState()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.cache_state", mi.getCacheState(), episode.getId()));

        sa.assertTrue(Validate.asPermaURL(mi.getShowUrl()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.show_url", mi.getShowUrl(), episode.getId()));

        sa.assertTrue(Validate.asString(mi.getEncryptedMediaUrl()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.encrypted_media_url", mi.getEncryptedMediaUrl(), episode.getId()));

        Rights rights = mi.getRights();

        new RightsValidator().validate(rights, sa, "episode", episode.getId());

        if(mi.getGenre_tags() != null) {
            for(String tag : mi.getGenre_tags()) {
                sa.assertTrue(Validate.asString(tag), AssertionMsg.print(className, methodName, "episode", "episode.more_info.genre_tag", tag, episode.getId()));
            }
        }

        if(mi.getSeasonality_tags() != null) {
            for(String tag : mi.getSeasonality_tags()) {
                sa.assertTrue(Validate.asString(tag), AssertionMsg.print(className, methodName, "episode", "episode.more_info.seasonality_tag", tag, episode.getId()));
            }
        }


    }
}
