package validators.genericValidators;

import entities.RadioStation;
import entities.RadioStationMoreInfo;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class RadioStationValidator extends EntityValidator {
    final String className = getClass().getName();
    public void validate(RadioStation station, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(station, sa);
            validateMoreInfo(station,sa);

    }

    void validateMoreInfo(RadioStation station, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        RadioStationMoreInfo mi = station.getMore_info();
        if(mi.getDescription() != null)
            sa.assertTrue(Validate.asString(mi.getDescription()), AssertionMsg.print(className, methodName, "radio_station", "radio_station.more_info.description", mi.getDescription(), station.getId() ));

        if(mi.getFeaturedStationType() != null)
            sa.assertTrue(Validate.asFeaturedStationType(mi.getFeaturedStationType()), AssertionMsg.print(className, methodName, "radio_station", "radio_station.more_info.featured_station_type", mi.getFeaturedStationType(), station.getId() ));

        if(mi.getQuery() != null)
            sa.assertTrue(Validate.asString(mi.getQuery()), AssertionMsg.print(className, methodName, "radio_station", "radio_station.more_info.query", mi.getQuery(), station.getId() ));

        if(mi.getColor() != null)
            sa.assertTrue(Validate.asString(mi.getColor()), AssertionMsg.print(className, methodName, "radio_station", "radio_station.more_info.color", mi.getColor(), station.getId() ));

        if(mi.getLanguage() != null)
            sa.assertTrue(Validate.asMusicLanguage(mi.getLanguage()), AssertionMsg.print(className, methodName, "radio_station", "radio_station.more_info.language", mi.getFeaturedStationType(), station.getId() ));

        if(mi.getStationDisplayText() != null)
            sa.assertTrue(Validate.asString(mi.getStationDisplayText()), AssertionMsg.print(className, methodName, "radio_station", "radio_station.more_info.station_display_text", mi.getStationDisplayText(), station.getId() ));

        if(mi.getTags() != null)
            new TagsValidator().validate(mi.getTags(), sa, "radio_station", station.getId());
    }
}
