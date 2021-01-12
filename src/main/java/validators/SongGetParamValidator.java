package validators;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.SongGetParam.SongGetParamPojo;
import pojos.SongGetParam.SongParamMoreInfo;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SongGetParamValidator {
    String className = getClass().getName();

    public void validate(SongGetParamPojo songGetParamPojo, SoftAssert sa, String pids, String fields) throws JsonProcessingException {
        String status = songGetParamPojo.getStatus();
        sa.assertTrue(Validate.API_STATUS_SUCCESS.equalsIgnoreCase(status), "Expected \"" + Validate.API_STATUS_SUCCESS + "\", but found: \"" + songGetParamPojo.getStatus() + "\"");

        String pid = null;
        String songParamMoreInfo = null;
        String field = null;
        SongParamMoreInfo moreInfo = new SongParamMoreInfo();
        for (Map.Entry<String, SongParamMoreInfo> entry : songGetParamPojo.getData().getSongPid().entrySet()) {
            pid = entry.getKey();
            moreInfo = entry.getValue();
        }
        sa.assertTrue(pids.equalsIgnoreCase(pid), "Expected \"" + pids + "\", but found: \"" + pid + "\"");
        for (Map.Entry<String, Object> entry : moreInfo.getMoreInfo().entrySet()) {
            field = entry.getKey();
            Object fieldValue = entry.getValue();

            switch (field) {
                case "more_info.vcode":
                    sa.assertTrue(Validate.asNum(fieldValue.toString()), className + "." + "validate more_info.vcode failed - ");
                    log.info("LOG more_info.vcode in song get params API is " + fieldValue);
                    break;
                case "more_info.vlink":
                    sa.assertTrue(Validate.asExternalURL(fieldValue.toString()), className + "." + "validate more_info.vlink failed - ");
                    log.info("LOG more_info.vlink in song get params API is " + fieldValue);
                    break;
                case "more_info.shortie":
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> songMoreInfoShorties = (HashMap<String, Object>) fieldValue;

                    String shortieDuration = String.valueOf(songMoreInfoShorties.get("duration"));
                    sa.assertTrue(Validate.asNum(shortieDuration), className + "." + "validate shortie duration failed - ");
                    log.info("LOG shortie duration in song get params API is " + shortieDuration);

                    String shortieIsPrimary = String.valueOf(songMoreInfoShorties.get("is_primary"));
                    sa.assertTrue(Validate.asBoolean(shortieDuration), className + "." + "validate shortie is_primary failed - ");
                    log.info("LOG shortie is_primary in song get params API is " + shortieIsPrimary);

                    String shortieMediaUrl = String.valueOf(songMoreInfoShorties.get("is_primary"));
                    sa.assertTrue(Validate.asCDNURL(shortieMediaUrl), className + "." + "validate shortie media_url failed - ");
                    log.info("LOG shortie media_url in song get params API is " + shortieMediaUrl);

                    break;
                case "more_info.video_available":
                    sa.assertTrue(Validate.asBoolean(fieldValue.toString()), className + "." + "validate more_info.video_available failed - ");
                    log.info("LOG more_info.video_available in song get params API is " + fieldValue);
                    break;
                case "more_info.videos":
                    //TODO
                    break;
            }

        }
        sa.assertTrue(fields.equalsIgnoreCase(field), "Expected \"" + fields + "\", but found: \"" + songParamMoreInfo + "\"");


    }
}


