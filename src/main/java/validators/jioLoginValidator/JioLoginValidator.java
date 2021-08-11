package validators.jioLoginValidator;

import org.testng.asserts.SoftAssert;
import pojos.jioTuneLogin.UserJioLogin;
import validators.Validate;

public class JioLoginValidator {



    public void validate(UserJioLogin userJioLogin, SoftAssert softAssert){

        /*
        Validate user login data
         */

        Validate.validateUserData(userJioLogin.getData(),softAssert );


    }


}
