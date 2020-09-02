package validators.HomepageDataV2;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.*;
import org.testng.asserts.SoftAssert;
import pojos.getHomePageDataV2.HomePageDataV2;
import pojos.getTopShows.TopShows;
import pojos.libraryOps.SongData;
import validators.AssertionMsg;
import validators.PlaylistMiniValidator;
import validators.Validate;
import validators.genericValidators.*;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HomepageDataValidator {
    final String className = getClass().getName();
    public void validate(HomePageDataV2 hd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        validateBrowse(hd, sa);
        validateGenres(hd, sa);
        validateNewTrending(hd, sa);
        validatePlaylistsCharts(hd, sa);
        validateRadio(hd, sa);
        validateTopShows(hd, sa);
        validateFavorites(hd, sa);
        validateSuggests(hd, sa);
        validateTopicsPromos(hd.getTopicPromos(), sa);
        validateMixes(hd, sa);
        validateTagMixes(hd, sa);
        validateArtistRecos(hd, sa);
//        validateCityMod(hd, sa);
    }

    void validateCityMod(HomePageDataV2 hd, SoftAssert sa) {
        for(LinkedHashMap entity : hd.getCityMod()){
            Validate.asAssortedEntity(entity, sa);
        }
    }

    void validateArtistRecos(HomePageDataV2 hd, SoftAssert sa) {
        for(RadioStation rs : hd.getArtistRecos()){
            new RadioStationValidator().validate(rs, sa);
        }
    }

    void validateMixes(HomePageDataV2 hd, SoftAssert sa){
        for(Mix mix : hd.getMixes()){
            new MixValidator().validate(mix, sa);
        }
    }

    void validateTagMixes(HomePageDataV2 hd, SoftAssert sa){
        for(Mix mix : hd.getTagMixes()){
            new MixValidator().validate(mix, sa);
        }
    }

    void validateTopicsPromos(Map<String, List<Object>> map, SoftAssert sa) {
        for(String key : map.keySet()){
            if(key.startsWith("promo")) continue;  //TODO: Validate promos once the more_info issue is fixed
            System.out.println("key: " + key);
            for(Object entity : map.get(key)) {
                LinkedHashMap entityMap = (LinkedHashMap) entity;
                Validate.asAssortedEntity(entityMap, sa);
            }

        }
    }

    void validateSuggests(HomePageDataV2 hd, SoftAssert sa) {
//        new SuggestsValidator().validate(, sa);
    }

    void validateFavorites(HomePageDataV2 hd, SoftAssert sa) {
        List<LinkedHashMap> favorites = hd.getFavorites();
        for(LinkedHashMap entity : favorites){
            Validate.asAssortedEntity(entity, sa);
        }
    }

    public void validateBrowse(HomePageDataV2 hd, SoftAssert sa) {
        System.out.println("=====Validating Browse======");
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        for(Channel channel : hd.getBrowseDiscover()) {
            new ChannelValidator().validate(channel, sa);
        }
    }

    void validateRadio(HomePageDataV2 hd, SoftAssert sa) {
        System.out.println("=====Validating Radio======");
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        Radio radio = hd.getRadio();
        for(RadioStation station : radio.getFeatured_stations()) {
            new RadioStationValidator().validate(station, sa);
        }
    }

    public void validatePlaylistsCharts(HomePageDataV2 hd, SoftAssert sa) {
        System.out.println("=====Validating Playlist (charts)======");
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        for(PlaylistMini chart : hd.getCharts()) {
            new PlaylistMiniValidator().validate(chart, sa);
        }

        for(PlaylistMini playlist : hd.getTopPlaylists()) {
            new PlaylistMiniValidator().validate(playlist, sa);
        }
    }

    public void validateTopShows(HomePageDataV2 hd, SoftAssert sa) {
        System.out.println("=====Validating Top Shows======");
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        TopShows topShows = hd.getTopShows();
        new TopShowsValidator().validate(topShows, sa);
    }

    public void validateGenres(HomePageDataV2 hd, SoftAssert sa) {
        System.out.println("=====Validating Genres======");
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        for(Genre genre : hd.getGenres()) {
            new GenreValidator().validate(genre, sa);
        }
    }

    void validateUserState(HomePageDataV2 hd, SoftAssert sa) {
        System.out.println("=====Validating User state======");
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        UserState userState = hd.getUserState();
        new UserStateValidator().validate(userState, sa);
    }

    public void validateNewTrending(HomePageDataV2 hd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        sa.assertTrue(hd.getLastPage(), AssertionMsg.print(className, methodName, "last_page", String.valueOf(hd.getLastPage())));
        for(LinkedHashMap entity : hd.getNewTrending()) {
            System.out.println(entity.toString());
            Validate.asAssortedEntity(entity, sa);
        }
    }
}
