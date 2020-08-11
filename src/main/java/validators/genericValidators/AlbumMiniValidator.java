/**
 * 
 */
package validators.genericValidators;

import entities.*;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

/**
 * @author ashwinsriv
 *
 */
public class AlbumMiniValidator extends EntityValidator {
	
	public void validate(AlbumMiniObject albumMini, SoftAssert sa) {
	
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();
		
		super.validate(albumMini, sa);
		
		AlbumMoreInfo moreInfo = albumMini.getMoreInfo();

		sa.assertTrue(Validate.asString(moreInfo.getQuery()), AssertionMsg.print(methodName, methodName, "album.more_info.query", moreInfo.getQuery()));
		sa.assertTrue(Validate.asString(moreInfo.getText()), AssertionMsg.print(methodName, methodName, "album.more_info.text", moreInfo.getText()));
		sa.assertTrue(Validate.asString(moreInfo.getMusic()), AssertionMsg.print(methodName, methodName, "album.more_info.music", moreInfo.getMusic()));
		sa.assertTrue(Validate.asNum(moreInfo.getSongCount()), AssertionMsg.print(methodName, methodName, "album.more_info.song_count", moreInfo.getSongCount()));

		
		ArtistMap artistMap = moreInfo.getArtistMap();
		
		for(Artist artist : artistMap.getPrimaryArtists()) {
			new ArtistMapValidator().validate(artist, sa, "primary_artists", "album", albumMini.getId());
		}
		
		for(Artist artist : artistMap.getFeaturedArtists()) {
			new ArtistMapValidator().validate(artist, sa, "featured_artists", "album", albumMini.getId());
		}
		
		for(Artist artist : artistMap.getArtists()) {
			new ArtistMapValidator().validate(artist, sa, "artists", "album", albumMini.getId());
		}
	}

}
