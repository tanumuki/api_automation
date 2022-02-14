package validators.SubscriptionResume;

import org.testng.asserts.SoftAssert;
import pojos.SubscriptionResumeAPI.subscriptionResume;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;

public class SubscriptionResumeValidator extends EntityValidator {
    final String classname = getClass().getName();
    public void validate(subscriptionResume subDetails, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(subDetails, sa);

        sa.assertTrue(Validate.asString(subDetails.getStatus()), AssertionMsg.print(classname, methodName,
                "status", subDetails.getStatus()));


    }
}
