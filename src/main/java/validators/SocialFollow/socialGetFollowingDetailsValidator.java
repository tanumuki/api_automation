package validators.SocialFollow;

import org.testng.asserts.SoftAssert;
import pojos.SocialFollow.*;
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

        if (followingDetails.getStatus() != null)
            Validate.asString(followingDetails.getStatus(), sa);
    }

    private void validateUsers(List<GetFollowDetails> users, SoftAssert sa) {

        //final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        // sa.assertTrue(Validate.asString(users.getUid(), uid));

        if (users != null) {

            for (GetFollowDetails user : users) {
                if (user.getType()!= null)
                    Validate.asString(user.getType(), sa);

                if (user.getDetails().getArtistid() != null)
                    Validate.asString(user.getDetails().getArtistid(), sa);
                if (user.getDetails().getName() != null)
                    Validate.asString(user.getDetails().getName(), sa);
                if (user.getDetails().getImage() != null)
                    Validate.asString(user.getDetails().getImage(), sa);
                if (user.getDetails().getFollower_count() != null)
                    Validate.asString(user.getDetails().getFollower_count(), sa);
                if (user.getDetails().getIs_followed() != null)
                    Validate.asBoolean(user.getDetails().getIs_followed(), sa);


            }
        }

    }

    private void validateUsers(FollowingCount users, SoftAssert sa) {
        if (users != null) {

                if (users.getFollowing().getUsersCount() != null)
                    Validate.asNum(users.getFollowing().getUsersCount(), sa);
                if (users.getFollowing().getArtistsCount() != null)
                    Validate.asNum(users.getFollowing().getArtistsCount(), sa);
                if (users.getFollowing().getPlaylistsCount() != null)
                    Validate.asNum(users.getFollowing().getPlaylistsCount(), sa);
                if (users.getFollowed_by().getUsersCount()!= null)
                    Validate.asNum(users.getFollowing().getUsersCount(), sa);
                if (users.getStatus()!= null)
                Validate.asString(users.getStatus(), sa);


            }
        }
    }
