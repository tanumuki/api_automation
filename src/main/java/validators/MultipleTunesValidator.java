package validators;

import entities.MultipleTunes;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import validators.genericValidators.EntityValidator;

@Slf4j
public class MultipleTunesValidator extends EntityValidator {
    final String className = getClass().getName();

    public void validate(MultipleTunes tunes, SoftAssert sa){
        String methodName =  new Throwable().getStackTrace()[0].getMethodName();

//        Validate id, title, subtitle, type, subtype, vcode and vlink
        sa.assertTrue(Validate.asNum(tunes.getId()), AssertionMsg.print(className, methodName, "subtype", tunes.getId()));
        log.info("Validation done for field id "+ tunes.getId());

        sa.assertTrue(Validate.asString(tunes.getTitle()), AssertionMsg.print(className, methodName, "vcode", tunes.getTitle()));
        log.info("Validation done for title "+ tunes.getTitle());

        sa.assertTrue(Validate.asEntityType(tunes.getType()), AssertionMsg.print(className, methodName, "vlink", tunes.getType()));
        log.info("Validation done for type "+tunes.getType());

        if(tunes.getSubtype() == "artistTune")
            sa.assertTrue(Validate.asCDNURL(tunes.getImage()), AssertionMsg.print(className, methodName, "vlink", tunes.getImage()));
            log.info("Validation done for image "+tunes.getImage());

        sa.assertTrue(Validate.asJTSubType(tunes.getSubtype()), AssertionMsg.print(className, methodName, "subtype", tunes.getSubtype()));
        log.info("Validation done for subtype "+ tunes.getSubtype());

        sa.assertEquals(tunes.getVcode(), tunes.getId(), AssertionMsg.print(className, methodName, "vcode", tunes.getVcode()));
        log.info("Validation done for vcode and it is same as ID "+ tunes.getVcode());

        sa.assertTrue(Validate.asJTVLink(tunes.getVlink()), AssertionMsg.print(className, methodName, "vlink", tunes.getVlink()));
        log.info("Validation done for vlink "+tunes.getVlink());

        sa.assertTrue(Validate.asString(tunes.getSubtitle()), AssertionMsg.print(className, methodName, "subtitle", tunes.getSubtitle()));
        log.info("Validation done for subtitle"+tunes.getSubtitle());


    }

}
