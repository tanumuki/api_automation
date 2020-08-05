package validators.genericValidators;

import entities.Entity;
import entities.Rights;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class RightsValidator {
    final String className = SongValidator.class.getName();
    public void validate(Rights rights, SoftAssert sa, String sourceType, String sourceId) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();


        sa.assertTrue(Validate.asNum(rights.getCode()), AssertionMsg.print(className, methodName, sourceType,
                "more_info.rights.code", rights.getCode(), sourceId));

        sa.assertTrue(Validate.asBoolean(rights.getCacheable()), AssertionMsg.print(className, methodName,
                sourceType, "more_info.rights.cacheable", rights.getCacheable(), sourceId));

        sa.assertTrue(Validate.asBoolean(rights.getDeleteCachedObject()),
                AssertionMsg.print(className, methodName, sourceType, "more_info.rights.delete_cached_object",
                        rights.getDeleteCachedObject(), sourceId));

        sa.assertTrue(Validate.asString(rights.getReason()), AssertionMsg.print(className, methodName,
                sourceType, "more_info.rights.reason", rights.getReason(), sourceId));
    }
}
