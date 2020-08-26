package validators;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.user_pojos.UserGetProfile;
import pojos.user_pojos.UserProfileUpdate;

@Slf4j
public class UserPofileDataValidator {
    String className = getClass().getName();


    public void validate(UserProfileUpdate profile, SoftAssert sa) {
        //status
        String status = profile.getStatus();
        sa.assertTrue(Validate.asString(status), className + "." + "validate status failed - ");
        log.info("LOG response status in user update API is " + status);

        //profile data
        String firstName = profile.getData().getFirstname();
        sa.assertTrue(Validate.asString(firstName), className + "." + "validate first name failed - ");
        log.info("LOG first name in user update API is " + firstName);

        String lastName = profile.getData().getLastname();
        sa.assertTrue(Validate.asString(lastName), className + "." + "validate last name failed - ");
        log.info("LOG last name in user update API is " + lastName);

        String dob = profile.getData().getDob();
        sa.assertTrue(Validate.asString(dob), className + "." + "validate dob failed - ");
        log.info("LOG DOB in user update API is " + lastName);

        String gender = profile.getData().getGender();
        sa.assertTrue(Validate.asGender(gender), className + "." + "validate gender failed - ");
        log.info("LOG Gender in user update API is " + gender);

    }

    public void validateUserProfileInfo(UserGetProfile userGetProfile, SoftAssert sa) {
        String playlist_count = userGetProfile.getPlaylist_count();
        sa.assertTrue(Validate.asNum(playlist_count), className + "." + "validate playlist count failed - ");
        log.info(("LOG response playlist count in user get profile is " + playlist_count));

        String firstName = userGetProfile.getFirstname();
        sa.assertTrue(Validate.asString(firstName), className + "." + "validate first name failed - ");
        log.info("LOG response first name in user get profile is " + firstName);

        String lastName = userGetProfile.getLastname();
        sa.assertTrue(Validate.asString(lastName), className + "." + "validate last name failed - ");
        log.info("LOG response first name in user get profile is " + lastName);

        String uid = userGetProfile.getUid();
        sa.assertTrue(Validate.asString(uid), className + "." + "validate uid failed - ");
        log.info("LOG response uid in user get profile is " + uid);

        String pro = userGetProfile.getPro();
        sa.assertTrue(Validate.asString(pro), className + "." + "validate pro failed - ");
        log.info("LOG response pro in user get profile is " + pro);

        String username = userGetProfile.getUsername();
        sa.assertTrue(Validate.asEmail(username), className + "." + "validate user name failed - ");
        log.info("LOG response user name in user get profile is " + username);

        if (Validate.isNonEmptyString(userGetProfile.getFbid())) {
            String fbid = userGetProfile.getFbid();
            sa.assertTrue(Validate.asString(fbid), className + "." + "validate fbid failed - ");
        } else {
            log.info("LOG response Fb id in user get profile is NULL or empty");
        }

        String image_url = userGetProfile.getImage_url();
        sa.assertTrue(Validate.asString(image_url), className + "." + "validate image URL failed - ");
        log.info("LOG response image URL in user get profile is " + image_url);

        if (Validate.isNonEmptyString(userGetProfile.getPhone_number())) {
            String phone_number = userGetProfile.getPhone_number();
            sa.assertTrue(Validate.asNum(phone_number), className + "." + "validate phone number failed - ");
        } else {
            log.info("LOG response phone number in user get profile is NULL or empty");
        }

        if (Validate.isNonEmptyString(userGetProfile.getEmail())) {
            String email = userGetProfile.getEmail();
            sa.assertTrue(Validate.asEmail(email), className + "." + "validate email failed - ");
        } else {
            log.info("LOG response email in user get profile is NULL or empty");
        }

        if (Validate.isNonEmptyString(userGetProfile.getGender())) {
            String gender = userGetProfile.getGender();
            sa.assertTrue(Validate.asGender(gender), className + "." + "validate gender failed - ");
        } else {
            log.info("LOG response gender in user get profile is NULL or empty");
        }


        if (Validate.isNonEmptyString(userGetProfile.getDob())) {
            String dob = userGetProfile.getDob();
            sa.assertTrue(Validate.asGender(dob), className + "." + "validate dob failed - ");
        } else {
            log.info("LOG response dob in user get profile is NULL or empty");
        }

        String following_usersCount = userGetProfile.getFollowing().getUsersCount();
        sa.assertTrue(Validate.asNum(following_usersCount), className + "." + "validate following users count failed - ");
        log.info("LOG response following users count in user get profile is " + following_usersCount);

        String following_artistsCount = userGetProfile.getFollowing().getArtistsCount();
        sa.assertTrue(Validate.asNum(following_artistsCount), "validate following users count failed");
        log.info("LOG response following users count in user get profile is " + following_artistsCount);

        String following_playlistsCount = userGetProfile.getFollowing().getPlaylistsCount();
        sa.assertTrue(Validate.asNum(following_playlistsCount), "validate following playlists count failed");
        log.info("LOG response following playlists count in user get profile is " + following_playlistsCount);

        String followedBy_usersCount = userGetProfile.getFollowed_by().getUsersCount();
        sa.assertTrue(Validate.asNum(followedBy_usersCount), "validate following playlists count failed");
        log.info("LOG response followed by users count in user get profile is " + followedBy_usersCount);

        String is_followed = userGetProfile.getIs_followed();
        sa.assertTrue(Validate.asBoolean(is_followed), "validate following playlists count failed");
        log.info("LOG response followed by users count in user get profile is " + is_followed);

        String playlists_id = userGetProfile.getPlaylists().get(0).getId();
        sa.assertTrue(Validate.asString(playlists_id), "validate playlists id failed");
        log.info("LOG response playlists id in user get profile is " + playlists_id);

        String playlists_title = userGetProfile.getPlaylists().get(0).getTitle();
        sa.assertTrue(Validate.asString(playlists_title), "validate playlists title failed");
        log.info("LOG response playlists title in user get profile is " + playlists_title);

        String playlists_subtitle = userGetProfile.getPlaylists().get(0).getSubtitle();
        sa.assertTrue(Validate.asString(playlists_subtitle), "validate playlists subtitle failed");
        log.info("LOG response playlists subtitle in user get profile is " + playlists_subtitle);

        String playlists_type = userGetProfile.getPlaylists().get(0).getType();
        sa.assertTrue(Validate.asString(playlists_type), "validate playlists type failed");
        log.info("LOG response playlists type in user get profile is " + playlists_type);

//        String playlists_perma_url = userGetProfile.getPlaylists().get(0).getPerma_url();
//        sa.assertTrue(Validate.asPermaURL(playlists_perma_url), "validate playlists perma_url failed");
//        log.info("LOG response playlists perma_url in user get profile is " + playlists_perma_url);

        String playlists_image = userGetProfile.getPlaylists().get(0).getImage();
        sa.assertTrue(Validate.asCDNURL(playlists_image), "validate playlists image failed");
        log.info("LOG response playlists perma_url in user get profile is " + playlists_image);

        String playlists_language = userGetProfile.getPlaylists().get(0).getLanguage();
        sa.assertTrue(Validate.asString(playlists_language), "validate playlists language failed");
        log.info("LOG response playlists language in user get profile is " + playlists_language);

        String playlists_year = userGetProfile.getPlaylists().get(0).getYear();
        sa.assertTrue(Validate.asString(playlists_year), "validate playlists year failed");
        log.info("LOG response playlists year in user get profile is " + playlists_year);

        String playlists_play_count = userGetProfile.getPlaylists().get(0).getYear();
        sa.assertTrue(Validate.asString(playlists_play_count), "validate playlists play_count failed");
        log.info("LOG response playlists play_count in user get profile is " + playlists_play_count);

//        String playlists_explicit_content = userGetProfile.getPlaylists().get(0).getExplicit_content();
//        sa.assertTrue(Validate.asNum(playlists_explicit_content), "validate playlists explicit_content failed");
//        log.info("LOG response playlists explicit_content in user get profile is " + playlists_explicit_content);

//        String playlists_list_count = userGetProfile.getPlaylists().get(0).getList_count();
//        sa.assertTrue(Validate.asNum(playlists_list_count), "validate playlists list_count failed");
//        log.info("LOG response playlists list_count in user get profile is " + playlists_list_count);
//
//        String playlists_list_type = userGetProfile.getPlaylists().get(0).getList_type();
//        sa.assertTrue(Validate.asString(playlists_list_type), "validate playlists list_type failed");
//        log.info("LOG response playlists list_type in user get profile is " + playlists_list_type);

        String playlists_list = userGetProfile.getPlaylists().get(0).getList();
        sa.assertTrue(Validate.asString(playlists_list), "validate playlists list failed");
        log.info("LOG response playlists list in user get profile is " + playlists_list);

        String playlists_moreinfo_username = userGetProfile.getPlaylists().get(0).getMore_info().getUsername();
        sa.assertTrue(Validate.asString(playlists_moreinfo_username), "validate username in playlists more info failed");
        log.info("LOG response of username in playlists more info in user get profile is " + playlists_moreinfo_username);

    }

    public static boolean isNonEmptyString(String str) {
        return str != null && !str.equals("") && !str.trim().isEmpty();
    }
}