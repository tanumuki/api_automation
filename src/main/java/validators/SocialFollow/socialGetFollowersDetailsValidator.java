package validators.SocialFollow;

import org.testng.asserts.SoftAssert;
import pojos.SocialFollow.GetFollowersDetails;
import pojos.SocialFollow.UserGetDetails;
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


        //  sa.assertTrue(Validate.asNum(followerDetails.getUsersCount()), AssertionMsg.print(className, methodName, "Followers", "follower_count_details", followerDetails.getUsersCount().toString(), uid));
      //  sa.assertTrue(Validate.asString(followerDetails.getStatus()), AssertionMsg.print(className, methodName, "Followers", "follower_status", followerDetails.getStatus(), uid));

        // sa.assertEquals(java.util.Optional.ofNullable(followerDetails.getUsersCount()),
        // java.util.Optional.ofNullable(followerDetails.getUsers().size()));

        /*  public void validateUsers(userGetDetails users,SoftAssert sa) {
            if (followerDetails.getUsers() != null && !followerDetails.getUsers().isEmpty())
                for (Object users : followerDetails.getUsers()) {
                    Validate.asString(users.toString());
                }
        }
*/
         if(followerDetails.getUsersCount() != null)
            Validate.asNum(followerDetails.getUsersCount(), sa);
        if(followerDetails.getStatus() != null)
            Validate.asString(followerDetails.getStatus(), sa);

    }


         private void validateUsers(List<UserGetDetails> users, SoftAssert sa) {

            //final String methodName = new Throwable().getStackTrace()[0].getMethodName();

          // sa.assertTrue(Validate.asString(users.getUid(), uid));
             if(users !=null) {
                 for (UserGetDetails user : users
                 ) {
                     if (user.getUid() != null)
                         Validate.asString(user.getUid(), sa);
                     if (user.getUsername() != null)
                         Validate.asString(user.getUsername(), sa);
                     if (user.getImage() != null)
                         Validate.asString(user.getImage(), sa);
                     if (user.getName() != null)
                         Validate.asString(user.getName(), sa);
                     if (user.getFollowerCount() != null)
                         Validate.asString(user.getFollowerCount(), sa);
                     if (user.getIsFollowed() != null)
                         Validate.asBoolean(user.getIsFollowed(), sa);


                 }
             }

             System.out.println("Users array is Null");
    }

    }

