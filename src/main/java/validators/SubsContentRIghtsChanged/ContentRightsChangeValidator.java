package validators.SubsContentRIghtsChanged;

import org.testng.asserts.SoftAssert;
import pojos.SubsContentRightsChanged.ContentRightsChange;
import validators.AssertionMsg;
import validators.Validate;

public class ContentRightsChangeValidator {
    final String className = getClass().getName();

    public void validate(ContentRightsChange cr, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(cr != null) {
            if(cr.getLast_change_at() != null) {
                sa.assertTrue(Validate.asLong(cr.getLast_change_at()), AssertionMsg.print(className, methodName, "last_change_at", String.valueOf(cr.getLast_change_at())));
            }else {
                sa.fail("last_change_at field is missing/null");
            }

            if(cr.getCheck_frequency() != null) {
                sa.assertTrue(Validate.asNum(cr.getCheck_frequency()), AssertionMsg.print(className, methodName, "check_frequency", String.valueOf(cr.getCheck_frequency())));
            }else {
                sa.fail("check_frequency field is missing/null");
            }
        } else {
            sa.fail("Content Changed Rights response is null");
        }
    }
}
