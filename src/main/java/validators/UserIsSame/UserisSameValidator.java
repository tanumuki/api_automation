package validators.UserIsSame;

import org.testng.asserts.SoftAssert;
import pojos.userIsSame.GetUserDetails;
import pojos.userIsSame.UserIsSameDetails;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;

public class UserisSameValidator extends EntityValidator {
    final String classname = getClass().getName();

    public void validate(UserIsSameDetails userDetails, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(userDetails, sa);
        UsersValidators(userDetails.getData(), sa);

        sa.assertTrue(Validate.asString(userDetails.getStatus()), AssertionMsg.print(classname, methodName,
                "Status", userDetails.getStatus()));
    }


    private void UsersValidators(GetUserDetails users, SoftAssert sa) {

        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if (users != null) {
            sa.assertTrue(Validate.asBoolean(users.getIs_same()), AssertionMsg.print(classname,
                    methodName, "Is_Same", String.valueOf(users.getIs_same())));
            sa.assertTrue(Validate.asBoolean(users.getIs_popup()), AssertionMsg.print(classname,
                    methodName, "Is_PopUp", String.valueOf(users.getIs_popup())));
            sa.assertTrue(Validate.asString(users.getMsg()));
            sa.assertTrue(Validate.asString(users.getMsg()), AssertionMsg.print(classname,
                    methodName, "Msg", users.getMsg()));
            }
    }
}
