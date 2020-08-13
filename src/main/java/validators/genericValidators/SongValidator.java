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
import validators.AssertionMsg;
import validators.Validate;

/**
 * @author aswingokulachandran
 *
 */
public class SongValidator extends EntityValidator {
	final String className = SongValidator.class.getName();

	// Will be sending album as sourceType & album id as sourceEntity
	public void validate(Song songObj, SoftAssert sa, String sourceEntity, String sourceType) {
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();

		super.validate(songObj, sa, sourceEntity, sourceType);

		validateMoreInfo(songObj, sa);

		validateRights(songObj, sa);
		
		ArtistMap artistMap = songObj.getMoreInfo().getArtistMap(); 
		
		for(Artist artist : artistMap.getPrimaryArtists()) {
			new ArtistMapValidator().validate(artist, sa, "primary_artists", sourceType, songObj.getId());
		}
		
		for(Artist artist : artistMap.getFeaturedArtists()) {
			new ArtistMapValidator().validate(artist, sa, "featured_artists", sourceType, songObj.getId());
		}
		
		for(Artist artist : artistMap.getArtists()) {
			new ArtistMapValidator().validate(artist, sa, "artists", sourceType, songObj.getId());
		}

	}

	

	void validateMoreInfo(Song songObj, SoftAssert sa) {
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();
		SongMoreInfo moreInfo = songObj.getMoreInfo();

		sa.assertTrue(Validate.asString(moreInfo.getMusic()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.music", moreInfo.getMusic(), songObj.getId()));

		sa.assertTrue(Validate.asString(moreInfo.getAlbumId()),
				AssertionMsg.print(className, methodName, songObj.getType(), "more_info.album_id",
						moreInfo.getAlbumId(), songObj.getId()));

		sa.assertTrue(Validate.asString(moreInfo.getLabel()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.label", moreInfo.getLabel(), songObj.getId()));

		sa.assertTrue(Validate.asString(moreInfo.getOrigin()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.origin", moreInfo.getOrigin(), songObj.getId()));

		sa.assertTrue(Validate.asBoolean(moreInfo.get_320kbps()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.320kbps", moreInfo.get_320kbps(), songObj.getId()));

		sa.assertTrue(Validate.asString(moreInfo.getEncryptedMediaUrl()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.encrypted_media_url", moreInfo.getEncryptedMediaUrl(), songObj.getId()));

		sa.assertTrue(Validate.asString(moreInfo.getEncryptedCacheUrl()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.encrypted_cache_url", moreInfo.getEncryptedCacheUrl(), songObj.getId()));

		sa.assertTrue(Validate.asUrl(moreInfo.getAlbumUrl()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.album_url", moreInfo.getAlbumUrl(), songObj.getId()));

		sa.assertTrue(Validate.asNum(moreInfo.getDuration()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.duration", moreInfo.getDuration(), songObj.getId()));

		sa.assertTrue(Validate.asBoolean(moreInfo.getCacheState()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.cache_state", moreInfo.getCacheState(), songObj.getId()));

		sa.assertTrue(Validate.asBoolean(moreInfo.getHasLyrics()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.has_lyrics", moreInfo.getHasLyrics(), songObj.getId()));

		sa.assertTrue(Validate.asString(moreInfo.getLyricsSnippet()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.lyrics_snippet", moreInfo.getLyricsSnippet(), songObj.getId()));

		sa.assertTrue(Validate.asString(moreInfo.getLyricsSnippet()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.lyrics_snippet", moreInfo.getLyricsSnippet(), songObj.getId()));

		sa.assertTrue(Validate.asBoolean(moreInfo.getStarred()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.starred", moreInfo.getStarred(), songObj.getId()));

		sa.assertTrue(Validate.asString(moreInfo.getCopyrightText()), AssertionMsg.print(className, methodName,
				songObj.getType(), "more_info.copyright_text", moreInfo.getCopyrightText(), songObj.getId()));

		if (moreInfo.getReleaseDate() != null) {
			sa.assertTrue(Validate.asString(moreInfo.getReleaseDate()), AssertionMsg.print(className, methodName,
					songObj.getType(), "more_info.release_date", moreInfo.getReleaseDate(), songObj.getId()));
		}
	}

	void validateRights(Song songObj, SoftAssert sa) {
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();

		Rights rights = songObj.getMoreInfo().getRights();

		new RightsValidator().validate(rights, sa, "song", songObj.getId());
	}

}
