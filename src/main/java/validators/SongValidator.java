/**
 * 
 */
package validators;

import org.testng.asserts.SoftAssert;

import entities.Song;

/**
 * @author aswingokulachandran
 *
 */
public class SongValidator {
	final String className = SongValidator.class.getName();
	
	public void validate(Song songObj, SoftAssert sa, String sourceEntity, String sourceType) {
		final String methodName = new Throwable().getStackTrace()[0].getMethodName();
		
		sa.assertTrue(Validate.asId(songObj.getId()), AssertionMsg.print(className, methodName, "song - ", "id", songObj.getId()));

		sa.assertTrue(Validate.asString(songObj.getTitle()), AssertionMsg.print(className, methodName, "song - ", "title", songObj.getTitle()));
		
		sa.assertTrue(Validate.asString(songObj.getSubtitle()), AssertionMsg.print(className, methodName, "song - ", "subtitle", songObj.getSubtitle()));
		
		sa.assertTrue(Validate.asString(songObj.getType()), AssertionMsg.print(className, methodName, "song - ", "type", songObj.getType()));
		
		sa.assertTrue(Validate.asUrl(songObj.getPermaUrl()), AssertionMsg.print(className, methodName, "song - ", "perma_url", songObj.getPermaUrl()));
		
		sa.assertTrue(Validate.asUrl(songObj.getImage()), AssertionMsg.print(className, methodName, "song - ", "image", songObj.getImage()));
		
		sa.assertTrue(Validate.asString(songObj.getLanguage()), AssertionMsg.print(className, methodName, "song - ", "language", songObj.getLanguage()));
		
		sa.assertTrue(Validate.asString(songObj.getYear()), AssertionMsg.print(className, methodName, "song - ", "language", songObj.getLanguage()));
	}

}
