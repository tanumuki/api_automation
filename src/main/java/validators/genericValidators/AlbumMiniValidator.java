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

//		TODO Ashwin: getTrending doesn't have query, text, music, but artistMoreTopAlbums has it. Need to figure out a way to remove the null check so that both APIs can be validated correctly
		if(Validate.isNonEmptyString(moreInfo.getQuery())) {
			sa.assertTrue(Validate.asString(moreInfo.getQuery()), AssertionMsg.print(methodName, methodName, "album.more_info.query", moreInfo.getQuery()));
		}

		if(Validate.isNonEmptyString(moreInfo.getText())) {
			sa.assertTrue(Validate.asString(moreInfo.getText()), AssertionMsg.print(methodName, methodName, "album.more_info.text", moreInfo.getText()));
		}

		if(Validate.isNonEmptyString(moreInfo.getMusic())) {
			sa.assertTrue(Validate.asString(moreInfo.getMusic()), AssertionMsg.print(methodName, methodName, "album.more_info.music", moreInfo.getMusic()));
		}
		if(Validate.isNonEmptyString(moreInfo.getSongCount())) {
			sa.assertTrue(Validate.asNum(moreInfo.getSongCount()), AssertionMsg.print(methodName, methodName, "album.more_info.song_count", moreInfo.getSongCount()));
		}


		
		ArtistMap artistMap = moreInfo.getArtistMap();
		new ArtistMapValidator().validate(artistMap, sa, "album", albumMini.getId());
	}

}
