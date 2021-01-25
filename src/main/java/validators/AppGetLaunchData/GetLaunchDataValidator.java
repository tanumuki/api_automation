package validators.AppGetLaunchData;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.*;
import org.testng.asserts.SoftAssert;
import pojos.appGetLaunchData.*;
import pojos.getHomePageDataV2.HomePageDataModules;
import validators.AssertionMsg;
import validators.HomepageDataV2.HomePageDataModuleValidator;
import validators.Validate;
import validators.genericValidators.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GetLaunchDataValidator {
    final String className = getClass().getName();

    public void validate(AppGetLaunchData obj, SoftAssert sa, String appVersion) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(obj.getAppVersion() != null)
            sa.assertTrue(Validate.asNum(obj.getAppVersion()), AssertionMsg.print(className, methodName, "app_version", String.valueOf(obj.getAppVersion())));

        if(obj.getUpdateConfig() != null)
            validateUpdateConfig(obj.getUpdateConfig(), sa);

        //TODO: ab_test check, For now it's coming up as null obj

        //Validate ef
        for (String item : obj.getEf()) {
            sa.assertTrue(Validate.asString(item), AssertionMsg.print(className, methodName, "ef", item));
        }


        //Validate ab_test

        //Validate suggest
        if(obj.getSuggests() instanceof List){
            sa.assertTrue(((List<?>) obj.getSuggests()).size() == 0, "GetLaunchDataValidator: Suggests coming up as array and is not empty");
        }else {
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
            Suggests suggests = mapper.convertValue(obj.getSuggests(), Suggests.class);
            validateSuggests(suggests, sa);
        }

        //Validate ping_server
        sa.assertTrue(Validate.asString(obj.getPingServer()), AssertionMsg.print(className, methodName, "ping_server", obj.getPingServer()));


        //Validate new trending
        Validate.asAssortedEntity(obj.getNewTrending(), sa);

        //Validate top playlists
        Validate.asChartsAndPlaylists(obj.getTopPlaylists(), sa);

        //Validate new albums
        for (AlbumMiniObject album : obj.getNewAlbums()) {
            new AlbumMiniValidator().validate(album, sa);
        }

        //Validate top shows
        new TopShowsValidator().validate(obj.getTopShows(), sa);

        //Validate browse & discover
        Validate.asBrowseAndDiscover(obj.getBrowseDiscover(), sa);

        //Validate most_popular_trillers
        validateTrillers(obj.getMost_popular_trillers(), sa);

        //Validate most_popular_artist_trillers
        validateTrillers(obj.getMost_popular_artist_trillers(), sa);


        //Validate radio
        Validate.asFeaturedStations(obj.getRadio(), sa);

        //Validate top searches
        for (TopSearch ts : obj.getTopSearches()) {
            validateTopSearches(ts, sa, appVersion);
        }

        new GlobalConfigValidator().validate(obj, sa);


        //Validate loginwall
        if (Validate.isNonEmptyString(obj.getLoginwall()))
            sa.assertTrue(Validate.asBoolean(obj.getLoginwall()), AssertionMsg.print(className, methodName, "loginwall", obj.getLoginwall()));

        //Validate jiologinwall
        if (Validate.isNonEmptyString(obj.getJiologinwall()))
            sa.assertTrue(Validate.asBoolean(obj.getJiologinwall()), AssertionMsg.print(className, methodName, "jiologinwall", obj.getJiologinwall()));
/*
        //Validate deferred login config
        if(obj.getDeferred_login_config() != null)
            validateDeferredLoginConfig(obj.getDeferred_login_config().getConfig(), sa);
*/
        //Validate charts
        Validate.asChartsAndPlaylists(obj.getCharts(), sa);

        new UserStateValidator().validate(obj.getUser_state(), sa);

        //Validate ads
        validateAds(obj.getAds(), sa);

        //Validate mix & tag_mixes
        Validate.asMixes(obj.getTagMixes(), sa);

        //Validate artist recos
        Validate.asArtistRecos(obj.getArtistRecos(), sa);

        //Validate City Modules
        validateCityModules(obj.getCityMod(), sa);

        //Validate saavn_pro
        validateSaavnpro(obj.getSaavn_pro(), sa);

        //Validate Topics & promos
        if(obj.getTopicPromos() != null) {
            for(Map.Entry<String, List<LinkedHashMap>> entry : obj.getTopicPromos().entrySet()){
                if(entry.getKey().matches("(promo|topic)*")){
                    Validate.asAssortedEntity(entry.getValue(), sa);
                }
            }
        }


        validateModules(obj.getModules(), sa);

        sa.assertTrue(Validate.asString(obj.getGreeting()), AssertionMsg.print(className, methodName, "greeting", obj.getGreeting()));

        sa.assertTrue(Validate.asBoolean(obj.getLastPage()), AssertionMsg.print(className, methodName, "last_page", String.valueOf(obj.getLastPage())));

    }



    void validateDeferredLoginConfigObj(DeferredLoginConfigObjParams dl, String configName, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(Validate.isNonEmptyString(dl.getCopy()))
            sa.assertTrue(Validate.asString(dl.getCopy()), AssertionMsg.print(className, methodName, "deferred_login.config." + configName + ".copy", dl.getCopy()));

        if(Validate.isNonEmptyString(dl.getType()))
            sa.assertTrue(Validate.asString(dl.getType()), AssertionMsg.print(className, methodName, "deferred_login.config." + configName + ".type", dl.getType()));

        if(Validate.isNonEmptyString(dl.getTitle()))
            sa.assertTrue(Validate.asString(dl.getTitle()), AssertionMsg.print(className, methodName, "deferred_login.config." + configName + ".title", dl.getTitle()));

        if(Validate.isNonEmptyString(dl.getSubtitle()))
            sa.assertTrue(Validate.asString(dl.getSubtitle()), AssertionMsg.print(className, methodName, "deferred_login.config." + configName + ".subtitle", dl.getSubtitle()));

        if(Validate.isNonEmptyString(dl.getLogged_in()))
            sa.assertTrue(Validate.asString(dl.getLogged_in()), AssertionMsg.print(className, methodName, "deferred_login.config." + configName + ".logged_in", dl.getLogged_in()));

        if(Validate.isNonEmptyString(dl.getPro_Feature()))
            sa.assertTrue(Validate.asString(dl.getType()), AssertionMsg.print(className, methodName, "deferred_login.config." + configName + ".pro_feature", dl.getPro_Feature()));
    }

    void validateDeferredLoginConfig(DeferredLoginConfigObj con, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        validateDeferredLoginConfigObj(con.getPrimary_cta(), "primary_cta", sa);
        validateDeferredLoginConfigObj(con.getSecondary_cta_1(), "secondary_cta_1", sa);
        validateDeferredLoginConfigObj(con.getSecondary_cta_2(), "secondary_cta_2", sa);
        validateDeferredLoginConfigObj(con.getSwipe_landing(), "swipe_landing", sa);
        validateDeferredLoginConfigObj(con.getSwipe_landing_skippable(), "swipe_landing_skippable", sa);
    }

    void validateTrillers(List<Song> trillers, SoftAssert sa) {
        for(Song song : trillers){
            new SongValidator().validate(song, sa, song.getId(), "song");
        }
    }

    void validateModules(HomePageDataModules modules, SoftAssert sa) {
        new HomePageDataModuleValidator().validate(modules, sa);
    }


    public void validateAds(Ads ads, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        System.out.println("=======Validate Ads=========");
        System.out.println("ads null? " + ads == null);
        if (ads != null) {
            System.out.println("----Not Null----");
            if (Validate.isNonEmptyString(ads.getCarrier())) {
                sa.assertTrue(Validate.asString(ads.getCarrier()), AssertionMsg.print(className, methodName, "ads.carrier", ads.getCarrier()));
                System.out.println("carrier: " + ads.getCarrier());
            }


            if (Validate.isNonEmptyString(ads.getSegmentIds()))
                sa.assertTrue(Validate.asString(ads.getSegmentIds()), AssertionMsg.print(className, methodName, "ads.segment_ids", ads.getSegmentIds()));

            System.out.println("gender: " + ads.getGender());
            if (Validate.isNonEmptyString(ads.getGender())) {
                sa.assertTrue(Validate.asString(ads.getGender()), AssertionMsg.print(className, methodName, "ads.gender", ads.getGender()));
                System.out.println("gender: " + ads.getGender());
            }


            if (Validate.isNonEmptyString(ads.getCohort())) {
                sa.assertTrue(Validate.asString(ads.getCohort()), AssertionMsg.print(className, methodName, "ads.cohort", ads.getCohort()));
                System.out.println("cohort: " + ads.getCohort());
            }


        }

    }

    void validateSuggests(Suggests suggests, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        sa.assertTrue(Validate.asString(suggests.getHeadline()), AssertionMsg.print(className, methodName, "suggests.headline", suggests.getHeadline()));

        sa.assertTrue(Validate.asString(suggests.getBadge()), AssertionMsg.print(className, methodName, "suggests.badge", suggests.getBadge()));

        Validate.asAssortedEntity(suggests.getItems(), sa);
    }

    public void validateTopSearches(TopSearch ts, SoftAssert sa, String appVersion) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if (Validate.isNonEmptyString(ts.getEntityId()))
            sa.assertTrue(Validate.asString(ts.getEntityId()), AssertionMsg.print(className, methodName, "top_searches.entity_id", ts.getEntityId()));

        if (Validate.isNonEmptyString(ts.getEntityName()))
            sa.assertTrue(Validate.asString(ts.getEntityName()), AssertionMsg.print(className, methodName, "top_searches.entity_name", ts.getEntityName()));

        if (Validate.isNonEmptyString(ts.getEntityType()))
            sa.assertTrue(Validate.asEntityType(ts.getEntityType()), AssertionMsg.print(className, methodName, "top_searches.entity_type", ts.getEntityType()));

//        ID must be present. So no null checks
        sa.assertTrue(Validate.asId(ts.getId()), AssertionMsg.print(className, methodName, "top_searches.id", ts.getId()));

//        title must be present. So no null checks
        sa.assertTrue(Validate.asString(ts.getTitle()), AssertionMsg.print(className, methodName, "top_searches.title", ts.getTitle()));

//        type must be present. So no null checks
        sa.assertTrue(Validate.asEntityType(ts.getType()), AssertionMsg.print(className, methodName, "top_searches.type", ts.getType()));

//        image must be present. So no null checks
        sa.assertTrue(Validate.asCDNURL(ts.getImage()), AssertionMsg.print(className, methodName, "top_searches.image", ts.getImage()));

        if (Validate.isNonEmptyString(ts.getExplicit_content()))
            sa.assertTrue(Validate.asNum(ts.getExplicit_content()), AssertionMsg.print(className, methodName, "top_searches.explicit_content", ts.getExplicit_content()));

        if (ts.getMini_obj()=="false")
        {
            System.out.println(ts.getMoreInfo());

        }

    }


    void validateUpdateConfig(UpdateConfig uc, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();


        if (Validate.isNonEmptyString(uc.getUrl()))
            sa.assertTrue(Validate.asUpdateUrl(uc.getUrl()), AssertionMsg.print(className, methodName, "update_config.url", uc.getUrl()));

        sa.assertTrue(Validate.asNum(uc.getFrequency()), AssertionMsg.print(className, methodName, "update_config.frequency", String.valueOf(uc.getFrequency())));

    }

    void validateCityModules(List<LinkedHashMap> cityMods, SoftAssert sa) {
        Validate.asAssortedEntity(cityMods, sa);
    }


    void validateSaavnpro(List<Deeplink> deeplinks, SoftAssert sa) {
        for(Deeplink dl : deeplinks){
            validateDeeplink(dl, sa);
        }
    }

    void validateDeeplink(Deeplink deeplink, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        new EntityValidator().validate(deeplink, sa);
        sa.assertTrue(Validate.asDeeplink(deeplink.getDeeplink()), AssertionMsg.print(className, methodName, "deeplink.deeplink", deeplink.getDeeplink()));
    }

}
