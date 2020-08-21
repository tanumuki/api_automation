package validators.genericValidators;

import org.testng.asserts.SoftAssert;
import pojos.login_pojos.SlotsUsed;
import validators.AssertionMsg;
import validators.Validate;

public class SlotsUsedValidator {
    final String className = getClass().getName();

    public void validate(SlotsUsed su, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(su.getId()))
            sa.assertTrue(Validate.asString(su.getId()), AssertionMsg.print(className, methodName, "user_state.prostatus.slots_used.id", su.getId()));

        if(Validate.isNonEmptyString(su.getName()))
            sa.assertTrue(Validate.asString(su.getName()), AssertionMsg.print(className, methodName, "user_state.prostatus.slots_used.name", su.getName()));

    }
}
