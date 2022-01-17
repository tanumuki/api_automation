package validators.Content;
import entities.*;
import lombok.extern.slf4j.Slf4j;
import pojos.content.HandleUnsupportedDeeplink;
import pojos.content.HandleUnsupportedDeeplinkData;
import validators.AssertionMsg;
import validators.Validate;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.asserts.SoftAssert;
import validators.genericValidators.SongValidator;

import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
public class HandleUnsupportedDeeplinkValidator {
    final String className = getClass().getName();

    public void validate(deeplinkContainer deeplinkContainer, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if (Validate.isNonEmptyString(deeplinkContainer.getStatus()))
            sa.assertTrue(Validate.asString(deeplinkContainer.getStatus()), AssertionMsg.print(className, methodName, "status", deeplinkContainer.getStatus()));
        log.info("Validation done for status " + deeplinkContainer.getStatus());

        if (deeplinkContainer.getData() != null) {
            deeplinkContainer deeplink = (entities.deeplinkContainer) deeplinkContainer.getData();
            new HandleUnsupportedDeeplinkValidator().validate(deeplink, sa);
        } else {
            sa.fail("Details object is empty, validation failed.");
        }
    }


    public void validateHandleUnsupportedDeeplinkData(HandleUnsupportedDeeplink dlObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        HandleUnsupportedDeeplinkData dldata= null;
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        if(Validate.isNonEmptyString(dlObj.getData().toString()))
            sa.assertTrue(Validate.asString(dlObj.getData().toString()),AssertionMsg.print(className, methodName, "data", dlObj.getData().toString()));
        System.out.println("------");
        log.info("Validation done for data " + dlObj.getData().toString());
        Object temp = null;
        temp = dlObj.getData();
        log.info("temp is: "+temp);
        if(temp instanceof LinkedHashMap) {
            dldata = mapper.convertValue(temp, HandleUnsupportedDeeplinkData.class);
        }
        assert dldata != null;



    }

}



