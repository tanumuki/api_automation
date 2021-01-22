package validators.showGetHome;

import entities.*;
import org.testng.asserts.SoftAssert;
import pojos.SearchGetEntityResults.ArtistResultObj;
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
        validateMoreInfo(showDetails.getMoreInfo(), sa, showDetails.getId());


    }

    public void validate(ShowDetails sd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        super.validate(sd, sa, sd.getId(), "show");
        if(sd.getMoreInfo() != null)
            validateMoreInfo(sd.getMoreInfo(), sa, sd.getId());
        else
            sa.fail(className+"."+ methodName+"-more_info is null");

        if(Validate.isNonEmptyString(sd.getDescription()))
            sa.assertTrue(Validate.asString(sd.getDescription()), AssertionMsg.print(className, methodName, "show_details.description", sd.getDescription()));

        //Validate mini_obj
        if(sd.getMini_obj() != null){
            sa.assertTrue(Validate.asBoolean(sd.getMini_obj()), AssertionMsg.print(className, methodName, "show_details.mini_obj", String.valueOf(sd.getMini_obj())));
        }else
            sa.fail(className+"."+ methodName+"-mini_obj is null");

        if(Validate.isNonEmptyString(sd.getImageFileUrl())){
            sa.assertTrue(Validate.asCDNURL(sd.getImageFileUrl()), AssertionMsg.print(className, methodName, "show_details.image_file_url", sd.getImageFileUrl()));
        }else
            sa.fail(className+"."+ methodName+"-image_file_url is null/empty");

        if(Validate.isNonEmptyString(sd.getPartner_name())){
            sa.assertTrue(Validate.asString(sd.getPartner_name()), AssertionMsg.print(className, methodName, "show_details.partner_name", sd.getImageFileUrl()));
        }else
            sa.fail(className+"."+ methodName+"-partner_name is null/empty");

        if(Validate.isNonEmptyString(sd.getDisable_ads())){
            sa.assertTrue(Validate.asBoolean(sd.getDisable_ads()), AssertionMsg.print(className, methodName, "show_details.disable_ads", sd.getDisable_ads()));
        }else
            sa.fail(className+"."+ methodName+"-disable_ads is null/empty");

        if(Validate.isNonEmptyString(sd.getBackground_color())){
            sa.assertTrue(Validate.asHexColour(sd.getBackground_color()), AssertionMsg.print(className, methodName, "show_details.background_color", sd.getBackground_color()));
        }else
            sa.fail(className+"."+ methodName+"-background_color is null/empty");

        if(Validate.isNonEmptyString(sd.getLabel_name())){
            sa.assertTrue(Validate.asString(sd.getLabel_name()), AssertionMsg.print(className, methodName, "show_details.label_name", sd.getLabel_name()));
        }else
            sa.fail(className+"."+ methodName+"-label_name is null/empty");

        if(Validate.isNonEmptyString(sd.getSong_info())){
            sa.assertTrue(Validate.asString(sd.getSong_info()), AssertionMsg.print(className, methodName, "show_details.song_info", sd.getSong_info()));
        }else
            sa.fail(className+"."+ methodName+"-song_info is null/empty");

        if(sd.getLatest_season_sequence() != null){
            sa.assertTrue(Validate.asNum(sd.getLatest_season_sequence()), AssertionMsg.print(className, methodName, "show_details.latest_season_sequence", String.valueOf(sd.getLatest_season_sequence())));
        }else
            sa.fail(className+"."+ methodName+"-season_sequence is null/empty");

        if(Validate.isNonEmptyString(sd.getSquare_image_url())){
            sa.assertTrue(Validate.asCDNURL(sd.getSquare_image_url()), AssertionMsg.print(className, methodName, "show_details.square_image_url", sd.getSquare_image_url()));
        }else
            sa.fail(className+"."+ methodName+"-square_image_url is null/empty");
    }

    void validateArtistObjs(ShowDetails sd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(sd.getArtists() != null) {
            for(ArtistResultObj ao : sd.getArtists()){
                validateArtistObj(ao, sa);
            }
        }else
            sa.fail(className+"."+ methodName+"-show_details.artists is null/empty");
    }

    void validateArtistObj(ArtistResultObj ao, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(ao.getArtists_id())){
            sa.assertTrue(Validate.asId(ao.getArtists_id()), AssertionMsg.print(className, methodName, "artists_id", ao.getArtists_id()));
        }else
            sa.fail(className+"."+ methodName+"-artist_id is null/empty");

        if(Validate.isNonEmptyString(ao.getArtists_name())){
            sa.assertTrue(Validate.asId(ao.getArtists_name()), AssertionMsg.print(className, methodName, "artists_name", ao.getArtists_name()));
        }else
            sa.fail(className+"."+ methodName+"-artist_name is null/empty");

        if(Validate.isNonEmptyString(ao.getArtists_sequence())){
            sa.assertTrue(Validate.asId(ao.getArtists_sequence()), AssertionMsg.print(className, methodName, "artists_sequence", ao.getArtists_sequence()));
        }else
            sa.fail(className+"."+ methodName+"-artist_sequence is null/empty");

        if(Validate.isNonEmptyString(ao.getArtists_role())){
            sa.assertTrue(Validate.asId(ao.getArtists_role()), AssertionMsg.print(className, methodName, "artists_role", ao.getArtists_role()));
        }else
            sa.fail(className+"."+ methodName+"-artist_role is null/empty");
    }

    public void validateMoreInfo(ShowMoreInfo mi, SoftAssert sa, String id) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(mi.getLatestSeasonSequence() != null)
            sa.assertTrue(Validate.asNum(mi.getLatestSeasonSequence()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.latest_season_sequence", mi.getLatestSeasonSequence()));
        else
            sa.fail(className+"."+ methodName+"-latest_season_sequence is null/empty");

        if(mi.getPartnerId() != null)
            sa.assertTrue(Validate.asNum(mi.getPartnerId()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.partner_id", mi.getPartnerId()));
        else
            sa.fail(className+"."+ methodName+"-partner_id is null/empty");

        if(mi.getLatestSeasonId() != null)
            sa.assertTrue(Validate.asNum(mi.getLatestSeasonId()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.latest_season_id", mi.getLabelId()));
        else
            sa.fail(className+"."+ methodName+"-latest_season_id is null/empty");

        if(mi.getCountryOfOrigin() != null)
            sa.assertTrue(Validate.asString(mi.getCountryOfOrigin()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.country_of_origin", mi.getCountryOfOrigin()));
        else
            sa.fail(className+"."+ methodName+"-country_of_origin is null/empty");

        if(mi.getPartnerName() != null)
            sa.assertTrue(Validate.asString(mi.getPartnerName()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.partner_name", mi.getPartnerName()));
        else
            sa.fail(className+"."+ methodName+"-partner_name is null/empty");

        if(mi.getLabelId() != null)
            sa.assertTrue(Validate.asNum(mi.getLabelId()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.label_id", mi.getLabelId()));
        else
            sa.fail(className+"."+ methodName+"-label_id is null/empty");

        if(mi.getDescription() != null)
            sa.assertTrue(Validate.asString(mi.getDescription()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.description", mi.getDescription()));
        else
            sa.fail(className+"."+ methodName+"-description is null/empty");
        // TODO: tags

        if(mi.getDisableAds() != null)
            sa.assertTrue(Validate.asNum(mi.getDisableAds()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.disable_ads", mi.getDisableAds()));
        else
            sa.fail(className+"."+ methodName+"-disable_ads is null/empty");

        if(mi.getReleaseDate() != null)
            sa.assertTrue(Validate.asDate(mi.getReleaseDate()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.release_date", mi.getReleaseDate()));
        else
            sa.fail(className+"."+ methodName+"-release_date is null/empty");

        if(mi.getFollowersCount() != null)
            sa.assertTrue(Validate.asNum(mi.getFollowersCount()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.followers_count", mi.getFollowersCount()));
        else
            sa.fail(className+"."+ methodName+"-followers_count is null/empty");

        if(mi.getParentalAdvisory() != null)
            sa.assertTrue(Validate.asNum(mi.getParentalAdvisory()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.parental_advisory", mi.getParentalAdvisory()));
        else
            sa.fail(className+"."+ methodName+"-parental_advisory is null/empty");

        if(mi.getIsDisabled() != null)
            sa.assertTrue(Validate.asNum(mi.getIsDisabled()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.is_disabled", mi.getIsDisabled()));
        else
            sa.fail(className+"."+ methodName+"-is_disabled is null/empty");

        if(Validate.isNonEmptyString(mi.getCopyrightText()))
            sa.assertTrue(Validate.asString(mi.getCopyrightText()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.copyright_text", mi.getCopyrightText()));
        else
            sa.fail(className+"."+ methodName+"-copyright_text is null/empty");

        if(Validate.isNonEmptyString(mi.getHeaderLogo()))
            sa.assertTrue(Validate.asCDNURL(mi.getHeaderLogo()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.header_logo", mi.getHeaderLogo()));
        else
            sa.fail(className+"."+ methodName+"-header_logo is null/empty");

        if(Validate.isNonEmptyString(mi.getHeaderColor()))
            sa.assertTrue(Validate.asHexColour(mi.getHeaderColor()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.header_color", mi.getHeaderColor()));
        else
            sa.fail(className+"."+ methodName+"-header_color is null/empty");

        if(Validate.isNonEmptyString(mi.getHeaderImage()))
            sa.assertTrue(Validate.asCDNURL(mi.getHeaderImage()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.header_image", mi.getHeaderImage()));
        else
            sa.fail(className+"."+ methodName+"-header_image is null/empty");

        if(Validate.isNonEmptyString(mi.getLabel()))
            sa.assertTrue(Validate.asString(mi.getLabel()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.label", mi.getLabel()));
        else
            sa.fail(className+"."+ methodName+"-label is null/empty");

        if(Validate.isNonEmptyString(mi.getSortOrder()))
            sa.assertTrue(Validate.asString(mi.getSortOrder()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.sort_order", mi.getSortOrder()));
        else
            sa.fail(className+"."+ methodName+"-sort_order is null/empty");

        if(Validate.isNonEmptyString(mi.getSquareImage()))
            sa.assertTrue(Validate.asCDNURL(mi.getSquareImage()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.square_image", mi.getSquareImage()));
        else
            sa.fail(className+"."+ methodName+"-square_image is null/empty");

        if(Validate.isNonEmptyString(mi.getSeasonNumber()))
            sa.assertTrue(Validate.asNum(mi.getSeasonNumber()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.season_number", mi.getSeasonNumber()));
        else
            sa.fail(className+"."+ methodName+"-season_number is null/empty");

        if(Validate.isNonEmptyString(mi.getTotalEpisodes()))
            sa.assertTrue(Validate.asNum(mi.getTotalEpisodes()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.total_episodes", mi.getTotalEpisodes()));
        else
            sa.fail(className+"."+ methodName+"-total_episodes is null/empty");

        if(Validate.isNonEmptyString(mi.getIsFollowed()))
            sa.assertTrue(Validate.asBoolean(mi.getIsFollowed()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.is_followed", mi.getIsFollowed()));
        else
            sa.fail(className+"."+ methodName+"-is_followed is null/empty");

        if(Validate.isNonEmptyString(mi.getFanCount()))
            sa.assertTrue(Validate.asNum(mi.getFanCount()), AssertionMsg.print(className, methodName, "show", "show_details.more_info.fan_count", mi.getFanCount()));
        else
            sa.fail(className+"."+ methodName+"-fan_count is null/empty");

        ArtistMap artistMap = mi.getArtistMap();

        new ArtistMapValidator().validate(artistMap, sa, "show", id);

        EditorsNote en = mi.getEditorsNote();

        new EditorsNoteValidator().validate(en, sa, "show", id);

        if(Validate.isNonEmptyString(mi.getYear()))
            sa.assertTrue(Validate.asNum(mi.getYear()), AssertionMsg.print(className, methodName, "show", "getTopShows.more_info.year", mi.getYear()));
        else
            sa.fail(className+"."+ methodName+"-year is null/empty");

        if(Validate.isNonEmptyString(mi.getBadge()))
            sa.assertTrue(Validate.asString(mi.getBadge()), AssertionMsg.print(className, methodName, "show", "getTopShows.more_info.badge", mi.getBadge()));
        else
            sa.fail(className+"."+ methodName+"-badge is null/empty");
    }



}
