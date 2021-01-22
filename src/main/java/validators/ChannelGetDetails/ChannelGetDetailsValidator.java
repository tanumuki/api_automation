package validators.ChannelGetDetails;

import org.testng.asserts.SoftAssert;
import pojos.channelGetDetailsPojos.ChannelGetDetails;
import pojos.channelGetDetailsPojos.ChannelGetDetailsMoreInfo;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.EditorsNoteValidator;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.TagsValidator;

public class ChannelGetDetailsValidator extends EntityValidator {
    final String className = getClass().getName();
    String channelId = null;
    public void validate(ChannelGetDetails channelDetails, SoftAssert sa) {

        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(channelDetails, sa);
        channelId = channelDetails.getId();
        validateMoreInfo(channelDetails.getMoreInfo(), sa);
    }

    public void validateMoreInfo(ChannelGetDetailsMoreInfo mi, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        new EditorsNoteValidator().validate(mi.getEditorsNote(), sa, "channel", channelId);

        new TagsValidator().validate(mi.getTags(), sa, "channel", channelId);

        sa.assertTrue(Validate.asBoolean(mi.getIsFollowed()), AssertionMsg.print(className, methodName, "channel", "channel.more_info.is_followed", mi.getIsFollowed(), channelId));

        sa.assertTrue(Validate.asNum(mi.getFollowerCount()), AssertionMsg.print(className, methodName, "channel", "channel.more_info.follower_count", mi.getFollowerCount(), channelId));

        sa.assertTrue(Validate.asNum(mi.getCanStartRadio()), AssertionMsg.print(className, methodName, "channel", "channel.more_info.can_start_radio", mi.getCanStartRadio(), channelId));

        sa.assertTrue(Validate.asChannelSubtype(mi.getSubType()), AssertionMsg.print(className, methodName, "channel", "channel.more_info.sub_type", mi.getSubType(), channelId));

        sa.assertTrue(Validate.asNum(mi.getAvailable()), AssertionMsg.print(className, methodName, "channel", "channel.more_info.available", mi.getAvailable(), channelId));


    }

}
