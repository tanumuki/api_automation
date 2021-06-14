package validators;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.*;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.SongValidator;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


//Song song = new Song();
////        new SongValidator().validate(song, sa, song.getId(), "song");
////        System.out.println("came till the last");
////        {
//        for (Webradio playlistMini: webRadioDataPojo.getWebradioList())
//        {
//            new SongValidator().validate(song, sa, song.getId(), "song");
//
////                for(Song songPojo: webRadioDataPojo.getCount()) {
////                }
//        }
////        sa.assertTrue(Validate.asNum(webRadioDataPojo.getCount()),className + "." + "validate count failed for entity type playlist");
////        sa.assertTrue(Validate.asBoolean(webRadioDataPojo.getLast_page()),className + "." + "validate last_page failed or entity type playlist");
//
////        }

//        for (Map.Entry<String, Song> data : webRadioDataSingle.getSongEntity().entrySet()) {
//            System.out.println(webRadioDataSingle.getSongEntity().entrySet());
//            String key_song = data.getKey();
//            System.out.println(key_song);
//            if(key_song.matches("song")) {
//                new SongValidator().validate(key_song, sa, );
//            }
//        }
//    }