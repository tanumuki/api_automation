package validators;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import pojos.login_pojos.LoginData;
import pojos.login_pojos.LoginProstatus;
import pojos.login_pojos.SlotsUsed;
import pojos.login_pojos.UserLogin;

import java.util.List;


@Slf4j
public class UserLoginValidator {

    String className = getClass().getName();

    public void validate(UserLogin login, SoftAssert sa) {


        /*
        Validation of user data
         */

        Validate.validateUserData(login.getData(),sa);

        /*
        Validation of pro status
         */
        Validate.validateProStatus(login.getProstatus(), sa);



    }




}


