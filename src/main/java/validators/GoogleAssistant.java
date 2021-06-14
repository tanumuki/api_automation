package validators;

import entities.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.SongValidator;

/**
 * @author snigdhamajee
 *
 */

@Slf4j
public class GoogleAssistant extends EntityValidator {
    final String className = getClass().getName();

    public void validate(GoogleAssistantGet googleAssistantPojo, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if (Validate.isNonEmptyString(googleAssistantPojo.getStationid()))
            sa.assertTrue(Validate.asString(googleAssistantPojo.getStationid()), AssertionMsg.print(className, methodName, "stationid", googleAssistantPojo.getStationid()));

        if (Validate.isNonEmptyString(googleAssistantPojo.getSuccess()))
            sa.assertTrue(Validate.asBoolean(googleAssistantPojo.getSuccess()), AssertionMsg.print(className, methodName, "success", googleAssistantPojo.getSuccess()));

    }

    public void validateWebRadioSingle(WebRadioDataSingle webRadioDataSingle, SoftAssert sa, String stationID) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if (Validate.isNonEmptyString(webRadioDataSingle.getStationid()))
            sa.assertEquals((webRadioDataSingle.getStationid()), stationID,
                    AssertionMsg.print(className, methodName, "stationid", webRadioDataSingle.getStationid()));
        Song songObj = webRadioDataSingle.getSong();
        new SongValidator().validate(songObj, sa, songObj.getId(), "song");
    }

    public void validateWebRadioMultiple(WebRadioDataMultiple webRadioDataMultiple, SoftAssert sa, String stationID) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if (Validate.isNonEmptyString(webRadioDataMultiple.getStationid()))
            sa.assertEquals((webRadioDataMultiple.getStationid()), stationID,
                    AssertionMsg.print(className, methodName, "stationid", webRadioDataMultiple.getStationid()));
        Song songObj = webRadioDataMultiple.getWebradio().getSong();
        new SongValidator().validate(songObj, sa, songObj.getId(), "song");
    }

}
