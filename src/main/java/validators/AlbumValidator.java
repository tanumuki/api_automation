/**
 * 
 */
package validators;

import org.testng.asserts.SoftAssert;

import entities.Album;
import entities.AlbumMoreInfo;
import entities.Artist;
import entities.ArtistMap;
import entities.Song;

/**
 * @author aswingokulachandran
 *
 */
public class AlbumValidator extends EntityValidator {
	
	final String className = SongValidator.class.getName();
	
	public void validate(Album album, SoftAssert sa) {
	
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();
		
		super.validate(album, sa);
		
		for(Song song : album.getList()) {
			new SongValidator().validate(song, sa, album.getId(), "album");
		}
		
		AlbumMoreInfo moreInfo = album.getMoreInfo();
		
		sa.assertTrue(Validate.asNum(moreInfo.getSongCount()), AssertionMsg.print(methodName, methodName, "album.more_info.song_count", moreInfo.getSongCount()));
		
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
	}

}
