/**
 *
 */
package validators.genericValidators;

import entities.Entity;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
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
		if(Validate.isNonEmptyString(adObj.getId() ))
			sa.assertTrue(Validate.asString(adObj.getId()), AssertionMsg.print(className, methodName, adObj.getType(),"ID", adObj.getId(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getTitle() ))
			sa.assertTrue(Validate.asString(adObj.getTitle()), AssertionMsg.print(className, methodName, adObj.getType(),"Title", adObj.getTitle(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getSubtitle() ))
			sa.assertTrue(Validate.asString(adObj.getSubtitle()), AssertionMsg.print(className, methodName, adObj.getType(),"Subtitle", adObj.getSubtitle(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getType() ))
			sa.assertTrue(Validate.asEntityType(adObj.getType()), AssertionMsg.print(className, methodName, adObj.getType(),"Type", adObj.getType(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getPermaUrl() ))
			sa.assertTrue(Validate.asPermaURL(adObj.getPermaUrl()), AssertionMsg.print(className, methodName, adObj.getType(),"perma_url", adObj.getPermaUrl(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getImage() ))
			sa.assertTrue(Validate.asCDNURL(adObj.getImage()), AssertionMsg.print(className, methodName, adObj.getType(),"image", adObj.getImage(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getLanguage() ))
			sa.assertTrue(Validate.asMusicLanguage(adObj.getLanguage()), AssertionMsg.print(className, methodName,adObj.getType(), "language", adObj.getLanguage(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getYear() ))
			sa.assertTrue(Validate.asNum(adObj.getYear()), AssertionMsg.print(className, methodName, adObj.getType(),"year", adObj.getYear(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getPlayCount() ))
			sa.assertTrue(Validate.asNum(adObj.getPlayCount()), AssertionMsg.print(className, methodName,adObj.getType(), "play_count", adObj.getPlayCount(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getExplicitContent() ))
			sa.assertTrue(Validate.asNum(adObj.getExplicitContent()), AssertionMsg.print(className, methodName,adObj.getType(), "explicit_content", adObj.getExplicitContent(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getListCount() ))
			sa.assertTrue(Validate.asString(adObj.getListCount()), AssertionMsg.print(className, methodName,adObj.getType(), "list_count", adObj.getListCount(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getListType()))
			sa.assertTrue(Validate.asString(adObj.getListType()), AssertionMsg.print(className, methodName,adObj.getType(), "list_type", adObj.getListType(), adObj.getId()));
		if(Validate.isNonEmptyString(adObj.getHeaderDesc()))
			sa.assertTrue(Validate.asString(adObj.getHeaderDesc()), AssertionMsg.print(className, methodName,adObj.getType(), "header_desc", adObj.getHeaderDesc(), adObj.getId()));
		if(adObj.getMiniObj() != null)
			sa.assertTrue(Validate.asBoolean(adObj.getMiniObj()), AssertionMsg.print(className, methodName,adObj.getType(), "mini_obj", String.valueOf(adObj.getMiniObj()), adObj.getId()));
		log.info("Entity Validation done for" + adObj);
	}

	public void validate(Entity adObj, SoftAssert sa, String sourceEntity, String sourceType) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		if(Validate.isNonEmptyString(adObj.getId() ))
			sa.assertTrue( Validate.asString(adObj.getId()), AssertionMsg.print(className, methodName, sourceType,"ID", adObj.getId(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getTitle() ))
			sa.assertTrue(Validate.asString(adObj.getTitle()), AssertionMsg.print(className, methodName, sourceType,"Title", adObj.getTitle(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getSubtitle() ))
			sa.assertTrue(Validate.asString(adObj.getSubtitle()), AssertionMsg.print(className, methodName, sourceType,"Subtitle", adObj.getSubtitle(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getType() ))
			sa.assertTrue(Validate.asEntityType(adObj.getType()), AssertionMsg.print(className, methodName, sourceType,"Type", adObj.getType(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getPermaUrl() ))
			sa.assertTrue(Validate.asPermaURL(adObj.getPermaUrl()), AssertionMsg.print(className, methodName, sourceType,"perma_url", adObj.getPermaUrl(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getImage() ))
			sa.assertTrue(Validate.asCDNURL(adObj.getImage()), AssertionMsg.print(className, methodName, sourceType,"image", adObj.getImage(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getLanguage() ))
			sa.assertTrue(Validate.asMusicLanguage(adObj.getLanguage()), AssertionMsg.print(className, methodName,sourceType, "language", adObj.getLanguage(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getYear() ))
			sa.assertTrue(Validate.asNum(adObj.getYear()), AssertionMsg.print(className, methodName, sourceType,"year", adObj.getYear(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getPlayCount() ))
			sa.assertTrue(Validate.asNum(adObj.getPlayCount()), AssertionMsg.print(className, methodName,sourceType, "play_count", adObj.getPlayCount(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getExplicitContent() ))
			sa.assertTrue(Validate.asNum(adObj.getExplicitContent()), AssertionMsg.print(className, methodName,sourceType, "explicit_content", adObj.getExplicitContent(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getListCount() ))
			sa.assertTrue(Validate.asString(adObj.getListCount()), AssertionMsg.print(className, methodName,sourceType, "list_count", adObj.getListCount(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getListType() ))
			sa.assertTrue(Validate.asString(adObj.getListType()), AssertionMsg.print(className, methodName,sourceType, "list_type", adObj.getListType(), sourceEntity));

		if(Validate.isNonEmptyString(adObj.getHeaderDesc()))
			sa.assertTrue(Validate.asString(adObj.getHeaderDesc()), AssertionMsg.print(className, methodName,adObj.getType(), "header_desc", adObj.getHeaderDesc(), adObj.getId()));

		if(adObj.getMiniObj() != null)
			sa.assertTrue(Validate.asBoolean(adObj.getMiniObj()), AssertionMsg.print(className, methodName,adObj.getType(), "mini_obj", String.valueOf(adObj.getMiniObj()), adObj.getId()));

		log.info("Entity Validation done for "+sourceEntity+ " and "+sourceType);
	}

}
