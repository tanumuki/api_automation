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
    }

    private void validateUsers(List<GetFollowDetails> users, SoftAssert sa) {

         final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if (users != null) {
            for (GetFollowDetails user : users) {

                sa.assertTrue(Validate.asString(user.getType()),
                        AssertionMsg.print(classname, methodName, "Type", user.getType()));
                sa.assertTrue(Validate.asString(user.getDetails().getArtistid()),
                        AssertionMsg.print(classname, methodName, "ArtistID", user.getDetails().getArtistid()));
                sa.assertTrue(Validate.asString(user.getDetails().getName()),
                        AssertionMsg.print(classname, methodName, "Name", user.getDetails().getName()));
                sa.assertTrue(Validate.asString(user.getDetails().getImage()),
                        AssertionMsg.print(classname, methodName, "Image", user.getDetails().getImage()));
                sa.assertTrue(Validate.asString(user.getDetails().getFollower_count()),
                        AssertionMsg.print(classname, methodName, "Follower_Count", user.getDetails().getFollower_count()));
                sa.assertTrue(Validate.asBoolean(user.getDetails().getIs_followed()),
                        AssertionMsg.print(classname, methodName, "Is_Followed", String.valueOf(user.getDetails().getIs_followed())));

            }
        }
    }

    private void validateUsers(FollowingCount users, SoftAssert sa) {

        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if (users != null) {

            sa.assertTrue(Validate.asNum(users.getFollowing().getUsersCount()), AssertionMsg.print(classname,
                    methodName, "UsersCount", String.valueOf(users.getFollowing().getUsersCount())));
            sa.assertTrue(Validate.asNum(users.getFollowing().getArtistsCount()), AssertionMsg.print(classname,
                    methodName, "ArtistsCount", String.valueOf(users.getFollowing().getArtistsCount())));
            sa.assertTrue(Validate.asNum(users.getFollowing().getPlaylistsCount()), AssertionMsg.print(classname,
                    methodName, "PlaylistsCount", String.valueOf(users.getFollowing().getPlaylistsCount())));
            sa.assertTrue(Validate.asNum(users.getFollowing().getUsersCount()), AssertionMsg.print(classname,
                    methodName, "UserCount", String.valueOf(users.getFollowing().getUsersCount())));
            sa.assertTrue(Validate.asString(users.getStatus()));
            sa.assertTrue(Validate.asString(users.getStatus()), AssertionMsg.print(classname,
                    methodName, "Status", users.getStatus()));
        }
    }

}
