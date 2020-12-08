package validators.SearchTabHomePage;

import org.testng.asserts.SoftAssert;
import pojos.searchTabHomePage.SearchTabData;
import validators.AssertionMsg;
import validators.Validate;

import java.util.LinkedHashMap;

public class SearchTabDataValidator {

    final String className = getClass().getName();

    public void validate(SearchTabData sd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(sd.getType())){
            sa.assertTrue(Validate.asSearchTabType(sd.getType()), AssertionMsg.print(className, methodName, "SearchTabData.type", sd.getType()));
        }

        Validate.asAssortedEntity(sd.getData(), sa);
    }
}
