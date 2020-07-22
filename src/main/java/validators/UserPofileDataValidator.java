package validators;

import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.login_pojos.UserLogin;
import pojos.user_pojos.UserProfileData;
import pojos.user_pojos.UserProfileUpdate;

@Slf4j
public class UserPofileDataValidator {
    String className = getClass().getName();


    public void validate(UserProfileUpdate profile, SoftAssert sa)
    {
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

        String  gender = profile.getData().getGender();
        sa.assertTrue(Validate.asGender(gender), className + "." + "validate gender failed - ");
        log.info("LOG Gender in user update API is "+ gender);

    }
}
