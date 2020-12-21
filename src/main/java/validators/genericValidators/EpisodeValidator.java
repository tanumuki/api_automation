package validators.genericValidators;

import entities.*;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class EpisodeValidator extends EntityValidator {
    final String className = SongValidator.class.getName();

    /**
     * Entity validation for episode object
     * @param episode
     * @param sa
     */
    public void validate(Episode episode, SoftAssert sa) {
        super.validate(episode, sa);
    }

    /**
     * Entity validation for episode mini object
     * @param episodeMini
     * @param sa
     */
    public void validate(EpisodeMini episodeMini, SoftAssert sa) {
        super.validate(episodeMini, sa);
    }

    /**
     * More info validation for episode object
     * @param episode
     * @param sa
     */
    public void validateMoreInfo(Episode episode, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        EpisodeMoreInfo mi = episode.getMoreInfo();
        if(Validate.isNonEmptyString(mi.getDuration()))
            sa.assertTrue(Validate.asNum(mi.getDuration()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.duration", mi.getDuration(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getSquareImageUrl()))
            sa.assertTrue(Validate.asCDNURL(mi.getSquareImageUrl()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.square_image_url", mi.getSquareImageUrl(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getLabelId()))
            sa.assertTrue(Validate.asNum(mi.getLabelId()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.label_id", mi.getLabelId(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getReleaseDate()))
            sa.assertTrue(Validate.asDateTime(mi.getReleaseDate()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.releaseDate", mi.getReleaseDate(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getEntity_title_exact_match()))
            sa.assertTrue(Validate.asString(mi.getEntity_title_exact_match()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.entity_title_exact_match", mi.getEntity_title_exact_match(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getDescription()))
            sa.assertTrue(Validate.asString(mi.getDescription()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.description", mi.getDescription(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getSeasonNo()))
            sa.assertTrue(Validate.asNum(mi.getSeasonNo()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.season_no", mi.getSeasonNo(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getShowId()))
            sa.assertTrue(Validate.asNum(mi.getShowId()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.show_id", mi.getShowId(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getSeasonId()))
            sa.assertTrue(Validate.asNum(mi.getSeasonId()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.season_id", mi.getSeasonId(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getShowTitle()))
            sa.assertTrue(Validate.asString(mi.getShowTitle()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.show_title", mi.getShowTitle(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getSeasonTitle()))
            sa.assertTrue(Validate.asString(mi.getSeasonTitle()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.season_title", mi.getSeasonTitle(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getSquareImage()))
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

        if(Validate.isNonEmptyString(mi.getEpisodeNumber()))
            sa.assertTrue(Validate.asNum(mi.getEpisodeNumber()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.episode_number", mi.getEpisodeNumber(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getLabel()))
            sa.assertTrue(Validate.asString(mi.getLabel()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.label", mi.getLabel(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getOrigin()))
            sa.assertTrue(Validate.asString(mi.getOrigin()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.origin", mi.getOrigin(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getAdBreaks()))
            sa.assertTrue(Validate.asNum(mi.getAdBreaks()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.ad_breaks", mi.getAdBreaks(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getMultiBr()))
            sa.assertTrue(Validate.asBoolean(mi.getMultiBr()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.multi_br", mi.getMultiBr(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getStarred()))
            sa.assertTrue(Validate.asNum(mi.getStarred()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.starred", mi.getStarred(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getCacheState()))
            sa.assertTrue(Validate.asBoolean(mi.getCacheState()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.cache_state", mi.getCacheState(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getShowUrl()))
            sa.assertTrue(Validate.asPermaURL(mi.getShowUrl()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.show_url", mi.getShowUrl(), episode.getId()));

        if(Validate.isNonEmptyString(mi.getEncryptedMediaUrl()))
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

        if(Validate.isNonEmptyString(mi.getMultiBr()))
            sa.assertTrue(Validate.asBoolean(mi.getMultiBr()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.multi_br", mi.getMultiBr(), episode.getId()));
    }

    /**
     * More info validation for episode mini object
     * @param epMini
     * @param sa
     */
    private void validateMoreInfoEpisodeMini(EpisodeMini epMini, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        EpisodeMoreInfo mi = epMini.getMoreInfo();

        sa.assertTrue(Validate.asFloat(mi.getWeight()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.weight", mi.getWeight(), epMini.getId()));
        sa.assertTrue(Validate.asNum(mi.getSeasonNumber()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.season_number", mi.getSeasonNumber(), epMini.getId()));
        sa.assertTrue(Validate.asNum(mi.getShowId()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.show_id", mi.getShowId(), epMini.getId()));
        sa.assertTrue(Validate.asNum(mi.getSeasonId()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.season_id", mi.getSeasonId(), epMini.getId()));
        sa.assertTrue(Validate.asString(mi.getShowTitle()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.show_title", mi.getShowTitle(), epMini.getId()));
        sa.assertTrue(Validate.asString(mi.getSeasonTitle()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.season_title", mi.getSeasonTitle(), epMini.getId()));
        sa.assertTrue(Validate.asString(mi.getEncryptedMediaUrl()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.encrypted_media_url", mi.getEncryptedMediaUrl(), epMini.getId()));
        sa.assertTrue(Validate.asNum(mi.getEpisodeNumber()), AssertionMsg.print(className, methodName, "episode", "episode.more_info.episode_number", mi.getEpisodeNumber(), epMini.getId()));

        Rights rights = mi.getRights();
        new RightsValidator().validate(rights, sa, "episode", epMini.getId());

    }
}
