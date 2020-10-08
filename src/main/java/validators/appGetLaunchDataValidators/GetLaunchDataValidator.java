package validators.appGetLaunchDataValidators;

import entities.*;
import org.testng.asserts.SoftAssert;
import pojos.appGetLaunchData.Ads;
import pojos.appGetLaunchData.AppGetLaunchData;
import pojos.appGetLaunchData.TopSearch;
import pojos.appGetLaunchData.UpdateConfig;
import pojos.getHomePageDataV2.HomePageDataV2;
import validators.AssertionMsg;
import validators.PlaylistMiniValidator;
import validators.Validate;
import validators.genericValidators.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GetLaunchDataValidator {
    final String className = getClass().getName();

    public void validate(AppGetLaunchData obj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asNum(obj.getAppVersion()), AssertionMsg.print(className, methodName, "app_version", String.valueOf(obj.getAppVersion())));

        validateUpdateConfig(obj.getUpdateConfig(), sa);

        //TODO: ab_test check

        //Validate ef
        for(String item : obj.getEf()){
            sa.assertTrue(Validate.asString(item), AssertionMsg.print(className, methodName, "ef", item));
        }

        //Validate ping_server
        sa.assertTrue(Validate.asString(obj.getPingServer()), AssertionMsg.print(className, methodName, "ping_server", obj.getPingServer()));

        //Validate new trending
        Validate.asAssortedEntity(obj.getNewTrending(), sa);

        //Validate top playlists
        Validate.asChartsAndPlaylists(obj.getTopPlaylists(), sa);

        //Validate new albums
        for(AlbumMiniObject album : obj.getNewAlbums()){
            new AlbumMiniValidator().validate(album, sa);
        }

        //Validate top shows
        new TopShowsValidator().validate(obj.getTopShows(), sa);

        //Validate browse & discover
        Validate.asBrowseAndDiscover(obj.getBrowseDiscover(), sa);

        //Validate radio
        Validate.asFeaturedStations(obj.getRadio(), sa);

        //Validate top searches
        for(TopSearch ts : obj.getTopSearches()){
            validateTopSearches(ts, sa);
        }

        //Validate loginwall
        if(Validate.isNonEmptyString(obj.getLoginwall()))
            sa.assertTrue(Validate.asString(obj.getLoginwall()), AssertionMsg.print(className, methodName, "loginwall", obj.getLoginwall()));

        //Validate jiologinwall
        if(Validate.isNonEmptyString(obj.getJiologinwall()))
            sa.assertTrue(Validate.asString(obj.getJiologinwall()), AssertionMsg.print(className, methodName, "jiologinwall", obj.getJiologinwall()));

        //Validate charts
        Validate.asChartsAndPlaylists(obj.getCharts(), sa);

        new UserStateValidator().validate(obj.getUser_state(), sa);

        validateAds(obj.getAds(), sa);

        //Validate mix
        Validate.asMixes(obj.getTagMixes(), sa);

        //Validate artist recos
        Validate.asArtistRecos(obj.getArtistRecos(), sa);

        //Valoidate city modules
//        Validate.asAssortedEntity(obj.getCityMod(), sa);
        //TODO: Validate City Modules

        //Validate promos
//        Validate.asTopicsPromos(obj.getTopicPromos(), sa);
        //TODO: Validate Promos

        //validate modules
//        new ModulesValidator().validate(obj.getModules(), sa);


    }

    void validateAds(Ads ads, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(ads.getCarrier()))
            sa.assertTrue(Validate.asString(ads.getCarrier()), AssertionMsg.print(className, methodName, "ads.carrier", ads.getCarrier()));

        if(Validate.isNonEmptyString(ads.getSegmentIds()))
            sa.assertTrue(Validate.asString(ads.getSegmentIds()), AssertionMsg.print(className, methodName, "ads.segment_ids", ads.getSegmentIds()));

        if(Validate.isNonEmptyString(ads.getGender()))
            sa.assertTrue(Validate.asString(ads.getGender()), AssertionMsg.print(className, methodName, "ads.gender", ads.getGender()));

        if(Validate.isNonEmptyString(ads.getCohort()))
            sa.assertTrue(Validate.asString(ads.getCohort()), AssertionMsg.print(className, methodName, "ads.cohort", ads.getCohort()));


    }

    void validateTopSearches(TopSearch ts, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(ts.getEntityId()))
            sa.assertTrue(Validate.asString(ts.getEntityId()), AssertionMsg.print(className, methodName, "top_searches.entity_id", ts.getEntityId()));

        if(Validate.isNonEmptyString(ts.getImage()))
            sa.assertTrue(Validate.asCDNURL(ts.getImage()), AssertionMsg.print(className, methodName, "top_searches.image", ts.getImage()));

        if(Validate.isNonEmptyString(ts.getEntityName()))
            sa.assertTrue(Validate.asString(ts.getEntityName()), AssertionMsg.print(className, methodName, "top_searches.entity_name", ts.getEntityName()));

        if(Validate.isNonEmptyString(ts.getEntityType()))
            sa.assertTrue(Validate.asString(ts.getEntityType()), AssertionMsg.print(className, methodName, "top_searches.entity_type", ts.getEntityType()));



    }


    void validateUpdateConfig(UpdateConfig uc, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(uc.getUrl()))
            sa.assertTrue(Validate.asUpdateUrl(uc.getUrl()), AssertionMsg.print(className, methodName, "update_config.url", uc.getUrl()));

        sa.assertTrue(Validate.asNum(uc.getFrequency()), AssertionMsg.print(className, methodName, "update_config.frequency", String.valueOf(uc.getFrequency())));

    }


}
