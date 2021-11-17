package validators.GetUserCurrSubscription;

import org.testng.asserts.SoftAssert;
import pojos.SubsGetUserCurrSubs.GetUserCurrSubs;
import validators.AssertionMsg;
import validators.Validate;

public class GetUserCurrSubsValidator {
    final String className = getClass().getName();

    public void validate(GetUserCurrSubs res, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        sa.assertTrue(Validate.asBoolean(res.getStatus()), AssertionMsg.print(className, methodName, "status", res.getStatus()));

        //TODO: Since the subscription currently returns an empty object, no validation has been come up so far.
        //We are yet to find the contents of the subscription object in the response
    }
}
