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
		sa.assertTrue(Validate.asString(adObj.getId()), AssertionMsg.print(className, methodName, adObj.getType(),"ID", adObj.getId(), adObj.getId()));
		
		sa.assertTrue(Validate.asString(adObj.getTitle()), AssertionMsg.print(className, methodName, adObj.getType(),"Title", adObj.getTitle(), adObj.getId()));
		
		sa.assertTrue(Validate.asString(adObj.getSubtitle()), AssertionMsg.print(className, methodName, adObj.getType(),"Subtitle", adObj.getSubtitle(), adObj.getId()));
		
		sa.assertTrue(Validate.asString(adObj.getType()), AssertionMsg.print(className, methodName, adObj.getType(),"Type", adObj.getType(), adObj.getId()));
		
		sa.assertTrue(Validate.asUrl(adObj.getPermaUrl()), AssertionMsg.print(className, methodName, adObj.getType(),"perma_url", adObj.getPermaUrl(), adObj.getId()));
		
		sa.assertTrue(Validate.asUrl(adObj.getImage()), AssertionMsg.print(className, methodName, adObj.getType(),"image", adObj.getImage(), adObj.getId()));
		
		sa.assertTrue(Validate.asString(adObj.getLanguage()), AssertionMsg.print(className, methodName,adObj.getType(), "language", adObj.getLanguage(), adObj.getId()));
		
		sa.assertTrue(Validate.asNum(adObj.getYear()), AssertionMsg.print(className, methodName, adObj.getType(),"year", adObj.getYear(), adObj.getId()));
		
		sa.assertTrue(Validate.asNum(adObj.getPlayCount()), AssertionMsg.print(className, methodName,adObj.getType(), "play_count", adObj.getPlayCount(), adObj.getId()));
		
		sa.assertTrue(Validate.asNum(adObj.getExplicitContent()), AssertionMsg.print(className, methodName,adObj.getType(), "explicit_content", adObj.getExplicitContent(), adObj.getId()));
		
		sa.assertTrue(Validate.asString(adObj.getListCount()), AssertionMsg.print(className, methodName,adObj.getType(), "list_count", adObj.getListCount(), adObj.getId()));
		
		sa.assertTrue(Validate.asString(adObj.getListType()), AssertionMsg.print(className, methodName,adObj.getType(), "list_type", adObj.getListType(), adObj.getId()));
		
		
	}
	
	public void validate(Entity adObj, SoftAssert sa, String sourceEntity, String sourceType) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		sa.assertTrue(Validate.asString(adObj.getId()), AssertionMsg.print(className, methodName, sourceType,"ID", adObj.getId(), sourceEntity));
		
		sa.assertTrue(Validate.asString(adObj.getTitle()), AssertionMsg.print(className, methodName, sourceType,"Title", adObj.getTitle(), sourceEntity));
		
		sa.assertTrue(Validate.asString(adObj.getSubtitle()), AssertionMsg.print(className, methodName, sourceType,"Subtitle", adObj.getSubtitle(), sourceEntity));
		
		sa.assertTrue(Validate.asString(adObj.getType()), AssertionMsg.print(className, methodName, sourceType,"Type", adObj.getType(), sourceEntity));
		
		sa.assertTrue(Validate.asUrl(adObj.getPermaUrl()), AssertionMsg.print(className, methodName, sourceType,"perma_url", adObj.getPermaUrl(), sourceEntity));
		
		sa.assertTrue(Validate.asUrl(adObj.getImage()), AssertionMsg.print(className, methodName, sourceType,"image", adObj.getImage(), sourceEntity));
		
		sa.assertTrue(Validate.asString(adObj.getLanguage()), AssertionMsg.print(className, methodName,sourceType, "language", adObj.getLanguage(), sourceEntity));
		
		sa.assertTrue(Validate.asNum(adObj.getYear()), AssertionMsg.print(className, methodName, sourceType,"year", adObj.getYear(), sourceEntity));
		
		sa.assertTrue(Validate.asNum(adObj.getPlayCount()), AssertionMsg.print(className, methodName,sourceType, "play_count", adObj.getPlayCount(), sourceEntity));
		
		sa.assertTrue(Validate.asNum(adObj.getExplicitContent()), AssertionMsg.print(className, methodName,sourceType, "explicit_content", adObj.getExplicitContent(), sourceEntity));
		
		sa.assertTrue(Validate.asString(adObj.getListCount()), AssertionMsg.print(className, methodName,sourceType, "list_count", adObj.getListCount(), sourceEntity));
		
		sa.assertTrue(Validate.asString(adObj.getListType()), AssertionMsg.print(className, methodName,sourceType, "list_type", adObj.getListType(), sourceEntity));
		
		
	}

}
