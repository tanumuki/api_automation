/**
 *
 */
package validators.genericValidators;

import entities.*;
import org.testng.asserts.SoftAssert;

import lombok.extern.slf4j.Slf4j;
import validators.AssertionMsg;
import validators.Validate;

import java.util.ArrayList;
import java.util.List;

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

        if(songObj.getMini_obj() == null) {
//            If it's not a mini object, but the full song object, then verify rights, else don't
            validateRights(songObj, sa);
        }

        ArtistMap artistMap = songObj.getMoreInfo().getArtistMap();

        if(artistMap != null){
            new ArtistMapValidator().validate(artistMap, sa, sourceType, sourceEntity);
        }

        if(Validate.isNonEmptyString(songObj.getDescription()))
            sa.assertTrue(Validate.asString(songObj.getDescription()), AssertionMsg.print(className, methodName, "song.description", songObj.getDescription()));


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
        }else if(songObj.getMini_obj() == null){
            //encrypted media URLs don't show up for mini objects
            sa.fail("Song More Info Encrypted Media URL is null/empty for song with ID - " + songObj.getId());
        }

        if(Validate.isNonEmptyString(moreInfo.getThumbnail_url())) {
            sa.assertTrue(Validate.asCDNURL(moreInfo.getThumbnail_url()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.thumbnail_url", moreInfo.getThumbnail_url(), songObj.getId()));
        }else if(songObj.getMini_obj() == null){
            //thumbnail URLs don't show up for mini objects
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

        if (moreInfo.getSong_mappings() != null) {
            List<String> songList = new ArrayList<>(moreInfo.getSong_mappings());
            for(String songID : songList) {
                sa.assertTrue(Validate.asString(songID), AssertionMsg.print(className, methodName,
                        songObj.getType(), "more_info.song_mappings", songID, songObj.getId()));
            }
        }

        if(Validate.isNonEmptyString(moreInfo.getVideo_rate_cap())) {
            sa.assertTrue(Validate.asNum(moreInfo.getVideo_rate_cap()),
                    AssertionMsg.print(className, methodName, "more_info.video_rate_cap", moreInfo.getVideo_rate_cap()));
        }

        if(Validate.isNonEmptyString(moreInfo.getPreview_url())) {
            sa.assertTrue(Validate.asCDNURL(moreInfo.getPreview_url()),
                    AssertionMsg.print(className, methodName, "more_info.preview_url", moreInfo.getPreview_url()));
        }

        if(moreInfo.getVideo_available() != null){
            sa.assertTrue(Validate.asBoolean(moreInfo.getVideo_available()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.video_available", String.valueOf(moreInfo.getVideo_available()), songObj.getId()));
        }

		if(moreInfo.getTriller_available() != null){
            sa.assertTrue(Validate.asBoolean(moreInfo.getTriller_available()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.triller_available", String.valueOf(moreInfo.getTriller_available()), songObj.getId()));
        }

        if(moreInfo.getVideo_thumbnail() != null){
            sa.assertTrue(Validate.asCDNURL(moreInfo.getVideo_thumbnail()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.video_thumbnail", moreInfo.getVideo_thumbnail(), songObj.getId()));
        }

//            verify shortie metadata if shortie is present for a song
        if (moreInfo.getShortie() != null) {

//        duration must be present. So no null checks
            sa.assertTrue(Validate.asNum(moreInfo.getShortie().getDuration()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.shortie.duration", String.valueOf(moreInfo.getShortie().getDuration()), songObj.getId()));

//        is_primary must be present. So no null checks
            sa.assertTrue(Validate.asBoolean(moreInfo.getShortie().getIs_primary()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.shortie.is_primary", String.valueOf(moreInfo.getShortie().getIs_primary()), songObj.getId()));

//        media_url must be present. So no null checks
            sa.assertTrue(Validate.asCDNURL(moreInfo.getShortie().getMedia_url()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.shortie.media_url", moreInfo.getShortie().getMedia_url(), songObj.getId()));

//        image must be present. So no null checks
            sa.assertTrue(Validate.asCDNURL(moreInfo.getShortie().getImage()), AssertionMsg.print(className, methodName,
                    songObj.getType(), "more_info.shortie.image", moreInfo.getShortie().getImage(), songObj.getId()));

        }

        if (moreInfo.getTriller() != null) {
            System.out.println("Validating triller details...");
            for (Triller trillerObj : moreInfo.getTriller()) {
                new TrillerValidator().validate(trillerObj, sa);
            }
        }

        if(Validate.isNonEmptyString(moreInfo.getLanguage()))
            sa.assertTrue(Validate.asMusicLanguages(moreInfo.getLanguage()), AssertionMsg.print(className, methodName, "song.more_info.language", moreInfo.getLanguage()));

        //Validate is_dolby_content
        if(moreInfo.getIs_dolby_content() != null){
            sa.assertTrue(Validate.asBoolean(moreInfo.getIs_dolby_content()), AssertionMsg.print(className, methodName, "song.more_info.is_dolby_content", String.valueOf(moreInfo.getIs_dolby_content())));
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
