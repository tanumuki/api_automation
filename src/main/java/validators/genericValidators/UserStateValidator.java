package validators.genericValidators;

import entities.UserState;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class UserStateValidator {
    final String className = getClass().getName();
    public void validate(UserState us, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(String.valueOf(us.getUserLoggedIn())))
            sa.assertTrue(Validate.asBoolean(String.valueOf(us.getUserLoggedIn())), AssertionMsg.print(className, methodName, "user_state.user_logged_in", String.valueOf(us.getUserLoggedIn())));

        if(Validate.isNonEmptyString(us.getUsername()))
            sa.assertTrue(Validate.asString(us.getUsername()), AssertionMsg.print(className, methodName, "user_state.username", us.getUsername()));

        if(Validate.isNonEmptyString(us.getDob()))
            sa.assertTrue(Validate.asDate(us.getDob()), AssertionMsg.print(className, methodName, "user_state.dob", us.getDob()));

//        if(Validate.isNonEmptyString(us.getAge()))
//            sa.assertTrue(Validate.asUserAge(us.getAge()), AssertionMsg.print(className, methodName, "user_state.age", us.getAge()));

        if(Validate.isNonEmptyString(us.getUid()))
            sa.assertTrue(Validate.asId(us.getUid()), AssertionMsg.print(className, methodName, "user_state.uid", us.getUid()));

        if(Validate.isNonEmptyString(us.getEncryptedUid()))
            sa.assertTrue(Validate.asString(us.getEncryptedUid()), AssertionMsg.print(className, methodName, "user_state.encrypted_uid", us.getEncryptedUid()));

        if(Validate.isNonEmptyString(us.getEncUid()))
            sa.assertTrue(Validate.asString(us.getEncUid()), AssertionMsg.print(className, methodName, "user_state.enc_uid", us.getEncUid()));

        if(Validate.isNonEmptyString(us.getGender())){
            sa.assertTrue(Validate.asGender(us.getGender()), AssertionMsg.print(className, methodName,"user_state.gender", us.getGender()));
        }

        if(us.getAge() != null){
            sa.assertTrue(Validate.asNum(us.getAge()), AssertionMsg.print(className, methodName, "user_state.age", String.valueOf(us.getAge())));
        }

        if(Validate.isNonEmptyString(us.getFirstname()))
            sa.assertTrue(Validate.asString(us.getFirstname()), AssertionMsg.print(className, methodName, "user_state.firstname", us.getFirstname()));

        if(Validate.isNonEmptyString(us.getLastname()))
            sa.assertTrue(Validate.asString(us.getLastname()), AssertionMsg.print(className, methodName, "user_state.lastname", us.getLastname()));

        if(Validate.isNonEmptyString(us.getNetwork()))
            sa.assertTrue(Validate.asString(us.getNetwork()), AssertionMsg.print(className, methodName, "user_state.network", us.getNetwork()));

        if(Validate.isNonEmptyString(us.getFbid()))
            sa.assertTrue(Validate.asString(us.getFbid()), AssertionMsg.print(className, methodName, "user_state.fbid", us.getFbid()));

        if(Validate.isNonEmptyString(us.getRegisteredDate()))
            sa.assertTrue(Validate.asDateTime(us.getRegisteredDate()), AssertionMsg.print(className, methodName, "user_state.registered_date", us.getRegisteredDate()));

        if(us.getProstatus() != null)
            new LoginProStatusValidator().validate(us.getProstatus(), sa);

        if(Validate.isNonEmptyString(us.getEmail_verified_status()))
            sa.assertTrue(Validate.asEmailVerifiedStatus(us.getEmail_verified_status()), AssertionMsg.print(className, methodName, "user_state.email_verified_status", us.getEmail_verified_status()));

    }

}
