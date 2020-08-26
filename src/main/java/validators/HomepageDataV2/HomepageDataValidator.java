package validators.HomepageDataV2;

import entities.*;
import org.testng.asserts.SoftAssert;
import pojos.getHomePageDataV2.HomePageDataV2;
import pojos.getTopShows.TopShows;
import validators.AssertionMsg;
import validators.PlaylistMiniValidator;
import validators.Validate;
import validators.genericValidators.*;

import java.util.Iterator;

public class HomepageDataValidator {
    final String className = getClass().getName();
    public void validate(HomePageDataV2 hd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        validateBrowse(hd, sa);
        validateGenres(hd, sa);
//        validateNewTrending(hd, sa);
        validatePlaylistsCharts(hd, sa);
        validateRadio(hd, sa);
        validateTopShows(hd, sa);
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

    void validateSuggests(){
        
    }


    public void validateNewTrending(HomePageDataV2 hd, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        sa.assertTrue(hd.getLastPage(), AssertionMsg.print(className, methodName, "last_page", String.valueOf(hd.getLastPage())));



        for(Object entity : hd.getNewTrending()) {
            boolean isAlbum = entity instanceof AlbumMiniObject;
            if(isAlbum) {
                AlbumMiniObject album = (AlbumMiniObject) entity;
                System.out.println(album.getType()+"-Aswin-");
            }
        }
    }
}
