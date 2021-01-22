package validators.SubsGetStatus;


import org.testng.asserts.SoftAssert;
import pojos.SubsGetStatus.SubscriptionGetStatus;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.LoginProStatusValidator;

public class SubsGetStatusValidator {
    final String className = getClass().getName();

    public void validate(SubscriptionGetStatus gs, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        new LoginProStatusValidator().validate(gs.getProstatus(), sa);

        if(Validate.isNonEmptyString(gs.getReceipt())){
            sa.assertTrue(Validate.asString(gs.getReceipt()), AssertionMsg.print(className, methodName, "prostatus.receipt", gs.getReceipt()));
        }
    }

}
