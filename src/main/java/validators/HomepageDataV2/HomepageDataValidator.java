package validators.HomepageDataV2;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.*;
import org.testng.asserts.SoftAssert;
import pojos.getHomePageDataV2.HomePageDataModules;
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

        if(hd.getTopicPromos() != null) {
            for(Map.Entry<String, List<LinkedHashMap>> entry : hd.getTopicPromos().entrySet()){
                if(entry.getKey().matches("(promo|topic)*")){
                    Validate.asAssortedEntity(entry.getValue(), sa);
                }
            }
        }

        validateNewAlbums(hd, sa);
        validateMixes(hd, sa);
        validateTagMixes(hd, sa);
        validateArtistRecos(hd, sa);
        validateCityMod(hd, sa);
        validateUserState(hd, sa);

        if(hd.getMost_popular_trillers() != null)
            validateTrillers(hd.getMost_popular_trillers(), sa);
        if(hd.getMost_popular_artist_trillers() != null)
            validateTrillers(hd.getMost_popular_artist_trillers(), sa);

        new UserStateValidator().validate(hd.getUserState(), sa);

        validateModules(hd.getModules(), sa);

        sa.assertTrue(Validate.asString(hd.getGreeting()), AssertionMsg.print(className, methodName, "greeting", hd.getGreeting()));

        sa.assertTrue(Validate.asBoolean(hd.getLastPage()), AssertionMsg.print(className, methodName, "last_page", String.valueOf(hd.getLastPage())));
    }

    void validateModules(HomePageDataModules modules, SoftAssert sa) {
        new HomePageDataModuleValidator().validate(modules, sa);
    }

    void validateNewAlbums(HomePageDataV2 hd, SoftAssert sa) {
        if(hd.getNewAlbums().size() > 6) {
            for (AlbumMiniObject album : hd.getNewAlbums()) {
                new AlbumMiniValidator().validate(album, sa);
            }
        }else {
            sa.fail("GetHomepageData Validator: New Albums list size <= 6");
        }

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



    void validateSuggests(HomePageDataV2 hd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(hd.getSuggests() instanceof List){
            sa.assertTrue(((List<?>) hd.getSuggests()).size() == 0, "GetLaunchDataValidator: Suggests coming up as array and is not empty");
        }else {
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
            Suggests suggests = mapper.convertValue(hd.getSuggests(), Suggests.class);

            sa.assertTrue(Validate.asString(suggests.getHeadline()), AssertionMsg.print(className, methodName, "suggests.headline", suggests.getHeadline()));

            sa.assertTrue(Validate.asString(suggests.getBadge()), AssertionMsg.print(className, methodName, "suggests.badge", suggests.getBadge()));

            Validate.asAssortedEntity(suggests.getItems(), sa);
        }

    }

    void validateFavorites(HomePageDataV2 hd, SoftAssert sa) {
        if (hd.getFavorites() != null)
            Validate.asAssortedEntity(hd.getFavorites(), sa);
    }

    public void validateBrowse(HomePageDataV2 hd, SoftAssert sa) {
        Validate.asBrowseAndDiscover(hd.getBrowseDiscover(), sa);
    }

    void validateTrillers(List<Song> trillers, SoftAssert sa) {
        for(Song song : trillers){
            new SongValidator().validate(song, sa, song.getId(), "song");
        }
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
