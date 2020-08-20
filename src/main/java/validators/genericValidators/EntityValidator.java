/**
 * 
 */
package validators.genericValidators;

import org.testng.asserts.SoftAssert;

import entities.Entity;
import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;
import validators.AssertionMsg;
import validators.RadioValidator;
import validators.Validate;

/**
 * @author aswingokulachandran
 *
 */
@Slf4j
public class EntityValidator {
	final String className = EntityValidator.class.getName();
	
	public void validate(Entity adObj, SoftAssert sa) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		if(adObj.getId() != null)
			sa.assertTrue(Validate.asString(adObj.getId()), AssertionMsg.print(className, methodName, adObj.getType(),"ID", adObj.getId(), adObj.getId()));
		if(adObj.getTitle() != null)
			sa.assertTrue(Validate.asString(adObj.getTitle()), AssertionMsg.print(className, methodName, adObj.getType(),"Title", adObj.getTitle(), adObj.getId()));
		if(adObj.getSubtitle() != null)
			sa.assertTrue(Validate.asString(adObj.getSubtitle()), AssertionMsg.print(className, methodName, adObj.getType(),"Subtitle", adObj.getSubtitle(), adObj.getId()));
		if(adObj.getType() != null)
//			TODO Ashwin: Need to add a custom validator for the "type" field that will validate across all entity classes: artist, song, album, etc
			sa.assertTrue(Validate.asString(adObj.getType()), AssertionMsg.print(className, methodName, adObj.getType(),"Type", adObj.getType(), adObj.getId()));
		if(adObj.getPermaUrl() != null)
			sa.assertTrue(Validate.asPermaURL(adObj.getPermaUrl()), AssertionMsg.print(className, methodName, adObj.getType(),"perma_url", adObj.getPermaUrl(), adObj.getId()));
		if(adObj.getImage() != null)
			sa.assertTrue(Validate.asCDNURL(adObj.getImage()), AssertionMsg.print(className, methodName, adObj.getType(),"image", adObj.getImage(), adObj.getId()));
		if(adObj.getLanguage() != null)
			sa.assertTrue(Validate.asMusicLanguage(adObj.getLanguage()), AssertionMsg.print(className, methodName,adObj.getType(), "language", adObj.getLanguage(), adObj.getId()));
		if(adObj.getYear() != null)
			sa.assertTrue(Validate.asNum(adObj.getYear()), AssertionMsg.print(className, methodName, adObj.getType(),"year", adObj.getYear(), adObj.getId()));
		if(adObj.getPlayCount() != null)
			sa.assertTrue(Validate.asNum(adObj.getPlayCount()), AssertionMsg.print(className, methodName,adObj.getType(), "play_count", adObj.getPlayCount(), adObj.getId()));
		if(adObj.getExplicitContent() != null)
			sa.assertTrue(Validate.asNum(adObj.getExplicitContent()), AssertionMsg.print(className, methodName,adObj.getType(), "explicit_content", adObj.getExplicitContent(), adObj.getId()));
		if(adObj.getListCount() != null)
			sa.assertTrue(Validate.asString(adObj.getListCount()), AssertionMsg.print(className, methodName,adObj.getType(), "list_count", adObj.getListCount(), adObj.getId()));
		if(adObj.getListType() != null)
			sa.assertTrue(Validate.asString(adObj.getListType()), AssertionMsg.print(className, methodName,adObj.getType(), "list_type", adObj.getListType(), adObj.getId()));
		
		
	}
	
	public void validate(Entity adObj, SoftAssert sa, String sourceEntity, String sourceType) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		if(adObj.getId() != null)
			sa.assertTrue( Validate.asString(adObj.getId()), AssertionMsg.print(className, methodName, sourceType,"ID", adObj.getId(), sourceEntity));

		if(adObj.getTitle() != null)
			sa.assertTrue(Validate.asString(adObj.getTitle()), AssertionMsg.print(className, methodName, sourceType,"Title", adObj.getTitle(), sourceEntity));

		if(adObj.getSubtitle() != null)
			sa.assertTrue(Validate.asString(adObj.getSubtitle()), AssertionMsg.print(className, methodName, sourceType,"Subtitle", adObj.getSubtitle(), sourceEntity));

		if(adObj.getType() != null)
//			TODO Ashwin: Need to add a custom validator for the "type" field that will validate across all entity classes: artist, song, album, etc
			sa.assertTrue(Validate.asString(adObj.getType()), AssertionMsg.print(className, methodName, sourceType,"Type", adObj.getType(), sourceEntity));

		if(adObj.getPermaUrl() != null)
			sa.assertTrue(Validate.asPermaURL(adObj.getPermaUrl()), AssertionMsg.print(className, methodName, sourceType,"perma_url", adObj.getPermaUrl(), sourceEntity));

		if(adObj.getImage() != null)
			sa.assertTrue(Validate.asCDNURL(adObj.getImage()), AssertionMsg.print(className, methodName, sourceType,"image", adObj.getImage(), sourceEntity));

		if(adObj.getLanguage() != null)
			sa.assertTrue(Validate.asMusicLanguage(adObj.getLanguage()), AssertionMsg.print(className, methodName,sourceType, "language", adObj.getLanguage(), sourceEntity));

		if(adObj.getYear() != null)
			sa.assertTrue(Validate.asNum(adObj.getYear()), AssertionMsg.print(className, methodName, sourceType,"year", adObj.getYear(), sourceEntity));

		if(adObj.getPlayCount() != null)
			sa.assertTrue(Validate.asNum(adObj.getPlayCount()), AssertionMsg.print(className, methodName,sourceType, "play_count", adObj.getPlayCount(), sourceEntity));

		if(adObj.getExplicitContent() != null)
			sa.assertTrue(Validate.asNum(adObj.getExplicitContent()), AssertionMsg.print(className, methodName,sourceType, "explicit_content", adObj.getExplicitContent(), sourceEntity));

		if(adObj.getListCount() != null)
			sa.assertTrue(Validate.asString(adObj.getListCount()), AssertionMsg.print(className, methodName,sourceType, "list_count", adObj.getListCount(), sourceEntity));

		if(adObj.getListType() != null)
			sa.assertTrue(Validate.asString(adObj.getListType()), AssertionMsg.print(className, methodName,sourceType, "list_type", adObj.getListType(), sourceEntity));
		
		
		log.info("Entity Validation done for "+sourceEntity+ "and "+sourceType);
	}

}
