package validators;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.collection.HasItemInArray;
import org.testng.asserts.SoftAssert;
import lombok.extern.slf4j.Slf4j;
import pojos.libraryOps.LibraryData;
import pojos.libraryOps.Playlist;
import pojos.libraryOps.User;

@Slf4j
public class LibraryValidator {

	String className = getClass().getName();

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
		log.info("Validating UID " +obj.getUid());
		sa.assertTrue(Validate.asId(obj.getUid()),  className + "." + "validate UID failed ");

		//username
		log.info("Validating USERNAME " +obj.getUsername());
		sa.assertTrue(Validate.asString(obj.getUid()),  className + "." + "validate username failed ");
		

		//username
		log.info("Validating IMAGE " +obj.getImage());
		sa.assertTrue(Validate.asUrl(obj.getImage()),  className + "." + "validate image URL  failed ");
	
		

	}
	public void validateLibraryForUserWithUpdatedData(LibraryData library, SoftAssert sa) {
		
	

		
		//sa.assertTrue(library.getSong()
		
		
	}
	
	
	
}
