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


        public void validateMessage(JiotuneSetJioTunePojo setJioTunePojo, SoftAssert softAssert, boolean rerunFlag){
            final String methodName = new Throwable().getStackTrace()[0].getMethodName();

         if(!rerunFlag){
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

         }


            if(rerunFlag){
                  /*
                    Validation of success code, should be equal to 0 for retry set jiotune
                    */
                softAssert.assertTrue(setJioTunePojo.getResult().getData().getSuccess().equals("0"),"JiotuneValidator: Success field is not 0");
                log.info("Success code is 0");

                /*
                Validation of message field for rerun scenario
                */
                softAssert.assertTrue(Validate.asJiotuneSetFailureMessage(setJioTunePojo.getResult().getData().getMsg()), "className: JiotuneValidator: Message field is null/wrong");

            }



            softAssert.assertAll();


        }
    public void validateForFailureMessage(JiotuneSetJioTunePojo setJioTunePojo, SoftAssert softAssert){
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
