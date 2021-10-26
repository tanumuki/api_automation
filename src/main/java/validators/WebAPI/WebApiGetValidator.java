/**
 * 
 */
package validators.WebAPI;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author snigdha majee
 *
 */

@Slf4j
public class WebApiGetValidator extends EntityValidator {
	
	final String className = WebApiGetValidator.class.getName();
	
	public void validate(WebAPIPlaylist playlist, SoftAssert sa) {

		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

		super.validate(playlist, sa);
		log.info("Validation for the featured playlist is done");

		/**
		 * Validate more_info
		 */
		validateMoreInfo(playlist, sa);
		log.info("Validation done for more_info");

		/**
		 * Validate modules
		 */
		ModulesData modulesData = playlist.getModules().getList();
		ModulesDataValidator.validate(modulesData, sa);
		log.info("Validation for modules");

		/**
		 * Validate list of objects of songs
		 */
		if(playlist.getList() instanceof ArrayList<?>){
			List<LinkedHashMap> songList = mapper.convertValue(playlist.getList(), ArrayList.class);
			Validate.asAssortedEntity(songList, sa);
			log.info("Validation for songs done"+songList);
		}

	}

	public void validateMoreInfo(WebAPIPlaylist playlist, SoftAssert sa) {

		final String methodName = new Throwable().getStackTrace()[0].getMethodName();

		PlaylistMoreInfo moreInfo = playlist.getMore_info();

		if(Validate.isNonEmptyString(moreInfo.getUid()))
			sa.assertTrue(Validate.asString(moreInfo.getUid()), AssertionMsg.print(className, methodName, "playlist.more_info.uid", moreInfo.getUid()));

		if(Validate.isNonEmptyString(moreInfo.getLast_updated()))
			sa.assertTrue(Validate.asString(moreInfo.getLast_updated()), AssertionMsg.print(className, methodName, "playlist.more_info.last_updated", moreInfo.getLast_updated()));

		if(Validate.isNonEmptyString(moreInfo.getUsername()))
			sa.assertTrue(Validate.asString(moreInfo.getUsername()), AssertionMsg.print(className, methodName, "playlist.more_info.username", moreInfo.getUsername()));

		if(Validate.isNonEmptyString(moreInfo.getFirstname()))
			sa.assertTrue(Validate.asString(moreInfo.getFirstname()), AssertionMsg.print(className, methodName, "playlist.more_info.firstname", moreInfo.getFirstname()));

		if(Validate.isNonEmptyString(moreInfo.getLastname()))
			sa.assertTrue(Validate.asString(moreInfo.getLastname()), AssertionMsg.print(className, methodName, "playlist.more_info.lastname", moreInfo.getLastname()));

		if(Validate.isNonEmptyString(moreInfo.getIs_followed()))
			sa.assertTrue(Validate.asString(moreInfo.getIs_followed()), AssertionMsg.print(className, methodName, "playlist.more_info.is_followed", moreInfo.getIs_followed()));

		if(Validate.isNonEmptyString(moreInfo.getFollower_count()))
			sa.assertTrue(Validate.asNum(moreInfo.getFollower_count()), AssertionMsg.print(className, methodName, "playlist.more_info.follower_count", moreInfo.getFollower_count()));

		if(Validate.isNonEmptyString(moreInfo.getShare()))
			sa.assertTrue(Validate.asString(moreInfo.getShare()), AssertionMsg.print(className, methodName, "playlist.more_info.share", moreInfo.getShare()));

		//Validate is_dolby_content
		if(moreInfo.getIs_dolby_content() != null){
			sa.assertTrue(Validate.asBoolean(moreInfo.getIs_dolby_content()), AssertionMsg.print(className, methodName, "playlist.more_info.is_dolby_content", String.valueOf(moreInfo.getIs_dolby_content())));
		}

		// Validate sub_types
		if(moreInfo.getSub_types() != null && moreInfo.getSub_types().size() > 0){
			for(String subtype : moreInfo.getSub_types()){
				sa.assertTrue(Validate.asPlaylistSubtype(subtype), AssertionMsg.print(className, methodName, "playlist.more_info.subtype", subtype));
			}
		}

		if(moreInfo.getImages()!=null) {
			sa.assertTrue(moreInfo.getImages().isEmpty(), AssertionMsg.print(className, methodName, "playlist.more_info.images", moreInfo.getImages().toString()));
		}

		if(moreInfo.getSubtype() instanceof List){
			sa.assertTrue(((List<?>)moreInfo.getSubtype()).size() == 0, "Playlist more_info.subtype of type list has contents. Test validations need to be added.");
		} else if(moreInfo.getSubtype() != null){
			sa.fail("Unsupported subtype for playlist with id - " + playlist.getId());
		}

		if(Validate.isNonEmptyString(moreInfo.getVideo_count())) {
			sa.assertTrue(Validate.asNum(moreInfo.getVideo_count()),
					AssertionMsg.print(className, methodName, "playlist.more_info.video_count",moreInfo.getVideo_count()));
		}

	}
}
