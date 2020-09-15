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

		Object listVal = album.getList();
		if(listVal instanceof String){
			sa.assertTrue(Validate.asString((String) listVal), AssertionMsg.print(className, methodName, "album.list", (String)listVal));
		}else if(listVal instanceof List){
			List<Song> songs = (List<Song>) (List<?>)listVal;

			for(Song song : songs){
				new SongValidator().validate(song, sa, album.getId(), "album");
			}
		}

		AlbumMoreInfo moreInfo = album.getMoreInfo();

		if(Validate.isNonEmptyString(moreInfo.getSongCount()))
			sa.assertTrue(Validate.asNum(moreInfo.getSongCount()), AssertionMsg.print(methodName, methodName, "album.more_info.song_count", moreInfo.getSongCount()));

		if(Validate.isNonEmptyString(moreInfo.getCopyrightText()))
			sa.assertTrue(Validate.asString(moreInfo.getCopyrightText()), AssertionMsg.print(methodName, methodName, "album.more_info.copyright_text", moreInfo.getCopyrightText()));
		
		ArtistMap artistMap = moreInfo.getArtistMap();
		
		for(Artist artist : artistMap.getPrimaryArtists()) {
			new ArtistMapValidator().validate(artist, sa, "primary_artists", "album", album.getId());
		}
		
		for(Artist artist : artistMap.getFeaturedArtists()) {
			new ArtistMapValidator().validate(artist, sa, "featured_artists", "album", album.getId());
		}
		
		for(Artist artist : artistMap.getArtists()) {
			new ArtistMapValidator().validate(artist, sa, "artists", "album", album.getId());
		}

		Modules modules = album.getModules();
		if(modules != null)
			new ModulesValidator().validate(modules, sa);


	}

}
