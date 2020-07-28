/**
 * 
 */
package validators;

import org.testng.asserts.SoftAssert;

import entities.Album;
import entities.Entity;
import entities.Song;

/**
 * @author aswingokulachandran
 *
 */
public class EntityValidator {
	final String className = EntityValidator.class.getName();
	
	public void validate(Entity adObj, SoftAssert sa) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		sa.assertTrue(Validate.asString(adObj.getId()), AssertionMsg.print(className, methodName, "ID", adObj.getId()));
		
		sa.assertTrue(Validate.asString(adObj.getTitle()), AssertionMsg.print(className, methodName, "Title", adObj.getTitle()));
		
		sa.assertTrue(Validate.asString(adObj.getSubtitle()), AssertionMsg.print(className, methodName, "Subtitle", adObj.getSubtitle()));
		
		sa.assertTrue(Validate.asString(adObj.getType()), AssertionMsg.print(className, methodName, "Type", adObj.getType()));
		
		sa.assertTrue(Validate.asUrl(adObj.getPermaUrl()), AssertionMsg.print(className, methodName, "perma_url", adObj.getPermaUrl()));
		
		sa.assertTrue(Validate.asUrl(adObj.getImage()), AssertionMsg.print(className, methodName, "image", adObj.getImage()));
		
		sa.assertTrue(Validate.asString(adObj.getLanguage()), AssertionMsg.print(className, methodName, "language", adObj.getLanguage()));
		
		sa.assertTrue(Validate.asNum(adObj.getYear()), AssertionMsg.print(className, methodName, "year", adObj.getYear()));
		
		sa.assertTrue(Validate.asNum(adObj.getPlayCount()), AssertionMsg.print(className, methodName, "play_count", adObj.getPlayCount()));
		
		sa.assertTrue(Validate.asNum(adObj.getExplicitContent()), AssertionMsg.print(className, methodName, "explicit_content", adObj.getExplicitContent()));
		
		sa.assertTrue(Validate.asString(adObj.getListCount()), AssertionMsg.print(className, methodName, "list_count", adObj.getListCount()));
		
		sa.assertTrue(Validate.asString(adObj.getListType()), AssertionMsg.print(className, methodName, "list_type", adObj.getListType()));
		
		
		if(adObj.getType().equalsIgnoreCase("album")) {
			new AlbumValidator().validate((Album) adObj, sa);
		}
	}

}
