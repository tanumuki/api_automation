package validators.showGetHome;

import entities.*;
import org.testng.asserts.SoftAssert;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.ArtistMapValidator;
import validators.genericValidators.EditorsNoteValidator;
import validators.genericValidators.EntityValidator;
import validators.genericValidators.SongValidator;

public class ShowDetailsValidator extends EntityValidator {
    final String className = getClass().getName();
    public void validate(ShowGetHome showHome, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        System.out.println("className: " + className);
        ShowDetails showDetails = showHome.getShowDetails();
        super.validate(showDetails, sa, showDetails.getId(), "show");
        validateMoreInfo(showDetails, sa);
        
    }

    public void validate(ShowDetails showDetails, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        System.out.println("className: " + className);
        super.validate(showDetails, sa, showDetails.getId(), "show");
        validateMoreInfo(showDetails, sa);
    }


    public void validateMoreInfo(ShowDetails showDetails, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        ShowMoreInfo mi = showDetails.getMoreInfo();

        if(mi.getLatestSeasonSequence() != null)
            sa.assertTrue(Validate.asNum(mi.getLatestSeasonSequence()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.latest_season_sequence", mi.getLatestSeasonSequence()));

        if(mi.getPartnerId() != null)
            sa.assertTrue(Validate.asNum(mi.getPartnerId()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.partner_id", mi.getPartnerId()));

        if(mi.getLatestSeasonId() != null)
            sa.assertTrue(Validate.asNum(mi.getLatestSeasonId()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.latest_season_id", mi.getLabelId()));

        if(mi.getCountryOfOrigin() != null)
            sa.assertTrue(Validate.asString(mi.getCountryOfOrigin()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.country_of_origin", mi.getCountryOfOrigin()));

        if(mi.getPartnerName() != null)
            sa.assertTrue(Validate.asString(mi.getPartnerName()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.partner_name", mi.getPartnerName()));

        if(mi.getLabelId() != null)
            sa.assertTrue(Validate.asNum(mi.getLabelId()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.label_id", mi.getLabelId()));

        if(mi.getDescription() != null)
            sa.assertTrue(Validate.asString(mi.getDescription()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.description", mi.getDescription()));

        // TODO: tags

        if(mi.getDisableAds() != null)
            sa.assertTrue(Validate.asNum(mi.getDisableAds()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.disable_ads", mi.getDisableAds()));

        if(mi.getReleaseDate() != null)
            sa.assertTrue(Validate.asDate(mi.getReleaseDate()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.release_date", mi.getReleaseDate()));

        if(mi.getFollowersCount() != null)
            sa.assertTrue(Validate.asNum(mi.getFollowersCount()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.followers_count", mi.getFollowersCount()));

        if(mi.getParentalAdvisory() != null)
            sa.assertTrue(Validate.asNum(mi.getParentalAdvisory()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.parental_advisory", mi.getParentalAdvisory()));

        if(mi.getIsDisabled() != null)
            sa.assertTrue(Validate.asNum(mi.getIsDisabled()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.is_disabled", mi.getIsDisabled()));

        if(mi.getCopyrightText() != null)
            sa.assertTrue(Validate.asString(mi.getCopyrightText()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.copyright_text", mi.getCopyrightText()));

        if(mi.getHeaderLogo() != null)
            sa.assertTrue(Validate.asUrl(mi.getHeaderLogo()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.header_logo", mi.getHeaderLogo()));

        if(mi.getHeaderColor() != null)
            sa.assertTrue(Validate.asString(mi.getHeaderColor()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.header_color", mi.getHeaderColor()));

        if(mi.getHeaderImage() != null)
            sa.assertTrue(Validate.asUrl(mi.getHeaderImage()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.header_image", mi.getHeaderImage()));

        if(mi.getLabel() != null)
            sa.assertTrue(Validate.asString(mi.getLabel()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.label", mi.getLabel()));

        if(mi.getSortOrder() != null)
            sa.assertTrue(Validate.asString(mi.getSortOrder()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.sort_order", mi.getSortOrder()));

        if(mi.getSquareImage() != null)
            sa.assertTrue(Validate.asUrl(mi.getSquareImage()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.square_image", mi.getSquareImage()));

        if(mi.getSeasonNumber() != null)
            sa.assertTrue(Validate.asNum(mi.getSeasonNumber()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.season_number", mi.getSeasonNumber()));

        if(mi.getTotalEpisodes() != null)
            sa.assertTrue(Validate.asNum(mi.getTotalEpisodes()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.total_episodes", mi.getTotalEpisodes()));

        if(mi.getIsFollowed() != null)
            sa.assertTrue(Validate.asBoolean(mi.getIsFollowed()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.is_followed", mi.getIsFollowed()));

        if(mi.getFanCount() != null)
            sa.assertTrue(Validate.asNum(mi.getFanCount()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.fan_count", mi.getFanCount()));

        ArtistMap artistMap = mi.getArtistMap();

        new ArtistMapValidator().validate(artistMap, sa, "show", showDetails.getId());

        EditorsNote en = mi.getEditorsNote();

        if(en != null)
            new EditorsNoteValidator().validate(en, sa, "show", showDetails.getId());

        if(mi.getYear() != null)
            sa.assertTrue(Validate.asNum(mi.getYear()), AssertionMsg.print(className, methodName, "show", "getTopShows.more_info.year", mi.getYear()));

        if(mi.getBadge() != null)
            sa.assertTrue(Validate.asString(mi.getBadge()), AssertionMsg.print(className, methodName, "show", "getTopShows.more_info.badge", mi.getBadge()));
    }

}
