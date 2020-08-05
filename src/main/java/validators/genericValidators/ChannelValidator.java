package validators.genericValidators;

import entities.Channel;
import entities.ChannelMoreInfo;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;

public class ChannelValidator extends EntityValidator {
    final String className = SongValidator.class.getName();
    public void validate(Channel chObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(chObj, sa);


    }

    void validateMoreInfo(Channel chObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        ChannelMoreInfo moreInfo = chObj.getMore_info();
        sa.assertTrue(Validate.asString(moreInfo.getBadge()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.badge", moreInfo.getBadge(), chObj.getId()));

        sa.assertTrue(Validate.asString(moreInfo.getSubType()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.sub_type", moreInfo.getSubType(), chObj.getId()));

        sa.assertTrue(Validate.asNum(moreInfo.getAvailable()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.available", moreInfo.getAvailable(), chObj.getId()));

        sa.assertTrue(Validate.asNum(moreInfo.getIsFeatured()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.is_featured", moreInfo.getIsFeatured(), chObj.getId()));

        sa.assertTrue(Validate.asString(moreInfo.getVideoUrl()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.video_url", moreInfo.getVideoUrl(), chObj.getId()));

        sa.assertTrue(Validate.asString(moreInfo.getVideoThumbnail()), AssertionMsg.print(className, methodName, chObj.getType(), "channel.more_info.video_thumbnail", moreInfo.getVideoThumbnail(), chObj.getId()));

    }

    void validateTags(Channel chObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        //TODO: validation of tags
    }

}
