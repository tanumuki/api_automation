package validators;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.databind.DeserializationFeature;
//import jdk.nashorn.internal.parser.JSONParser;
import entities.*;
import pojos.libraryOps.*;
import org.testng.asserts.SoftAssert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import pojos.libraryOps.Playlist;
import validators.genericValidators.ArtistMapValidator;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.PlaylistValidator;

@Slf4j
public class LibraryValidator extends EntityValidator {

	String className = getClass().getName();
	private Object List;

	public void validateForNewUSer(LibraryData library, SoftAssert sa) {

		/*
		 * Validating playlist
		 */

		log.info("Library response" + library);

		List<Playlist> list = library.getPlaylist();

		for (int i = 0; i < list.size(); i++) {
			sa.assertTrue(Validate.asId(list.get(i).getId()), className + "." + "validate id failed - ");
			log.info(list.get(i).getId());
			sa.assertTrue(Validate.asTimeStamp(list.get(i).getTs()), className + "." + "validate id failed - ");
			log.info(list.get(i).getTs());

		}
		log.info("Playlist timestamp and id validation complete!");

		/*
		 * Validating show for new user
		 */

		sa.assertTrue(library.getShow().size() == 0);
		log.info("Show size for new user is 0, validation complete!");

		/*
		 * Validating artist for new user
		 */

		sa.assertTrue(library.getArtist().size() == 0);
		log.info("Artist size for new user is 0, validation complete!");


		/*
		 * Validating user json for new user, validating uid, username and image
		 */

		User obj = library.getUser();

		//uid
		log.info("Validating UID " + obj.getUid());
		sa.assertTrue(Validate.asId(obj.getUid()), className + "." + "validate UID failed ");

		//username
		log.info("Validating USERNAME " + obj.getUsername());
		sa.assertTrue(Validate.asString(obj.getUid()), className + "." + "validate username failed ");


		//username
		log.info("Validating IMAGE " + obj.getImage());
		sa.assertTrue(Validate.asCDNURL(obj.getImage()), className + "." + "validate image URL  failed ");


	}

	public void validateLibraryForUserWithUpdatedData(LibraryData library, SoftAssert sa, String seed_album_id, String seed_song_id, String albumResponse) throws JsonMappingException, JsonProcessingException {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		log.info("Album " + seed_album_id);
		log.info("song " + seed_song_id);
		System.out.println("song id " + seed_song_id);

		/*
		 * Verifying if the song , album and songs from the added album is reflected in the user's my library
		 */


		List<String> songList = library.getSong();
		sa.assertTrue(songList.contains(seed_song_id), className + "." + "validate seed song failed ");
		List<String> albumList = library.getAlbum();
		sa.assertTrue(albumList.contains(seed_album_id), className + "." + "validate seed Album failed");

		/*
		 * Verify if the songs are added from the album to the library by calling content.getAlbumDetails
		 */


		//getting song id from library
		Set<String> libraryObjectSet = new HashSet<String>();

		List<String> librarySongList = library.getSong();
		for (int i = 0; i < librarySongList.size(); i++) {
			libraryObjectSet.add(librarySongList.get(i));

		}


		Album album = new ObjectMapper().readValue(albumResponse, Album.class);
		Set<String> albumObjectSet = new HashSet<String>();

		System.out.println("album response" + albumResponse);
		List<Song> albums = (List<Song>) album.getList();
		System.out.println("printing a " + albums.toString());

		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		for (int i = 0; i < albums.size(); i++) {
			Song song = mapper.convertValue(albums.get(i), Song.class);
			albumObjectSet.add(song.getId());
		}

		//Adding the song to album's object
		albumObjectSet.add(seed_song_id);
		System.out.println("=======printing sets============");
		log.info(" libraryObjectSet " + libraryObjectSet.toString());
		log.info(" albumObjectSet " + albumObjectSet.toString());


		/*
		 * comparing the objects
		 */

		sa.assertTrue(CompareSet.equals(libraryObjectSet, albumObjectSet), "Library set and album set did not match.");
		log.info("All the objects are valdated in user's library!");


	}

	public void validateForUSerAfterDeletionOfLibraryData(LibraryData library, SoftAssert sa) {

		/*
		 * Validating playlist
		 */

		log.info("Library response afted deletion" + library);

		List<Playlist> list = library.getPlaylist();

		for (int i = 0; i < list.size(); i++) {
			sa.assertTrue(Validate.asId(list.get(i).getId()), className + "." + "validate id failed - ");
			log.info(list.get(i).getId());
			sa.assertTrue(Validate.asTimeStamp(list.get(i).getTs()), className + "." + "validate id failed - ");
			log.info(list.get(i).getTs());

		}
		log.info("Playlist timestamp and id validation complete!");

		/*
		 * Validating show for new user
		 */

		sa.assertTrue(library.getShow().size() == 0);
		log.info("Show size for new user is 0, validation complete!");

		/*
		 * Validating artist for new user
		 */

		sa.assertTrue(library.getArtist().size() == 0);
		log.info("Artist size for new user is 0, validation complete!");

		/*
		 * Validating song size after deletion
		 */

		sa.assertTrue(library.getSong().size() == 0);
		log.info("Song  size for user after deletion is 0, validation complete!");

		/*
		 * Validating album size after deletion
		 */

		sa.assertTrue(library.getAlbum().size() == 0);
		log.info("Album size for user after deletion is 0, validation complete!");

	}

	public void validateLibraryGetDetailsWithEntityCreds(LibraryEntities library, SoftAssert sa) {

		super.validate(library, sa);

		if(library.getType().equals("album")){
			validateAlbum(library, sa);
		}
		else if(library.getType().equals("show")){
			validateShow(library, sa);
		}
		else if(library.getType().equals("playlist")){
			validatePlaylist(library, sa);
		}

	}

	public void validateAlbum(LibraryEntities library, SoftAssert sa) {
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();
		LibraryMoreInfo libraryMoreInfo = library.getLibraryMoreInfo();
		if (Validate.isNonEmptyString(libraryMoreInfo.getContents())) {
			sa.assertTrue(Validate.asString(libraryMoreInfo.getContents()), AssertionMsg.print(methodName, methodName, "library.more_info.contents", libraryMoreInfo.getContents()));
		}
		if (Validate.isNonEmptyString(libraryMoreInfo.getYear())) {
			sa.assertTrue(Validate.asString(libraryMoreInfo.getYear()), AssertionMsg.print(methodName, methodName, "library.more_info.year", libraryMoreInfo.getYear()));
		}
		ArtistMap artistMap = libraryMoreInfo.getArtistMap();
		if (artistMap != null) {
			for (Artist artist : artistMap.getPrimaryArtists()) {
				new ArtistMapValidator().validate(artist, sa, "primary_artists", "artists", library.getId());
			}
		}
	}

	public void validateShow(LibraryEntities library, SoftAssert sa){
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();
		LibraryMoreInfo libraryMoreInfo = library.getLibraryMoreInfo();
		if (Validate.isNonEmptyString(libraryMoreInfo.getLabel())) {
			sa.assertTrue(Validate.asString(libraryMoreInfo.getLabel()), AssertionMsg.print(methodName, methodName, "library.more_info.label", libraryMoreInfo.getLabel()));
		}
		if (Validate.isNonEmptyString(libraryMoreInfo.getSquareImage())) {
			sa.assertTrue(Validate.asString(libraryMoreInfo.getSquareImage()), AssertionMsg.print(methodName, methodName, "library.more_info.square_image", libraryMoreInfo.getSquareImage()));
		}
		ArtistMap artistMap = libraryMoreInfo.getArtistMap();
		if (artistMap != null){
			if (artistMap.getFeaturedArtists().isEmpty()){
				log.info("Featured artists is not populated for shows");
			}
			for (Artist artist : artistMap.getPrimaryArtists()) {
				new ArtistMapValidator().validate(artist, sa, "primary_artists", "artists", library.getId());
			}
			for(Artist artist : artistMap.getArtists()) {
				new ArtistMapValidator().validate(artist, sa, "artists", "artists", library.getId());
			}

		}
	}

	public void validatePlaylist(LibraryEntities library, SoftAssert sa){
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();
		LibraryMoreInfo libraryMoreInfo = library.getLibraryMoreInfo();
		if(Validate.isNonEmptyString(libraryMoreInfo.getUid()))
			sa.assertTrue(Validate.asString(libraryMoreInfo.getUid()), AssertionMsg.print(className, methodName, "playlist.more_info.uid", libraryMoreInfo.getUid()));

		if(Validate.isNonEmptyString(libraryMoreInfo.getLastUpdated()))
			sa.assertTrue(Validate.asString(libraryMoreInfo.getLastUpdated()), AssertionMsg.print(className, methodName, "playlist.more_info.last_updated", libraryMoreInfo.getLastUpdated()));

		if(Validate.isNonEmptyString(libraryMoreInfo.getUsername()))
			sa.assertTrue(Validate.asString(libraryMoreInfo.getUsername()), AssertionMsg.print(className, methodName, "playlist.more_info.username", libraryMoreInfo.getUsername()));

		if(Validate.isNonEmptyString(libraryMoreInfo.getFirstname()))
			sa.assertTrue(Validate.asString(libraryMoreInfo.getFirstname()), AssertionMsg.print(className, methodName, "playlist.more_info.firstname", libraryMoreInfo.getFirstname()));

		if(Validate.isNonEmptyString(libraryMoreInfo.getLastname()))
			sa.assertTrue(Validate.asString(libraryMoreInfo.getLastname()), AssertionMsg.print(className, methodName, "playlist.more_info.lastname", libraryMoreInfo.getLastname()));

		if(Validate.isNonEmptyString(libraryMoreInfo.getIsFollowed()))
			sa.assertTrue(Validate.asString(libraryMoreInfo.getIsFollowed()), AssertionMsg.print(className, methodName, "playlist.more_info.is_followed", libraryMoreInfo.getIsFollowed()));

		if(Validate.isNonEmptyString(libraryMoreInfo.getFollowerCount()))
			sa.assertTrue(Validate.asNum(libraryMoreInfo.getFollowerCount()), AssertionMsg.print(className, methodName, "playlist.more_info.follower_count", libraryMoreInfo.getFollowerCount()));

		if(Validate.isNonEmptyString(libraryMoreInfo.getShare()))
			sa.assertTrue(Validate.asString(libraryMoreInfo.getShare()), AssertionMsg.print(className, methodName, "playlist.more_info.share", libraryMoreInfo.getShare()));

		if(libraryMoreInfo.getSubTypes() != null && libraryMoreInfo.getSubTypes().size() > 0){
			for(Object subtype : libraryMoreInfo.getSubTypes()){
				sa.assertTrue(Validate.asPlaylistSubtype((String) subtype), AssertionMsg.print(className, methodName, "playlist.more_info.subtype", (String) subtype));
			}
		}

		if(libraryMoreInfo.getImages()!=null) {
			sa.assertTrue(libraryMoreInfo.getImages().isEmpty(), AssertionMsg.print(className, methodName, "playlist.more_info.images", libraryMoreInfo.getImages().toString()));
		}

		if(Validate.isNonEmptyString(libraryMoreInfo.getVideoCount())) {
			sa.assertTrue(Validate.asNum(libraryMoreInfo.getVideoCount()),
					AssertionMsg.print(className, methodName, "playlist.more_info.video_count",libraryMoreInfo.getVideoCount()));
		}
	}
}

