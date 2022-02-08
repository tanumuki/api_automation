package validators.SocialFollow;

import io.cucumber.java.bs.A;
import org.testng.asserts.SoftAssert;
import pojos.SocialFollow.GetFollowersDetails;
import pojos.SocialFollow.UserGetDetails;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.*;

import java.util.List;


public class socialGetFollowersDetailsValidator extends EntityValidator {
    final String classname = getClass().getName();
    String uid = null;

    public void validate(GetFollowersDetails followerDetails, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(followerDetails, sa);
        uid = followerDetails.getId();
        validateUsers(followerDetails.getUsers(),sa);

        //validateUsers((userGetDetails) followerDetails.getUsers(), sa);
        //validateModules(channelDetails.getModules(), sa);


        sa.assertTrue(Validate.asNum(followerDetails.getUsersCount()), AssertionMsg.print(classname, methodName,
                "UserCount", followerDetails.getUsersCount().toString()));
        sa.assertTrue(Validate.asString(followerDetails.getStatus()), AssertionMsg.print(classname, methodName,
                "UserStatus", followerDetails.getStatus()));


        /*  public void validateUsers(userGetDetails users,SoftAssert sa) {
            if (followerDetails.getUsers() != null && !followerDetails.getUsers().isEmpty())
                for (Object users : followerDetails.getUsers()) {
                    Validate.asString(users.toString());
                }
        }
*/
         /* if(followerDetails.getUsersCount() != null)
            Validate.asNum(followerDetails.getUsersCount(), sa);
        if(followerDetails.getStatus() != null)
            Validate.asString(followerDetails.getStatus(), sa);
*/
    }


         private void validateUsers(List<UserGetDetails> users, SoftAssert sa) {

            //final String methodName = new Throwable().getStackTrace()[0].getMethodName();

         // sa.assertTrue(Validate.asString(users.getUid(), uid));


             if(users !=null) {
                 for (UserGetDetails user : users
                 ) {

                     sa.assertTrue(Validate.asString(user.getUid()));
                     sa.assertTrue(Validate.asString(user.getUsername()));
                    // if (user.getImage() != null)
                       //  Validate.asString(user.getImage(), sa);
                     sa.assertTrue(Validate.asString(user.getImage()));
                     sa.assertTrue(Validate.asString(user.getName()));
                     sa.assertTrue(Validate.asString(user.getFollowerCount()));
                   //  if (user.getIsFollowed() != null)
                      //   Validate.asBoolean(user.getIsFollowed(), sa);
                     sa.assertTrue(Validate.asBoolean(user.getIsFollowed()));



                 }
             }
    }

    }

