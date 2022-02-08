package validators.UserIsSame;

import org.testng.asserts.SoftAssert;
import pojos.userIsSame.GetUserDetails;
import pojos.userIsSame.UserIsSameDetails;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;

public class UserisSameValidator extends EntityValidator {
    final String classname = getClass().getName();
    // String uid = null;

    public void validate(UserIsSameDetails userDetails, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(userDetails, sa);
       // uid = userDetails.getId();
        UsersValidators(userDetails.getData(), sa);

        sa.assertTrue(Validate.asString(userDetails.getStatus()), AssertionMsg.print(classname, methodName,
                "Status", userDetails.getStatus()));
      /*   if (userDetails.getStatus() != null)
            Validate.asString(userDetails.getStatus(), sa);
       */

    }


    private void UsersValidators(GetUserDetails users, SoftAssert sa) {

        //final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        // sa.assertTrue(Validate.asString(users.getUid(), uid));

        if (users != null) {
            sa.assertTrue(Validate.asBoolean(users.getIs_same()));
            /* if (users.getIs_popup() != null)
                    Validate.asBoolean(users.getIs_popup(), sa);
             */
            sa.assertTrue(Validate.asBoolean(users.getIs_popup()));
            sa.assertTrue(Validate.asString(users.getMsg()));


            }
    }


}
