/**
 * 
 */
package validators.genericValidators;

import entities.*;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

import java.util.LinkedHashMap;
import java.util.List;

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

		if(albumMini.getList() instanceof List){
			List<LinkedHashMap> songList = (List<LinkedHashMap>) albumMini.getList();
			Validate.asAssortedEntity(songList, sa);
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

		if(Validate.isNonEmptyString(albumMini.getDescription()))
			sa.assertTrue(Validate.asString(albumMini.getDescription()), AssertionMsg.print(className, methodName, "albumMini.description", albumMini.getDescription()));
		
		ArtistMap artistMap = moreInfo.getArtistMap();
		new ArtistMapValidator().validate(artistMap, sa, "album", albumMini.getId());

		//Validate is_dolby_content
		if(moreInfo.getIs_dolby_content() != null){
			sa.assertTrue(Validate.asBoolean(moreInfo.getIs_dolby_content()), AssertionMsg.print(className, methodName, "album.more_info.is_dolby_content", String.valueOf(moreInfo.getIs_dolby_content())));
		}
	}

}
