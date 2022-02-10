package validators.SocialFollow;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.SocialFollow.GetFollowersDetails;
import pojos.SocialFollow.UserGetDetails;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.*;

import java.util.List;

@Slf4j
public class socialGetFollowersDetailsValidator extends EntityValidator {
    final String classname = getClass().getName();
    String uid = null;

    public void validate(GetFollowersDetails followerDetails, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(followerDetails, sa);
        uid = followerDetails.getId();
        validateUsers(followerDetails.getUsers(), sa);

        sa.assertTrue(Validate.asNum(followerDetails.getUsersCount()), AssertionMsg.print(classname, methodName,
                "UserCount", followerDetails.getUsersCount().toString()));
        sa.assertTrue(Validate.asString(followerDetails.getStatus()), AssertionMsg.print(classname, methodName,
                "UserStatus", followerDetails.getStatus()));
    }

    private void validateUsers(List<UserGetDetails> users, SoftAssert sa) {

        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if (users != null) {
            for (UserGetDetails user : users)
            {

                sa.assertTrue(Validate.asString(user.getUid()),
                        AssertionMsg.print(classname, methodName, "UID", user.getUid()));
                sa.assertTrue(Validate.asString(user.getUsername()),
                        AssertionMsg.print(classname, methodName,"UserName", user.getUsername()));
                sa.assertTrue(Validate.asString(user.getImage()),
                        AssertionMsg.print(classname, methodName,"Image", user.getImage()));
                sa.assertTrue(Validate.asString(user.getName()),
                        AssertionMsg.print(classname, methodName,"Name", user.getName()));
                sa.assertTrue(Validate.asString(user.getFollowerCount()),
                        AssertionMsg.print(classname, methodName,"FollowCount", user.getFollowerCount()));
                sa.assertTrue(Validate.asBoolean(user.getIsFollowed()),
                        AssertionMsg.print(classname, methodName,"UserName", String.valueOf(user.getIsFollowed())));

            }
        }
    }
}

