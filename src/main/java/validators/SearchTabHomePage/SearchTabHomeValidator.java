package validators.SearchTabHomePage;

import org.testng.asserts.SoftAssert;
import pojos.searchTabHomePage.SearchTabHomePage;
import validators.AssertionMsg;
import validators.Validate;

public class SearchTabHomeValidator {
    final String className = getClass().getName();

    public void validate(SearchTabHomePage sh, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(sh.getStatus())){
            sa.assertTrue(Validate.asBoolean(sh.getStatus()), AssertionMsg.print(className, methodName, "status", sh.getStatus()));
        }else {
            sa.fail("Search Tab home page status is null or empty");
        }

        if(Validate.isNonEmptyString(sh.getNext_sign())){
            sa.assertTrue(Validate.asString(sh.getNext_sign()), AssertionMsg.print(className, methodName, "next_sign", sh.getNext_sign()));
        }


    }
}
