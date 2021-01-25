/**
 *
 */
package validators.genericValidators;

import entities.Triller;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

import java.util.List;

/**
 * @author ashwinsriv
 *
 */
@Slf4j
public class TrillerValidator {
    final String className = TrillerValidator.class.getName();

    public void validate(Triller trillerObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

//        App Store URL should always be present, so no null checks required
        sa.assertTrue(Validate.asTrillerAppStoreURL(trillerObj.getUserURL()), AssertionMsg.print(className, methodName,
                "triller.user_url", trillerObj.getUserURL()));

//        Media URL should always be present, so no null checks required
        sa.assertTrue(Validate.asTrillerMediaURL(trillerObj.getMedia_url()), AssertionMsg.print(className, methodName,
                "triller.media_url", trillerObj.getMedia_url()));

        if (Validate.isNonEmptyString(trillerObj.getUser_image())) {
            sa.assertTrue(Validate.asString(trillerObj.getUser_image()), AssertionMsg.print(className, methodName,
                    "triller.user_image", trillerObj.getUser_image()));
        }

//        image should always be present, so no null checks required
        sa.assertTrue(Validate.asCDNURL(trillerObj.getImage()), AssertionMsg.print(className, methodName,
                "triller.image", trillerObj.getImage()));

//        triller ID should always be present, so no null checks required
        sa.assertTrue(Validate.asNum(trillerObj.getTriller_id()), AssertionMsg.print(className, methodName,
                "triller.triller_id", trillerObj.getTriller_id()));

//        username should always be present, so no null checks required
        sa.assertTrue(Validate.asString(trillerObj.getUser_name()), AssertionMsg.print(className, methodName,
                "triller.user_name", trillerObj.getUser_name()));

//        language should always be present, so no null checks required
        sa.assertTrue(Validate.asMusicLanguage(trillerObj.getLanguage()), AssertionMsg.print(className, methodName,
                "triller.language", trillerObj.getLanguage()));

        // pid should be there
        if(Validate.isNonEmptyString(trillerObj.getPid())) {
            String[] pids = trillerObj.getPid().split(",");
            for (String pid : pids) {
                sa.assertTrue(Validate.asId(pid), AssertionMsg.print(className, methodName, "triller.pid", pid));
            }
        }


        //artist ids
        if(Validate.isNonEmptyString(trillerObj.getArtist_id())){
            String[] artists = trillerObj.getArtist_id().split(",");
            for(String artist : artists) {
                sa.assertTrue(Validate.asNum(artist), AssertionMsg.print(className, methodName, "triller.artist_id", artist));
            }
        }

    }
}
