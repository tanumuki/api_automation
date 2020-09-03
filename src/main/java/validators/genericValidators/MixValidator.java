package validators.genericValidators;

import entities.Mix;
import entities.MixMoreInfo;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class MixValidator extends EntityValidator {
    final String className = getClass().getName();
    public void validate(Mix mix, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        super.validate(mix, sa);

        if(Validate.isNonEmptyString(mix.getDescription()))
            sa.assertTrue(Validate.asString(mix.getDescription()), AssertionMsg.print(className, methodName, "mix.description", mix.getDescription()));

        MixMoreInfo mi = mix.getMoreInfo();

        if(Validate.isNonEmptyString(mi.getContents()))
            sa.assertTrue(Validate.asString(mi.getContents()), AssertionMsg.print(className, methodName, "mix.more_info.contents", mi.getContents()));

        if(Validate.isNonEmptyString(mi.getColorCode()))
            sa.assertTrue(Validate.asNum(mi.getColorCode()), AssertionMsg.print(className, methodName, "mix.more_info.color_code", mi.getColorCode()));

        if(Validate.isNonEmptyString(mi.getUid()))
            sa.assertTrue(Validate.asId(mi.getUid()), AssertionMsg.print(className, methodName, "mix.more_info.uid", mi.getUid()));

        if(Validate.isNonEmptyString(mi.getFirstname()))
            sa.assertTrue(Validate.asString(mi.getFirstname()), AssertionMsg.print(className, methodName, "mix.more_info.firstname", mi.getFirstname()));

        if(Validate.isNonEmptyString(mi.getLastname()))
            sa.assertTrue(Validate.asString(mi.getLastname()), AssertionMsg.print(className, methodName, "mix.more_info.lastname", mi.getLastname()));

        if(Validate.isNonEmptyString(mi.getLastUpdated()))
            sa.assertTrue(Validate.asTimeStamp(mi.getLastUpdated()), AssertionMsg.print(className, methodName, "mix.more_info.last_updated", mi.getLastUpdated()));

        if(Validate.isNonEmptyString(mi.getReward()))
            sa.assertTrue(Validate.asFloat(mi.getReward()), AssertionMsg.print(className, methodName, "mix.more_info.reward", mi.getReward()));
    }
}
