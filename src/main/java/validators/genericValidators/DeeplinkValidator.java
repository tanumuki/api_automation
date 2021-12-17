package validators.genericValidators;

import org.testng.asserts.SoftAssert;
import pojos.appGetLaunchData.Deeplink;
import validators.AssertionMsg;
import validators.Validate;

public class DeeplinkValidator extends EntityValidator{
    final String className = getClass().getName();

    public void validate(Deeplink deeplink, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(deeplink, sa);


        sa.assertTrue(Validate.asString(deeplink.getDeeplink()), AssertionMsg.print(className, methodName, "deeplink.deeplink", deeplink.getDeeplink()));

        if(Validate.isNonEmptyString(deeplink.getColor()))
            sa.assertTrue(Validate.asHexColour(deeplink.getColor()), AssertionMsg.print(className, methodName, "deeplink.color", deeplink.getColor()));

    }
}
