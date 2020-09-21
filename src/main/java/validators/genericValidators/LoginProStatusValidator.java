package validators.genericValidators;

import org.testng.asserts.SoftAssert;
import pojos.login_pojos.LoginProstatus;
import pojos.login_pojos.SlotsUsed;
import validators.AssertionMsg;
import validators.Validate;

public class LoginProStatusValidator {
    final String className = getClass().getName();
    public void validate(LoginProstatus lp, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(lp.getType()))
            sa.assertTrue(Validate.asProStatusType(lp.getType()), AssertionMsg.print(className, methodName, "user_state.prostatus.type", lp.getType()));

        if(Validate.isNonEmptyString(lp.getOfferTrial()))
            sa.assertTrue(Validate.asBoolean(lp.getOfferTrial()), AssertionMsg.print(className, methodName, "user_state.prostatus.offer_trial", lp.getOfferTrial()));

        if(Validate.isNonEmptyString(lp.getProduct()))
            sa.assertTrue(Validate.asString(lp.getProduct()), AssertionMsg.print(className, methodName, "user_state.prostatus.product", lp.getProduct()));

        if(lp.getExpirationTimestamp() != null)
            sa.assertTrue(Validate.asTimeStamp(String.valueOf(lp.getExpirationTimestamp())),
                    AssertionMsg.print(className, methodName, "user_state.prostatus.expiration_timestamp", String.valueOf(lp.getExpirationTimestamp())));

        if(Validate.isNonEmptyString(lp.getVendor()))
            sa.assertTrue(Validate.asString(lp.getVendor()), AssertionMsg.print(className, methodName, "user_state.prostatus.vendor", lp.getVendor()));

        if(lp.getSlotsUsed() != null){
            for(SlotsUsed slot : lp.getSlotsUsed()){
                new SlotsUsedValidator().validate(slot, sa);
            }
        }
    }
}
