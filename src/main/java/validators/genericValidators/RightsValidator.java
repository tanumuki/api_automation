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
            }else {
                sa.fail("Rights code is null/empty for sourceType - " + sourceType + " and source ID - " + sourceId);
            }

            if(Validate.isNonEmptyString(rights.getCacheable())) {
                sa.assertTrue(Validate.asBoolean(rights.getCacheable()), AssertionMsg.print(className, methodName,
                        sourceType, "more_info.rights.cacheable", rights.getCacheable(), sourceId));
            }else {
                sa.fail("Rights cacheable is null/empty for sourceType - " + sourceType + " and source ID - " + sourceId);
            }

            if(Validate.isNonEmptyString(rights.getDeleteCachedObject())) {
                sa.assertTrue(Validate.asBoolean(rights.getDeleteCachedObject()),
                        AssertionMsg.print(className, methodName, sourceType, "more_info.rights.delete_cached_object",
                                rights.getDeleteCachedObject(), sourceId));
            }else {
                sa.fail("Rights delete cached obj is null/empty for sourceType - " + sourceType + " and source ID - " + sourceId);
            }

            if((Integer.parseInt(rights.getCode()) == 1) || (Integer.parseInt(rights.getCode()) == 2)) {
//              reason should be present IFF the rights are not 0, i.e. if it's 1 or 2, else it's blank
                sa.assertTrue(Validate.asSongRightsReason(rights.getReason()), AssertionMsg.print(className, methodName,
                        sourceType, "more_info.rights.reason.unavailable", rights.getReason(), sourceId));
            }
            if(Integer.parseInt(rights.getCode()) == 0) {
//              in case it's 0, validating that the field is present
                sa.assertTrue(Validate.asString(rights.getReason()), AssertionMsg.print(className, methodName,
                        sourceType, "more_info.rights.reason", rights.getReason(), sourceId));
            }


        } else {
            sa.fail("Rights is null for sourceType - " + sourceType + " and source ID - " + sourceId);
        }

		log.info("Rights Validation done for "+sourceId+ "and "+sourceType);

    }
}
