package validators.AppGetLaunchData;

import entities.*;
import org.testng.asserts.SoftAssert;
import pojos.appGetLaunchData.Ads;
import pojos.appGetLaunchData.AppGetLaunchData;
import pojos.appGetLaunchData.TopSearch;
import pojos.appGetLaunchData.UpdateConfig;
import pojos.getHomePageDataV2.HomePageDataModules;
import validators.AssertionMsg;
import validators.HomepageDataV2.HomePageDataModuleValidator;
import validators.Validate;
import validators.genericValidators.*;

import java.util.LinkedHashMap;
import java.util.List;

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


        //Validate ab_test

        //Validate suggests

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

        //TODO: Validate global_config



        //Validate loginwall
        if(Validate.isNonEmptyString(obj.getLoginwall()))
            sa.assertTrue(Validate.asBoolean(obj.getLoginwall()), AssertionMsg.print(className, methodName, "loginwall", obj.getLoginwall()));

        //Validate jiologinwall
        if(Validate.isNonEmptyString(obj.getJiologinwall()))
            sa.assertTrue(Validate.asBoolean(obj.getJiologinwall()), AssertionMsg.print(className, methodName, "jiologinwall", obj.getJiologinwall()));

        //Validate charts
        Validate.asChartsAndPlaylists(obj.getCharts(), sa);

        new UserStateValidator().validate(obj.getUser_state(), sa);

        validateAds(obj.getAds(), sa);

        //Validate mix
        Validate.asMixes(obj.getTagMixes(), sa);

        //Validate artist recos
        Validate.asArtistRecos(obj.getArtistRecos(), sa);

        //Validate City Modules
        //validateCityModules(obj.getCityMod(), sa);


        //TODO: Validate Promos

        validateModules(obj.getModules(), sa);

        sa.assertTrue(Validate.asString(obj.getGreeting()), AssertionMsg.print(className, methodName, "greeting", obj.getGreeting()));

        sa.assertTrue(Validate.asBoolean(obj.getLastPage()), AssertionMsg.print(className, methodName, "last_page", String.valueOf(obj.getLastPage())));

    }

    void validateModules(HomePageDataModules modules, SoftAssert sa) {
        new HomePageDataModuleValidator().validate(modules, sa);
    }


    public void validateAds(Ads ads, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        System.out.println("=======Validate Ads=========");
        System.out.println("ads null? " + ads == null);
        if(ads != null) {
            System.out.println("----Not Null----");
            if(Validate.isNonEmptyString(ads.getCarrier())){
                sa.assertTrue(Validate.asString(ads.getCarrier()), AssertionMsg.print(className, methodName, "ads.carrier", ads.getCarrier()));
                System.out.println("carrier: " + ads.getCarrier());
            }


            if(Validate.isNonEmptyString(ads.getSegmentIds()))
                sa.assertTrue(Validate.asString(ads.getSegmentIds()), AssertionMsg.print(className, methodName, "ads.segment_ids", ads.getSegmentIds()));

            System.out.println("gender: " + ads.getGender());
            if(Validate.isNonEmptyString(ads.getGender())){
                sa.assertTrue(Validate.asString(ads.getGender()), AssertionMsg.print(className, methodName, "ads.gender", ads.getGender()));
                System.out.println("gender: " + ads.getGender());
            }


            if(Validate.isNonEmptyString(ads.getCohort())) {
                sa.assertTrue(Validate.asString(ads.getCohort()), AssertionMsg.print(className, methodName, "ads.cohort", ads.getCohort()));
                System.out.println("cohort: " + ads.getCohort());
            }


        }

    }

    public void validateTopSearches(TopSearch ts, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(ts.getEntityId()))
            sa.assertTrue(Validate.asString(ts.getEntityId()), AssertionMsg.print(className, methodName, "top_searches.entity_id", ts.getEntityId()));

        if(Validate.isNonEmptyString(ts.getEntityName()))
            sa.assertTrue(Validate.asString(ts.getEntityName()), AssertionMsg.print(className, methodName, "top_searches.entity_name", ts.getEntityName()));

        if(Validate.isNonEmptyString(ts.getEntityType()))
            sa.assertTrue(Validate.asEntityType(ts.getEntityType()), AssertionMsg.print(className, methodName, "top_searches.entity_type", ts.getEntityType()));

//        ID must be present. So no null checks
        sa.assertTrue(Validate.asNum(ts.getId()), AssertionMsg.print(className, methodName, "top_searches.id", ts.getId()));

//        title must be present. So no null checks
        sa.assertTrue(Validate.asString(ts.getTitle()), AssertionMsg.print(className, methodName, "top_searches.title", ts.getTitle()));

//        type must be present. So no null checks
        sa.assertTrue(Validate.asEntityType(ts.getType()), AssertionMsg.print(className, methodName, "top_searches.type", ts.getType()));

//        image must be present. So no null checks
        sa.assertTrue(Validate.asCDNURL(ts.getImage()), AssertionMsg.print(className, methodName, "top_searches.image", ts.getImage()));

        if(Validate.isNonEmptyString(ts.getExplicit_content()))
            sa.assertTrue(Validate.asNum(ts.getExplicit_content()), AssertionMsg.print(className, methodName, "top_searches.explicit_content", ts.getExplicit_content()));

        if(Validate.isNonEmptyString(ts.getMini_obj()))
            sa.assertTrue(Validate.asBoolean(ts.getMini_obj()), AssertionMsg.print(className, methodName, "top_searches.mini_obj", ts.getMini_obj()));


    }


    void validateUpdateConfig(UpdateConfig uc, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(uc.getUrl()))
            sa.assertTrue(Validate.asUpdateUrl(uc.getUrl()), AssertionMsg.print(className, methodName, "update_config.url", uc.getUrl()));

        sa.assertTrue(Validate.asNum(uc.getFrequency()), AssertionMsg.print(className, methodName, "update_config.frequency", String.valueOf(uc.getFrequency())));

    }

    void validateCityModules(List<LinkedHashMap> cityMods, SoftAssert sa) {
        Validate.asAssortedEntity(cityMods, sa);
    }

}
