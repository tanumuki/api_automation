package validators.SocialFollow;

import org.testng.asserts.SoftAssert;
import pojos.SocialFollow.*;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EntityValidator;

import java.util.List;

public class socialGetFollowingDetailsValidator extends EntityValidator {
    final String classname = getClass().getName();
    String uid = null;

    public void validate(GetFollowingDetails followingDetails, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(followingDetails, sa);
        uid = followingDetails.getId();
        validateUsers(followingDetails.getFollow(), sa);
        validateUsers(followingDetails.getCounts(), sa);

        sa.assertTrue(Validate.asString(followingDetails.getStatus()), AssertionMsg.print(classname, methodName,
                "UserStatus", followingDetails.getStatus()));
       /* if (followingDetails.getStatus() != null)
            Validate.asString(followingDetails.getStatus(), sa);

        */
    }

    private void validateUsers(List<GetFollowDetails> users, SoftAssert sa) {

         final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        // sa.assertTrue(Validate.asString(users.getUid(), uid));

        if (users != null) {

            for (GetFollowDetails user : users) {
               /* if (user.getType()!= null)
                    Validate.asString(user.getType(), sa);
                */
               // sa.assertTrue(Validate.asString(user.getType()));
                sa.assertTrue(Validate.asString(user.getType()), AssertionMsg.print(classname, methodName,
                        "Type", user.getType()));
                sa.assertTrue(Validate.asString(user.getDetails().getArtistid()));
                sa.assertTrue(Validate.asString(user.getDetails().getName()));

                /* if (user.getDetails().getImage() != null)
                    Validate.asString(user.getDetails().getImage(), sa);
                 */
                sa.assertTrue(Validate.asString(user.getDetails().getImage()));
                sa.assertTrue(Validate.asString(user.getDetails().getFollower_count()));
                sa.assertTrue(Validate.asBoolean(user.getDetails().getIs_followed()));

            }
        }

    }

    private void validateUsers(FollowingCount users, SoftAssert sa) {
        if (users != null) {

            sa.assertTrue(Validate.asNum(users.getFollowing().getUsersCount()));
            sa.assertTrue(Validate.asNum(users.getFollowing().getArtistsCount()));
            sa.assertTrue(Validate.asNum(users.getFollowing().getPlaylistsCount()));
            sa.assertTrue(Validate.asNum(users.getFollowing().getUsersCount()));
            sa.assertTrue(Validate.asString(users.getStatus()));
        }
        }

    }
