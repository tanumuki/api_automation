package validators.genericValidators;

import entities.Suggests;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

import java.util.LinkedHashMap;

public class SuggestsValidator {
    final String className = getClass().getName();

    public void validate(Suggests suggests, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(suggests.getHeadline()))
            sa.assertTrue(Validate.asString(suggests.getHeadline()), AssertionMsg.print(className, methodName, "suggests.headline", suggests.getHeadline()));

        if(Validate.isNonEmptyString(suggests.getBadge()))
            sa.assertTrue(Validate.asString(suggests.getBadge()), AssertionMsg.print(className, methodName, "suggests.badge", suggests.getBadge()));

        for(LinkedHashMap entity : suggests.getItems()){
            Validate.asAssortedEntity(entity, sa);
        }
    }
}
