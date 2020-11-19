package validators.genericValidators;

import entities.Entity;
import entities.Rights;
import lombok.extern.slf4j.Slf4j;


import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

@Slf4j
public class RightsValidator {
    final String className = SongValidator.class.getName();
    public void validate(Rights rights, SoftAssert sa, String sourceType, String sourceId) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if (rights != null) {
            if(Validate.isNonEmptyString(rights.getCode())) {
                sa.assertTrue(Validate.asSongRightsCode(rights.getCode()), AssertionMsg.print(className, methodName, sourceType,
                        "more_info.rights.code", rights.getCode(), sourceId));
            }

            if(Validate.isNonEmptyString(rights.getCacheable())) {
                sa.assertTrue(Validate.asBoolean(rights.getCacheable()), AssertionMsg.print(className, methodName,
                        sourceType, "more_info.rights.cacheable", rights.getCacheable(), sourceId));
            }

            if(Validate.isNonEmptyString(rights.getDeleteCachedObject())) {
                sa.assertTrue(Validate.asBoolean(rights.getDeleteCachedObject()),
                        AssertionMsg.print(className, methodName, sourceType, "more_info.rights.delete_cached_object",
                                rights.getDeleteCachedObject(), sourceId));
            }

            if(Validate.isNonEmptyString(rights.getReason())) {
                sa.assertTrue(Validate.asString(rights.getReason()), AssertionMsg.print(className, methodName,
                        sourceType, "more_info.rights.reason", rights.getReason(), sourceId));
            }
        }

		log.info("Rights Validation done for "+sourceId+ "and "+sourceType);

    }
}
