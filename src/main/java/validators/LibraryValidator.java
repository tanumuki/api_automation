package validators;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

import com.fasterxml.jackson.databind.DeserializationFeature;
//import jdk.nashorn.internal.parser.JSONParser;
import entities.*;
import org.json.JSONObject;
import pojos.libraryOps.LibraryEntities;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import pojos.libraryOps.LibraryData;
import pojos.libraryOps.Playlist;
import pojos.libraryOps.User;
import validators.genericValidators.ArtistMapValidator;
import validators.genericValidators.EntityValidator;

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
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();

		super.validate(library, sa);

		if (library.getList() instanceof List) {
			List<LinkedHashMap> list = (List<LinkedHashMap>) library.getList();
			Validate.asAssortedEntity(list, sa);
		}

		if (library.getType().equals("album")) {
			AlbumMoreInfo moreInfo = library.getMoreInfo();
			if (Validate.isNonEmptyString(moreInfo.getContents())) {
				sa.assertTrue(Validate.asString(moreInfo.getContents()), AssertionMsg.print(methodName, methodName, "library.more_info.contents", moreInfo.getContents()));
			}
			if (Validate.isNonEmptyString(moreInfo.getYear())) {
				sa.assertTrue(Validate.asString(moreInfo.getYear()), AssertionMsg.print(methodName, methodName, "library.more_info.year", moreInfo.getYear()));
			}
			ArtistMap artistMap = moreInfo.getArtistMap();
			if (artistMap != null) {
				for (Artist artist : artistMap.getPrimaryArtists()) {
					new ArtistMapValidator().validate(artist, sa, "primary_artists", "artists", library.getId());
				}
			}
		}

	}
}
