package validators.JiotuneValidator;

import enums.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojos.setJioTune.JiotuneSetJioTunePojo;
import validators.Validate;

@Slf4j
public class JiotuneValidator {

        final String className = getClass().getName();


        public void validate(JiotuneSetJioTunePojo setJioTunePojo, SoftAssert softAssert){
            final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        /*
        Validation of message code,should equal 200 (hard assert)
         */
            Assert.assertTrue(setJioTunePojo.getMessageCode().equals("200"), "className: JiotuneValidator: Message code field is null/wrong" );

        /*
        Validation of success field
         */
            softAssert.assertTrue(setJioTunePojo.getResult().getData().getSuccess().equals("1"), "className: JiotuneValidator: Success field is null/wrong");

        /*
        Validation of message field
         */

            softAssert.assertTrue(Validate.asJiotuneSetMessage(setJioTunePojo.getResult().getData().getMsg()), "className: JiotuneValidator: Message field is null/wrong");

            softAssert.assertAll();

        }



}
