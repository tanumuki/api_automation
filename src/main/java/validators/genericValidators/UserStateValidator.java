package validators.genericValidators;

import entities.UserState;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class UserStateValidator {
    final String className = getClass().getName();

    public void validate(UserState us, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
//        if(Validate.isNonEmptyString(String.valueOf(us.getUserLoggedIn())))
        sa.assertTrue(Validate.asBoolean(String.valueOf(us.getUserLoggedIn())), AssertionMsg.print(className, methodName, "user_state.user_logged_in", String.valueOf(us.getUserLoggedIn())));
//        else
//            sa.fail(className+"."+ methodName+"-user_logged_in is null or empty");

//        if(Validate.isNonEmptyString(us.getUsername()))
        if (us.getUserLoggedIn() == 1) {
            sa.assertTrue(Validate.asString(us.getUsername()), AssertionMsg.print(className, methodName, "user_state.username", us.getUsername()));

            if (Validate.isNonEmptyString(us.getDob()))
                sa.assertTrue(Validate.asDate(us.getDob()), AssertionMsg.print(className, methodName, "user_state.dob", us.getDob()));
//            else
//                sa.fail(className + "." + methodName + "-dob is null or empty");

            if (us.getAge() != null)
                sa.assertTrue(Validate.asUserAge(us.getAge()), AssertionMsg.print(className, methodName, "user_state.age", String.valueOf(us.getAge())));

            sa.assertTrue(Validate.asId(us.getUid()), AssertionMsg.print(className, methodName, "user_state.uid", us.getUid()));

            if (Validate.isNonEmptyString(us.getEncryptedUid()))
                sa.assertTrue(Validate.asString(us.getEncryptedUid()), AssertionMsg.print(className, methodName, "user_state.encrypted_uid", us.getEncryptedUid()));

            if (Validate.isNonEmptyString(us.getEncUid()))
                sa.assertTrue(Validate.asString(us.getEncUid()), AssertionMsg.print(className, methodName, "user_state.enc_uid", us.getEncUid()));

            if (Validate.isNonEmptyString(us.getGender())) {
                sa.assertTrue(Validate.asGender(us.getGender()), AssertionMsg.print(className, methodName, "user_state.gender", us.getGender()));
            }

            if (Validate.isNonEmptyString(us.getFirstname()))
                sa.assertTrue(Validate.asString(us.getFirstname()), AssertionMsg.print(className, methodName, "user_state.firstname", us.getFirstname()));

            if (Validate.isNonEmptyString(us.getLastname()))
                sa.assertTrue(Validate.asString(us.getLastname()), AssertionMsg.print(className, methodName, "user_state.lastname", us.getLastname()));

            if (Validate.isNonEmptyString(us.getNetwork()))
                sa.assertTrue(Validate.asString(us.getNetwork()), AssertionMsg.print(className, methodName, "user_state.network", us.getNetwork()));

            if (Validate.isNonEmptyString(us.getFbid()))
                sa.assertTrue(Validate.asString(us.getFbid()), AssertionMsg.print(className, methodName, "user_state.fbid", us.getFbid()));

            if (Validate.isNonEmptyString(us.getRegisteredDate()))
                sa.assertTrue(Validate.asDateTime(us.getRegisteredDate()), AssertionMsg.print(className, methodName, "user_state.registered_date", us.getRegisteredDate()));

            sa.assertTrue(Validate.asEmailVerifiedStatus(us.getEmail_verified_status()), AssertionMsg.print(className, methodName, "user_state.email_verified_status", us.getEmail_verified_status()));

            sa.assertTrue(Validate.asBoolean(us.getMandatory_verify()), AssertionMsg.print(className, methodName, "user_state.mandatory_verify", String.valueOf(us.getMandatory_verify())));

            sa.assertTrue(Validate.asBoolean(us.getRequire_otp()), AssertionMsg.print(className, methodName, "user_state.require_otp", String.valueOf(us.getRequire_otp())));
            if (us.getEmail()!=null)
            {
                sa.assertTrue(Validate.asEmail(us.getEmail()), AssertionMsg.print(className, methodName, "user_state.email", us.getEmail()));
            }
            sa.assertTrue(Validate.asString(us.getFree_stream_limit()), AssertionMsg.print(className, methodName, "user_state.free_stream_limit", us.getFree_stream_limit()));
            sa.assertTrue(Validate.asNum(us.getFree_stream_counter()), AssertionMsg.print(className, methodName, "user_state.free_stream_limit", String.valueOf(us.getFree_stream_counter())));
            sa.assertTrue(Validate.asBoolean(us.getFree_downloads_enabled()), AssertionMsg.print(className, methodName, "user_state.free_stream_limit", String.valueOf(us.getFree_downloads_enabled())));
        }


        if (us.getProstatus() != null)
            new LoginProStatusValidator().validate(us.getProstatus(), sa);
        else if(us.getUserLoggedIn() == 1)
            sa.fail(className + "." + methodName + "-pro_status is null");

        /*All fields are null now. Please add assertions as and when values are available - Ashwin*/
        if(us.getSecondary_information() != null) {
            sa.assertNull(us.getSecondary_information().getEmail(),
                    "TODO QA: Found possible values. Add assertions: " + us.getSecondary_information().getEmail());
            sa.assertTrue(us.getSecondary_information().getPhone().length() == 0,
                    "TODO QA: Found possible values. Add assertions: " + us.getSecondary_information().getPhone());
            sa.assertNull(us.getSecondary_information().getEmail_verified(),
                    "TODO QA: Found possible values. Add assertions: " + us.getSecondary_information().getEmail_verified());
            sa.assertNull(us.getSecondary_information().getPhone_verified(),
                    "TODO QA: Found possible values. Add assertions: " + us.getSecondary_information().getPhone_verified());
        }

    }

}
