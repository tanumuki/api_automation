package validators.jioLoginValidator;

import org.testng.asserts.SoftAssert;
import pojos.jioTuneLogin.JioUserData;
import pojos.jioTuneLogin.UserJioLogin;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.SongValidator;

public class JioLoginValidator {

    final String className = JioLoginValidator.class.getName();


    public void validate(UserJioLogin userJioLogin, SoftAssert softAssert){

        final String methodName = new Throwable().getStackTrace()[0].getMethodName();


        /*
        Validate user login data
         */

        Validate.validateUserData(userJioLogin.getData(),softAssert );

        /*
        Validate jio_trial_redeem
         */

        if(Validate.isNonEmptyString(userJioLogin.getJioTrialRedeem())){
            softAssert.assertTrue(Validate.asBoolean(userJioLogin.getJioTrialRedeem()), AssertionMsg.print(className, methodName, "jio_trial_redeem", "user.jiologin.jio_trial_redeem"));
        }

         /*
        Validate jio_trial_duration
         */

        if(Validate.isNonEmptyString(userJioLogin.getJioTrialDuration())){
            softAssert.assertTrue(Validate.asJioTrialDuration(userJioLogin.getJioTrialDuration()), AssertionMsg.print(className, methodName, "jio_trial_duration", "user.jiologin.jio_trial_duration"));
        }

        /*
           Validate jio user data
         */

        validateJioUserData(userJioLogin.getJioUserData(), softAssert);

    }

    private void validateJioUserData(JioUserData jioUserData, SoftAssert softAssert) {


        final String methodName = new Throwable().getStackTrace()[0].getMethodName();


        if(Validate.isNonEmptyString(jioUserData.getUnique()))
            softAssert.assertTrue(Validate.asAlphaNumericWithHyphen(jioUserData.getUnique()), AssertionMsg.print(className, methodName, "jio user data unique field", "user.jiologin.jio_user_data"));
        if(Validate.isNonEmptyString(jioUserData.getUid()))
            softAssert.assertTrue(Validate.asUid(jioUserData.getUid()), AssertionMsg.print(className, methodName, "jio user data uid field", "user.jiologin.jio_user_data"));
        if(Validate.isNonEmptyString(jioUserData.getSubscriberId()))
            softAssert.assertTrue(Validate.asSubscriberId(jioUserData.getSubscriberId()),AssertionMsg.print(className, methodName, "jio user data subscriber id field", "user.jiologin.jio_user_data"));
        if(Validate.isNonEmptyString(jioUserData.getAge()))
           softAssert.assertTrue(Validate.asUserAgeJioData(jioUserData.getAge()), AssertionMsg.print(className, methodName, "jio user data age field", "user.jiologin.jio_user_data"));
        if(Validate.isNonEmptyString(jioUserData.getGender()))
            softAssert.assertTrue(Validate.asGender(jioUserData.getGender()), AssertionMsg.print(className, methodName, "jio user data gender field", "user.jiologin.jio_user_data"));
        if(Validate.isNonEmptyString(jioUserData.getPhoneNumber()))
            softAssert.assertTrue(Validate.asEncryptedJioPhoneNumber(jioUserData.getPhoneNumber()), AssertionMsg.print(className, methodName, "jio user data phone number field", "user.jiologin.jio_user_data"));
        if(Validate.isNonEmptyString(jioUserData.getVersion()))
            softAssert.assertTrue(Validate.asNum(jioUserData.getVersion()),AssertionMsg.print(className, methodName, "jio user data version number field", "user.jiologin.jio_user_data"));
        if(Validate.isNonEmptyString(jioUserData.getMaskedPhoneNumber()))
            softAssert.assertTrue(Validate.asMaskedPhoneNumber(jioUserData.getMaskedPhoneNumber()),AssertionMsg.print(className, methodName, "jio user data masked phone number field", "user.jiologin.jio_user_data"));
        
            softAssert.assertAll();
    }








}
