/**
 * 
 */
package validators.genericValidators;


import entities.*;
import org.testng.asserts.SoftAssert;

import scala.Enumeration;
import validators.AssertionMsg;
import validators.Validate;

import java.util.ArrayList;
import java.util.List;

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
/*
		Object listVal = album.getList();
		if(listVal instanceof String){
			sa.assertTrue(Validate.asString((String) listVal), AssertionMsg.print(className, methodName, "album.list", (String)listVal));
		}else if(listVal instanceof List){
			List<Song> songs = (List<Song>) (List<?>)listVal;

			for(Object song : songs){
				Song songItem = (Song) song;
				new SongValidator().validate(songItem, sa, album.getId(), "album");
			}
		}
*/
		AlbumMoreInfo moreInfo = album.getMoreInfo();

		if(Validate.isNonEmptyString(moreInfo.getSongCount()))
			sa.assertTrue(Validate.asNum(moreInfo.getSongCount()), AssertionMsg.print(methodName, methodName, "album.more_info.song_count", moreInfo.getSongCount()));

		if(Validate.isNonEmptyString(moreInfo.getCopyrightText()))
			sa.assertTrue(Validate.asString(moreInfo.getCopyrightText()), AssertionMsg.print(methodName, methodName, "album.more_info.copyright_text", moreInfo.getCopyrightText()));


		ArtistMap artistMap = moreInfo.getArtistMap();
		new ArtistMapValidator().validate(artistMap, sa, "album", album.getId());

		Modules modules = album.getModules();
		if(modules != null)
			new ModulesValidator().validate(modules, sa);


	}

	public void validate(AlbumWithSongsList album, SoftAssert sa) {
		for(Song song : album.getList()){
			new SongValidator().validate(song, sa);
		}
	}

}
