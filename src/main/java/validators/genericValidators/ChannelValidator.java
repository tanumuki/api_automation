package validators.genericValidators;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
public class ChannelValidator extends EntityValidator {
    final String className = SongValidator.class.getName();
    public void validate(Channel chObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(chObj, sa);

        if(Validate.isNonEmptyString(chObj.getDescription()))
            sa.assertTrue(Validate.asString(chObj.getDescription()), AssertionMsg.print(className, methodName, "channel.description", chObj.getDescription()));

        sa.assertTrue(Validate.asBoolean(chObj.isMini_obj()), AssertionMsg.print(className, methodName, "channel.mini_obj", String.valueOf(chObj.isMini_obj())));

        if(chObj.getChannel_language() != null){
            for(String lang : chObj.getChannel_language()){
                sa.assertTrue(Validate.asMusicLanguages(lang), AssertionMsg.print(className, methodName, "channel.channel_languages", lang));
            }
        }




        validateArtists(chObj.getArtists(), sa);
        validateArtists(chObj.getPrimary_artists(), sa);
        validateArtists(chObj.getFeatured_artists(), sa);




        validateMoreInfo(chObj, sa);
    }

    void validateArtists(List<String> artists, SoftAssert sa ) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(artists != null && artists.size() > 0){
            for(String artist : artists){
                if(Validate.isNonEmptyString(artist))
                    sa.assertTrue(Validate.asString(artist), AssertionMsg.print(className, methodName, "channel.artist", artist));
            }
        }
    }

    void validateMoreInfo(Channel chObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        Tags tags = null;
        ArrayList emptyTags = new ArrayList<>();
        Object temp = null;
        if (chObj.getMore_info() instanceof List) {
            sa.assertTrue(((List<?>) chObj.getMore_info()).size() == 0, " Channel more_info of type list has contents");
        } else { //if(chObj.getMore_info() instanceof ChannelMoreInfo){
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

            ChannelMoreInfo moreInfo = mapper.convertValue(chObj.getMore_info(), ChannelMoreInfo.class);

            if (Validate.isNonEmptyString(moreInfo.getBadge()))
                sa.assertTrue(Validate.asString(moreInfo.getBadge()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.badge", moreInfo.getBadge(), chObj.getId()));

            if (Validate.isNonEmptyString(moreInfo.getSubType())) {
                sa.assertTrue(Validate.asChannelSubtype(moreInfo.getSubType()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.sub_type", moreInfo.getSubType(), chObj.getId()));
            }

            if (Validate.isNonEmptyString(moreInfo.getAvailable()))
                sa.assertTrue(Validate.asNum(moreInfo.getAvailable()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.available", moreInfo.getAvailable(), chObj.getId()));

            if (Validate.isNonEmptyString(moreInfo.getIsFeatured()))
                sa.assertTrue(Validate.asNum(moreInfo.getIsFeatured()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.is_featured", moreInfo.getIsFeatured(), chObj.getId()));

            if (Validate.isNonEmptyString(moreInfo.getVideoUrl()))
                sa.assertTrue(Validate.asCDNURL(moreInfo.getVideoUrl()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.video_url", moreInfo.getVideoUrl(), chObj.getId()));

            if (Validate.isNonEmptyString(moreInfo.getVideoThumbnail()))
                sa.assertTrue(Validate.asCDNURL(moreInfo.getVideoThumbnail()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.video_thumbnail", moreInfo.getVideoThumbnail(), chObj.getId()));

            if (moreInfo.getLanguage() != null) {
                for (String lang : moreInfo.getLanguage()) {
                    sa.assertTrue(Validate.asMusicLanguages(lang), AssertionMsg.print(className, methodName, "channel.more_info.languages", lang));
                }
            }

            temp = moreInfo.getTags();
            if (temp instanceof ArrayList) {
                emptyTags = (ArrayList) (moreInfo).getTags();
                sa.assertTrue(emptyTags.isEmpty());
                log.info("The tags are empty for this channel "+chObj.getId());
            } else if (temp instanceof LinkedHashMap) {
                tags = mapper.convertValue(temp, Tags.class);
                if (tags != null)
                    new TagsValidator().validate(tags, sa, "channel", chObj.getId());
                    log.info("Validation done for tags for the channel id "+chObj.getId());
            }


        }
    }


}
