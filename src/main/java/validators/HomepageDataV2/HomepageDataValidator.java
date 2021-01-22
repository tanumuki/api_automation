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
        validateCityMod(hd, sa);
        validateUserState(hd, sa);
    }

    void validateCityMod(HomePageDataV2 hd, SoftAssert sa) {
        Validate.asAssortedEntity(hd.getCityMod(), sa);
    }

    void validateArtistRecos(HomePageDataV2 hd, SoftAssert sa) {
        Validate.asArtistRecos(hd.getArtistRecos(), sa);
    }

    void validateMixes(HomePageDataV2 hd, SoftAssert sa) {
        Validate.asMixes(hd.getMixes(), sa);
    }

    void validateTagMixes(HomePageDataV2 hd, SoftAssert sa) {
        Validate.asMixes(hd.getTagMixes(), sa);
    }

    void validateTopicsPromos(Map<String, List<Object>> map, SoftAssert sa) {
        Validate.asTopicsPromos(map, sa);
    }

    void validateSuggests(HomePageDataV2 hd, SoftAssert sa) {
//        new SuggestsValidator().validate(, sa);
        //TODO: Suggests validation
    }

    void validateFavorites(HomePageDataV2 hd, SoftAssert sa) {
        if (hd.getFavorites() != null)
            Validate.asAssortedEntity(hd.getFavorites(), sa);
    }

    public void validateBrowse(HomePageDataV2 hd, SoftAssert sa) {
        Validate.asBrowseAndDiscover(hd.getBrowseDiscover(), sa);
    }

    void validateRadio(HomePageDataV2 hd, SoftAssert sa) {
        Validate.asFeaturedStations(hd.getRadio(), sa);
    }

    public void validatePlaylistsCharts(HomePageDataV2 hd, SoftAssert sa) {
        System.out.println("=====Validating Playlist (charts)======");
        Validate.asChartsAndPlaylists(hd.getCharts(), sa);
        Validate.asChartsAndPlaylists(hd.getTopPlaylists(), sa);
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
        if (hd.getGenres() != null) {
            for (Genre genre : hd.getGenres()) {
                new GenreValidator().validate(genre, sa);
            }
        }
    }

    void validateUserState(HomePageDataV2 hd, SoftAssert sa) {
        System.out.println("=====Validating User state======");
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        UserState userState = hd.getUserState();
        new UserStateValidator().validate(userState, sa);
    }

    public void validateNewTrending(HomePageDataV2 hd, SoftAssert sa) {
        Validate.asAssortedEntity(hd.getNewTrending(), sa);
    }
}
