package validators;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.login_pojos.ErrorPojo;
import pojos.login_pojos.LoginProstatus;
import pojos.login_pojos.SlotsUsed;
import pojos.login_pojos.UserLogin;

import java.util.List;


@Slf4j
public class UserLoginValidator {

    String className = getClass().getName();

    public void validateAll(UserLogin login, SoftAssert sa) {

        validateData(login, sa);
        validateProStatus(login, sa);

    }

    public void validateData(UserLogin login, SoftAssert sa) {

        //get email
        if (Validate.isNonEmptyString(login.getData().getEmail())) {
            String email = login.getData().getEmail();
            log.info("email " + login.getData().getEmail());
            sa.assertTrue(Validate.asEmail(email), className + "." + "validate email failed - ");
        } else {
            log.info("Email field is NULL or empty");
        }


        // get network
        if (Validate.isNonEmptyString(login.getData().getNetwork())) {
            String network = login.getData().getNetwork();
            log.info("network " + network);
            sa.assertTrue(Validate.asString(network), className + "." + "validate network failed - ");
        } else {
            log.info("Network field is NULL or empty");

        }


        // get fbid
        if (Validate.isNonEmptyString(login.getData().getFbid())) {
            sa.assertTrue(Validate.asString(login.getData().getFbid()), className + "." + "validate FBID failed - ");
        } else {
            log.info("FBID is NULL or empty");
        }


        // get reg date
        if (Validate.isNonEmptyString(login.getData().getRegdate())) {
            String regDate = login.getData().getRegdate();
            sa.assertTrue(Validate.asDateTime(regDate), className + "." + "validate regDate failed - ");
        } else {
            log.info("Reg date is NULL or empty");
        }


        // username
        if (Validate.isNonEmptyString(login.getData().getUsername())) {
            String username = login.getData().getUsername();
            sa.assertTrue(Validate.asString(username), className + "." + "validate username failed - ");
        } else {
            log.info("User name is NULL or empty");
        }


        // uid
        if (Validate.isNonEmptyString(login.getData().getUid())) {
            String uid = login.getData().getUid();
            sa.assertTrue(Validate.asId(uid), className + "." + "validate uid failed - ");
        } else {
            sa.fail("UID is NULL or empty");
        }


        // phone number
        if (Validate.isNonEmptyString(login.getData().getPhoneNumber())) {
            String ph = login.getData().getPhoneNumber();
            sa.assertTrue(Validate.asString(ph), className + "." + "validate ph failed - ");
        } else {
            log.info(" phone is NULL or empty");
        }


        // fb token
        if (Validate.isNonEmptyString(login.getData().getFbtoken())) {
            String fbtoken = login.getData().getFbtoken();
            sa.assertTrue(Validate.asString(fbtoken), className + "." + "validate fbToken failed - ");
        } else {
            log.info(" FB TOKEN is NULL or empty");
        }


        // status
        if (Validate.isNonEmptyString(login.getData().getStatus())) {
            String status = login.getData().getStatus();
            sa.assertTrue(Validate.asString(status), className + "." + "validate status failed - ");
        } else {
            log.info(" Status is NULL or empty");
        }


        // lastname
        if (Validate.isNonEmptyString(login.getData().getLastname())) {
            String lastname = login.getData().getLastname();
            sa.assertTrue(Validate.asString(lastname), className + "." + "validate lastname failed - ");
        } else {
            log.info(" lastname is NULL or empty");
        }

        // first name

        if (Validate.isNonEmptyString(login.getData().getFirstname())) {
            String firstname = login.getData().getFirstname();
            sa.assertTrue(Validate.asString(firstname), className + "." + "validate firstname failed - ");
        } else {
            log.info(" firstname is NULL or empty");
        }


        // gender

        if (Validate.isNonEmptyString(login.getData().getGender())) {
            String gender = login.getData().getGender();
            sa.assertTrue(Validate.asGender(gender), className + "." + "validate gender failed - ");
        } else {
            log.info(" gender is NULL or empty");
        }

        // dob

        if (Validate.isNonEmptyString(login.getData().getDob())) {
            String dob = login.getData().getDob();
            sa.assertTrue(Validate.asDate(dob), className + "." + "validate dob failed - ");
        } else {
            log.info(" DOB is NULL or empty");
        }


        // birthyear

        if (Validate.isNonEmptyString(login.getData().getBirthyear())) {
            String birthyear = login.getData().getBirthyear();
            sa.assertTrue(Validate.asDate(birthyear), className + "." + "validate birthyear failed - ");
        } else {
            log.info(" birthyear is NULL or empty");
        }


        // following_count

        if (Validate.isNonEmptyString(login.getData().getFollowingCount())) {
            String followingCount = login.getData().getFollowingCount();
            sa.assertTrue(Validate.asNum(followingCount), className + "." + "validate following_count failed - ");
        } else {
            log.info(" following count is NULL or empty");
        }


        // follower_count
        if (Validate.isNonEmptyString(login.getData().getFollowerCount())) {
            String followerCount = login.getData().getFollowerCount();
            sa.assertTrue(Validate.asNum(followerCount), className + "." + "validate follower_count failed - ");
        } else {
            log.info(" follower count is NULL or empty");
        }

        // update_time
        if (Validate.isNonEmptyString(login.getData().getUpdateTime())) {
            String updateTime = login.getData().getUpdateTime();
            sa.assertTrue(Validate.asDateTime(updateTime), className + "." + "validate update_time failed - ");
        } else {
            log.info(" updateTime  is NULL or empty");
        }


        // paywall_only

        if (Validate.isNonEmptyString(login.getData().getPaywallOnly())) {
            String paywallOnly = login.getData().getPaywallOnly();
            sa.assertTrue(Validate.asBoolean(paywallOnly), className + "." + "validate paywall_only failed - ");
        } else {
            log.info(" paywall only  is NULL or empty");
        }


        // loginwall
        if (Validate.isNonEmptyString(login.getData().getLoginwall())) {
            String loginwall = login.getData().getLoginwall();
            sa.assertTrue(Validate.asBoolean(loginwall), className + "." + "validate loginwall failed - ");
        } else {
            log.info(" loginwall   is NULL or empty");
        }

        // require OTP
        if (login.getData()!=null){
            Boolean otpFlag = login.getData().requireOtp;
            sa.assertTrue(Validate.asBoolean(otpFlag), className + "." + "validate otp flag failed - ");
        } else {
            log.info(" Otp flag is NULL or empty");
        }

    }

    public void validateProStatus(UserLogin login, SoftAssert sa) {

        LoginProstatus proStatus = login.getProstatus();

        if (Validate.isNonEmptyString(proStatus.getProduct())) {
            String product = proStatus.getProduct();
            log.info("product " + product);
            sa.assertTrue(Validate.asProduct(product), className + "." + "validate product failed - ");
        } else {
            log.info("product is NULL or empty");
        }

        // get product type
        if (Validate.isNonEmptyString(String.valueOf(proStatus.getExpirationTimestamp()))) {
            Integer time = proStatus.getExpirationTimestamp();
            sa.assertTrue(Validate.asTimeStamp(String.valueOf(time)), className + "." + "validate time failed - ");
            log.info("exp time stamp is " + time);


        } else {
            log.info("product is NULL or empty");
        }

        // pro status type
        if (Validate.isNonEmptyString(proStatus.getType())) {
            String type = proStatus.getType();
            sa.assertTrue(Validate.asString(type), className + "." + "validate type failed - ");
        } else {
            log.info(" pro status Type  is NULL or empty");
        }

        // pro status offer_trial
        if (Validate.isNonEmptyString(proStatus.getOfferTrial())) {
            String offerTrial = proStatus.getOfferTrial();
            sa.assertTrue(Validate.asString(offerTrial), className + "." + "validate offer_trial failed - ");
        } else {
            log.info(" Offer trial  is NULL or empty");
        }

        //slots used
        if (proStatus.getSlotsUsed() != null) {
            List<SlotsUsed> slots = proStatus.getSlotsUsed();
            for (SlotsUsed su : slots) {
                String id = su.getId();
                log.info("id: " + id);
                sa.assertTrue(Validate.asString(id), className + "." + "validate id failed - ");

                String name = su.getName();
                log.info("name: " + name);
                sa.assertTrue(Validate.asString(name), className + "." + "validate name failed - ");
            }
        }

        //vendor
        if (Validate.isNonEmptyString(proStatus.getVendor())) {
            String vendor = proStatus.getVendor();
            sa.assertTrue(Validate.asString(vendor), className + "." + "validate vendor failed - ");
        } else {
            log.info(" Vendor  is NULL or empty");
        }

    }

    public void validateError(UserLogin login, SoftAssert sa, String expectedErrorMessage) {
        ErrorPojo error = login.getError();
        sa.assertEquals(error.getMsg(), expectedErrorMessage,
                "Expected: \"" + expectedErrorMessage +  "\", but found: \"" + error.getMsg() + "\"");
    }




}


