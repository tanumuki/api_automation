/**
 * 
 */
package validators.genericValidators;


import entities.*;
import org.testng.asserts.SoftAssert;

import validators.AssertionMsg;
import validators.Validate;

/**
 * @author aswingokulachandran
 *
 */
public class AlbumValidator extends EntityValidator {
	
	final String className = SongValidator.class.getName();
	
	public void validate(Album album, SoftAssert sa) {

		final String methodName = new Throwable().getStackTrace()[0].getMethodName();

		System.out.println("========" + className + "---" + methodName + "========");
		
		super.validate(album, sa);

		if(album instanceof AlbumWithSongsList)
			validate((AlbumWithSongsList) album, sa);

		validateAlbumMoreInfo(album.getMoreInfo(), sa, album.getId());

		Modules modules = album.getModules();
		if(modules != null)
			new ModulesDataValidator().validate(modules, sa);

		if(Validate.isNonEmptyString(album.getDescription())) {
			sa.assertTrue(Validate.asString(album.getDescription()), AssertionMsg.print(methodName, methodName, "album.description", album.getDescription()));
		}

	}

	void validateAlbumMoreInfo(AlbumMoreInfo mi, SoftAssert sa, String albumId) {
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();

		ArtistMap artistMap = mi.getArtistMap();
		new ArtistMapValidator().validate(artistMap, sa, "album", albumId);

		if(mi.getCtr() != null)
			sa.assertTrue(Validate.asNum(mi.getCtr()), AssertionMsg.print(className, methodName, "album.more_info.ctr", String.valueOf(mi.getCtr())));

		if(Validate.isNonEmptyString(mi.getQuery()))
			sa.assertTrue(Validate.asString(mi.getQuery()), AssertionMsg.print(className, methodName, "album.more_info.query", mi.getQuery()));

		if(Validate.isNonEmptyString(mi.getText()))
			sa.assertTrue(Validate.asString(mi.getText()), AssertionMsg.print(className, methodName, "album.more_info.text", mi.getText()));

		if(Validate.isNonEmptyString(mi.getMusic()))
			sa.assertTrue(Validate.asString(mi.getMusic()), AssertionMsg.print(className, methodName, "album.more_info.music", mi.getMusic()));

		if(Validate.isNonEmptyString(mi.getSongCount()))
			sa.assertTrue(Validate.asNum(mi.getSongCount()), AssertionMsg.print(className, methodName, "album.more_info.song_count", mi.getSongCount()));

		if(Validate.isNonEmptyString(mi.getCopyrightText()))
			sa.assertTrue(Validate.asString(mi.getCopyrightText()), AssertionMsg.print(className, methodName, "album.more_info.copyright_text", mi.getCopyrightText()));

		if(Validate.isNonEmptyString(mi.getRelease_date()))
			sa.assertTrue(Validate.asDate(mi.getRelease_date()), AssertionMsg.print(className, methodName, "album.more_info.release_date", mi.getRelease_date()));

		if(Validate.isNonEmptyString(mi.getMiniObj()))
			sa.assertTrue(Validate.asBoolean(mi.getMiniObj()), AssertionMsg.print(className, methodName, "album.more_info.mini_obj", mi.getMiniObj()));

		if(Validate.isNonEmptyString(mi.getYear()))
			sa.assertTrue(Validate.asNum(mi.getYear()), AssertionMsg.print(className, methodName, "album.more_info.year", mi.getYear()));

		if(Validate.isNonEmptyString(mi.getIsMovie()))
			sa.assertTrue(Validate.asString(mi.getIsMovie()), AssertionMsg.print(className, methodName, "album.more_info.is_movie", mi.getIsMovie()));

		if(Validate.isNonEmptyString(mi.getLanguage()))
			sa.assertTrue(Validate.asMusicLanguages(mi.getLanguage()), AssertionMsg.print(className, methodName, "album.more_info.language", mi.getLanguage()));

		if(Validate.isNonEmptyString(mi.getSongPids()))
			sa.assertTrue(Validate.asSongPids(mi.getSongPids()), AssertionMsg.print(className, methodName, "album.more_info.song_pids", mi.getSongPids()));

		if(mi.getRelease_year() != null)
			sa.assertTrue(mi.getRelease_year() > 1900 && mi.getRelease_year() < 3100, AssertionMsg.print(className, methodName, "album.more_info.release_year", String.valueOf(mi.getRelease_year())));
	}

	public void validate(AlbumWithSongsList album, SoftAssert sa) {
		for(Song song : album.getList()){
			new SongValidator().validate(song, sa);
		}

		Modules modules = album.getModules();
		if(modules != null)
			new ModulesDataValidator().validate(modules, sa);
	}

}
