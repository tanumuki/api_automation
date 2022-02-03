package validators.Content;
import entities.*;
import lombok.extern.slf4j.Slf4j;
import pojos.content.HandleUnsupportedDeeplink;
import validators.AssertionMsg;
import validators.Validate;
import org.testng.asserts.SoftAssert;


@Slf4j
public class HandleUnsupportedDeeplinkValidator {
    final String className = getClass().getName();

    public void validate(DeeplinkContainer deeplinkContainer, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if (Validate.isNonEmptyString(deeplinkContainer.getStatus()))
            sa.assertTrue(Validate.asString(deeplinkContainer.getStatus()), AssertionMsg.print(className, methodName, "status", deeplinkContainer.getStatus()));
        log.info("Validation done for status " + deeplinkContainer.getStatus());

        if (deeplinkContainer.getData() != null) {
            DeeplinkContainer deeplink = (DeeplinkContainer) deeplinkContainer.getData();
            sa.assertTrue(Validate.asString((String) deeplink.getData()), AssertionMsg.print(className, methodName, "data", (String) deeplink.getData()));
        } else {
            sa.fail("Details object is empty, validation failed.");
        }
    }


    public void validateHandleUnsupportedDeeplinkData(HandleUnsupportedDeeplink data, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(data.getData().getMsg())){
            sa.assertEquals(data.getData().getMsg(), "Oops! Looks like you followed a bad link", AssertionMsg.print(className, methodName, "msg", data.getData().getMsg()));
        }
        if(Validate.isNonEmptyString(data.getData().getUpdate_app())){
            sa.assertEquals(data.getData().getUpdate_app(), "false", AssertionMsg.print(className, methodName, "update_app", data.getData().getUpdate_app()));
        }
        log.info("Validation done for message and update app ");
        System.out.println(data.getData().getMsg());
        System.out.println(data.getData().getUpdate_app());


    }

}



