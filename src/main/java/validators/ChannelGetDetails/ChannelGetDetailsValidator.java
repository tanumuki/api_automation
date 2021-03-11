package validators.ChannelGetDetails;

import org.testng.asserts.SoftAssert;
import pojos.channelGetDetailsPojos.ChannelGetDetails;
import pojos.channelGetDetailsPojos.ChannelGetDetailsModules;
import pojos.channelGetDetailsPojos.ChannelGetDetailsMoreInfo;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.*;

public class ChannelGetDetailsValidator extends EntityValidator {
    final String className = getClass().getName();
    String channelId = null;
    public void validate(ChannelGetDetails channelDetails, SoftAssert sa) {

        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(channelDetails, sa);
        channelId = channelDetails.getId();
        validateMoreInfo(channelDetails.getMoreInfo(), sa);
        validateModules(channelDetails.getModules(), sa);
        if (channelDetails.getWhats_hot()!=null) {
            sa.assertTrue(Validate.asEmptyArray(channelDetails.getWhats_hot()));
        }
    }

    void validateModules(ChannelGetDetailsModules modules, SoftAssert sa) {
        if(modules.getEditorsNote() != null)
            ModulesDataValidator.validate(modules.getEditorsNote(), sa);

        if(modules.getQuickStations() != null)
            ModulesDataValidator.validate(modules.getQuickStations(), sa);

        if(modules.getTopPlaylists() != null)
            ModulesDataValidator.validate(modules.getTopPlaylists(), sa);

        if(modules.getTopSongs() != null)
            ModulesDataValidator.validate(modules.getTopSongs(), sa);
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
