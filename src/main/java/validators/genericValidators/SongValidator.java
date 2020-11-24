/**
 *
 */
package validators.genericValidators;

import org.testng.asserts.SoftAssert;

import entities.Artist;
import entities.ArtistMap;
import entities.Rights;
import entities.Song;
import entities.SongMoreInfo;
import lombok.extern.slf4j.Slf4j;
import validators.AssertionMsg;
import validators.Validate;

/**
 * @author aswingokulachandran
 *
 */
@Slf4j
public class SongValidator extends EntityValidator {
    final String className = SongValidator.class.getName();

    // Will be sending album as sourceType & album id as sourceEntity
    public void validate(Song songObj, SoftAssert sa, String sourceEntity, String sourceType) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        super.validate(songObj, sa, sourceEntity, sourceType);

        validateMoreInfo(songObj, sa);

        if (songObj.getType().equals("episode"))
        	validateEpisodeDetails(songObj, sa);

        validateRights(songObj, sa);

        ArtistMap artistMap = songObj.getMoreInfo().getArtistMap();

        if(artistMap != null){
            new ArtistMapValidator().validate(artistMap, sa, sourceType, sourceEntity);
        }


    }


    void validateMoreInfo(Song songObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        SongMoreInfo moreInfo = songObj.getMoreInfo();

        if(Validate.isNonEmptyString(moreInfo.getMusic())){
            sa.assertTrue(Validate.asString(moreInfo.getMusic()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.music", moreInfo.getMusic(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.getAlbumId())) {
            sa.assertTrue(Validate.asString(moreInfo.getAlbumId()),
                    AssertionMsg.print(className, methodName, songObj.getType(), "more_info.album_id",
                            moreInfo.getAlbumId(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.getLabel())) {
            sa.assertTrue(Validate.asString(moreInfo.getLabel()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.label", moreInfo.getLabel(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.getOrigin())) {
            sa.assertTrue(Validate.asString(moreInfo.getOrigin()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.origin", moreInfo.getOrigin(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.get_320kbps())) {
            sa.assertTrue(Validate.asBoolean(moreInfo.get_320kbps()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.320kbps", moreInfo.get_320kbps(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.getEncryptedMediaUrl())) {
            sa.assertTrue(Validate.asString(moreInfo.getEncryptedMediaUrl()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.encrypted_media_url", moreInfo.getEncryptedMediaUrl(), songObj.getId()));
        }else {
            sa.fail("Song More Info Encrypted Media URL is null/empty for song with ID - " + songObj.getId());
        }

        if(Validate.isNonEmptyString(moreInfo.getEncryptedCacheUrl())) {
            sa.assertTrue(Validate.asString(moreInfo.getEncryptedCacheUrl()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.encrypted_cache_url", moreInfo.getEncryptedCacheUrl(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.getAlbumUrl())) {
            sa.assertTrue(Validate.asPermaURL(moreInfo.getAlbumUrl()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.album_url", moreInfo.getAlbumUrl(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.getDuration())) {
            sa.assertTrue(Validate.asNum(moreInfo.getDuration()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.duration", moreInfo.getDuration(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.getCacheState())) {
            sa.assertTrue(Validate.asBoolean(moreInfo.getCacheState()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.cache_state", moreInfo.getCacheState(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.getHasLyrics())) {
            sa.assertTrue(Validate.asBoolean(moreInfo.getHasLyrics()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.has_lyrics", moreInfo.getHasLyrics(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.getLyricsSnippet())) {
            sa.assertTrue(Validate.asString(moreInfo.getLyricsSnippet()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.lyrics_snippet", moreInfo.getLyricsSnippet(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.getStarred())) {
            sa.assertTrue(Validate.asBoolean(moreInfo.getStarred()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.starred", moreInfo.getStarred(), songObj.getId()));
        }

        if(Validate.isNonEmptyString(moreInfo.getCopyrightText())) {
            sa.assertTrue(Validate.asString(moreInfo.getCopyrightText()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.copyright_text", moreInfo.getCopyrightText(), songObj.getId()));
        }

		if (moreInfo.getReleaseDate() != null) {
			sa.assertTrue(Validate.asString(moreInfo.getReleaseDate()), AssertionMsg.print(className, methodName,
					songObj.getType(), "more_info.release_date", moreInfo.getReleaseDate(), songObj.getId()));

		}

		if(moreInfo.getTriller_available() != null){
            sa.assertTrue(Validate.asBoolean(moreInfo.getTriller_available()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.starred", String.valueOf(moreInfo.getTriller_available()), songObj.getId()));
        }

		log.info("More Info Validation done!");

	}

    void validateRights(Song songObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        Rights rights = songObj.getMoreInfo().getRights();

		new RightsValidator().validate(rights, sa, "song", songObj.getId());
    }

    void validateEpisodeDetails(Song songObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        SongMoreInfo moreInfo = songObj.getMoreInfo();

        for (String geo_rule : moreInfo.getGeo_rules()) {
            sa.assertTrue(Validate.asNum(geo_rule), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.geo_rules", geo_rule, songObj.getId()));
        }
        sa.assertTrue(Validate.asCDNURL(moreInfo.getSquare_image_url()), AssertionMsg.print(className, methodName,
                songObj.getType(), "more_info.square_image_url", moreInfo.getSquare_image_url(), songObj.getId()));

        sa.assertTrue(Validate.asCDNURL(moreInfo.getSquare_image()), AssertionMsg.print(className, methodName,
                songObj.getType(), "more_info.square_image", moreInfo.getSquare_image(), songObj.getId()));

        sa.assertTrue(Validate.asNum(moreInfo.getLabel_id()), AssertionMsg.print(className, methodName,
                songObj.getType(), "more_info.label_id", moreInfo.getLabel_id(), songObj.getId()));

        sa.assertTrue(Validate.asString(moreInfo.getDescription()), AssertionMsg.print(className, methodName,
                songObj.getType(), "more_info.description", moreInfo.getDescription(), songObj.getId()));

        sa.assertTrue(Validate.asNum(moreInfo.getSeason_no()), AssertionMsg.print(className, methodName,
                songObj.getType(), "more_info.season_no", moreInfo.getSeason_no(), songObj.getId()));

        sa.assertTrue(Validate.asNum(moreInfo.getShow_id()), AssertionMsg.print(className, methodName,
                songObj.getType(), "more_info.show_id", moreInfo.getShow_id(), songObj.getId()));

        sa.assertTrue(Validate.asString(moreInfo.getShow_title()), AssertionMsg.print(className, methodName,
                songObj.getType(), "more_info.show_title", moreInfo.getShow_title(), songObj.getId()));

        sa.assertTrue(Validate.asString(moreInfo.getSeason_title()), AssertionMsg.print(className, methodName,
                songObj.getType(), "more_info.season_title", moreInfo.getSeason_title(), songObj.getId()));

        sa.assertTrue(Validate.asNum(moreInfo.getEpisode_number()), AssertionMsg.print(className, methodName,
                songObj.getType(), "more_info.episode_number", moreInfo.getEpisode_number(), songObj.getId()));

        sa.assertTrue(Validate.asString(moreInfo.getAd_breaks()), AssertionMsg.print(className, methodName,
                songObj.getType(), "more_info.ad_breaks", moreInfo.getAd_breaks(), songObj.getId()));

        sa.assertTrue(Validate.asExternalURL(moreInfo.getShow_url()), AssertionMsg.print(className, methodName,
                songObj.getType(), "more_info.show_url", moreInfo.getShow_url(), songObj.getId()));


    }

}
