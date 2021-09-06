package validators.VideoValidator;

import entities.SongMoreInfo;
import org.testng.asserts.SoftAssert;
import pojos.Videos.ThirdPartyVideo;
import validators.AssertionMsg;
import validators.Validate;

public class ThirdPartyVideoValidator {

    final String className = getClass().getName();

    public void validate(SongMoreInfo smi, SoftAssert sa){
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        for (ThirdPartyVideo videoObject : smi.getThird_party_videos()) {

            if(Validate.isNonEmptyString(videoObject.getUserUrl())) {
                String url = videoObject.getUserUrl();
                sa.assertTrue(Validate.asExternalURL(url), AssertionMsg.print(className, methodName,
                        "more_info.third_party_videos.user_url", url));
            }

            if(Validate.isNonEmptyString(videoObject.getMediaUrl())) {
                String url = videoObject.getMediaUrl();
                sa.assertTrue(Validate.asExternalURL(url), AssertionMsg.print(className, methodName,
                        "more_info.third_party_videos.media_url", url));
            }

            if(Validate.isNonEmptyString(videoObject.getUserImage())) {
                String url = videoObject.getUserImage();
                sa.assertTrue(Validate.asExternalURL(url), AssertionMsg.print(className, methodName,
                        "more_info.third_party_videos.user_image", url));
            }

            if(Validate.isNonEmptyString(videoObject.getImage())) {
                String url = videoObject.getImage();
                sa.assertTrue(Validate.asCDNURL(url), AssertionMsg.print(className, methodName,
                        "more_info.third_party_videos.image", url));
            }

            if(Validate.isNonEmptyString(videoObject.getUserName())) {
                String name = videoObject.getUserName();
                sa.assertTrue(Validate.asString(name), AssertionMsg.print(className, methodName,
                        "more_info.third_party_videos.user_name", name));
            }

            String language = videoObject.getLanguage();
            sa.assertTrue(Validate.asMusicLanguages(language), AssertionMsg.print(className, methodName,
                       "more_info.third_party_videos.language", language));

            String partnerID = videoObject.getPartnerId();
            sa.assertTrue(Validate.asThirdPartyVideoPartnerID(partnerID), AssertionMsg.print(className, methodName,
                        "more_info.third_party_videos.partner_id", partnerID));

            String videoID = videoObject.getVideoId();
            sa.assertTrue(Validate.asNum(videoID), AssertionMsg.print(className, methodName,
                    "more_info.third_party_videos.video_id", videoID));

        }

    }
}
