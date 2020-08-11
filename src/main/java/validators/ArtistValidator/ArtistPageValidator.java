package validators.ArtistValidator;

import entities.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.Artist.SimilarArtists;
import validators.AssertionMsg;
import validators.Validate;
import validators.genericValidators.AlbumMiniValidator;
import validators.genericValidators.EntityValidator;
import enums.musicLanguages;
import validators.genericValidators.PlaylistMiniValidator;
import validators.genericValidators.SongValidator;

import java.util.List;

/**
 * @author ashwinsriv
 *
 */

@Slf4j
public class ArtistPageValidator extends EntityValidator {

    public void validateAll(Artist artistObj, SoftAssert sa) {

//      Validate a few fields from the entity validator: type, subtitle, image
        super.validate(artistObj, sa, artistObj.getArtistId(), "artist");

//        Validate the top level fields
        validateArtistFields(artistObj, sa);

//        Validate topSongs and topAlbums
        validateTopSongs(artistObj, sa);
        validateTopAlbums(artistObj, sa);

//        Validate similar artists
        validateSimilarArtists(artistObj, sa);

//        Validate urls
        validateURLs(artistObj, sa);

//        Validate available languages
        validateAvailableLanguages(artistObj, sa);

//        Validate artist playlists
        validateArtistPlaylists(artistObj, sa);


    }

    public void validateArtistFields(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asNum(artistObj.getArtistId()), AssertionMsg.print(methodName, methodName, "artistID", artistObj.getArtistId()));
        sa.assertTrue(artistObj.getSubtitle().matches("Artist.*[0-9]+.Fans"), AssertionMsg.print(methodName, methodName, "subtitle", artistObj.getSubtitle()));

        sa.assertTrue(Validate.asString(artistObj.getName()), AssertionMsg.print(methodName, methodName, "name", artistObj.getName()));
        sa.assertTrue(Validate.asNum(artistObj.getFollower_count()), AssertionMsg.print(methodName, methodName, "follower_count", artistObj.getFollower_count()));
        sa.assertTrue(Validate.asString(artistObj.getType()), AssertionMsg.print(methodName, methodName, "type", artistObj.getType()));
        sa.assertTrue(Validate.asString(artistObj.getIsVerified()), AssertionMsg.print(methodName, methodName, "isVerified", artistObj.getIsVerified()));
        sa.assertTrue(Validate.asString(artistObj.getDominantLanguage()), AssertionMsg.print(methodName, methodName, "dominantLanguage", artistObj.getDominantLanguage()));
        sa.assertTrue(Validate.asString(artistObj.getDominantType()), AssertionMsg.print(methodName, methodName, "dominantType", artistObj.getDominantType()));
        sa.assertTrue(Validate.asBoolean(artistObj.isRadioPresent()), AssertionMsg.print(methodName, methodName, "isRadioPresent", Boolean.toString(artistObj.isRadioPresent())));
        sa.assertTrue(Validate.asString(artistObj.getBio()), AssertionMsg.print(methodName, methodName, "bio", artistObj.getBio()));
        sa.assertTrue(Validate.asDate(artistObj.getDob()), AssertionMsg.print(methodName, methodName, "dob", artistObj.getDob()));
        sa.assertTrue(Validate.asExternalURL(artistObj.getFb()), AssertionMsg.print(methodName, methodName, "fb", artistObj.getFb()));
        sa.assertTrue(Validate.asExternalURL(artistObj.getTwitter()), AssertionMsg.print(methodName, methodName, "twitter", artistObj.getTwitter()));
        sa.assertTrue(Validate.asExternalURL(artistObj.getWiki()), AssertionMsg.print(methodName, methodName, "wiki", artistObj.getWiki()));
        sa.assertTrue(Validate.asNum(artistObj.getFan_count()), AssertionMsg.print(methodName, methodName, "fan_count", artistObj.getFan_count()));
        sa.assertTrue(Validate.asBoolean(artistObj.is_followed()), AssertionMsg.print(methodName, methodName, "is_followed", Boolean.toString(artistObj.is_followed())));

    }

    void validateTopSongs(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        List<Song> songListing = artistObj.getTopSongs().getSongs();
        for (Song song : songListing) {
            new SongValidator().validate(song, sa, artistObj.getArtistId(), "artist top songs");
        }

        sa.assertTrue(Validate.asNum((artistObj.getTopSongs().getTotal())),
                AssertionMsg.print(methodName, methodName, "total songs", Integer.toString(artistObj.getTopSongs().getTotal())));

    }

    void validateTopAlbums(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        List<AlbumMiniObject> albumListing = artistObj.getTopAlbums().getAlbums();
        for (AlbumMiniObject album : albumListing) {
            new AlbumMiniValidator().validate(album, sa, artistObj.getArtistId(),"artist top albums");
        }

        sa.assertTrue(Validate.asNum((artistObj.getTopAlbums().getTotal())),
                AssertionMsg.print(methodName, methodName, "total albums", Integer.toString(artistObj.getTopAlbums().getTotal())));

    }

    public void validateSimilarArtists(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        //        Validate similarArtists
        List<SimilarArtists> similarArtistsObj = artistObj.getSimilarArtists();

        for (SimilarArtists sm_art : similarArtistsObj) {
            sa.assertTrue(Validate.asNum(sm_art.get_id()), AssertionMsg.print(methodName, methodName, "id", sm_art.get_id()));
            sa.assertTrue(Validate.asString(sm_art.getName()), AssertionMsg.print(methodName, methodName, "name", sm_art.getName()));

            if(Validate.isNonEmptyString(sm_art.getBio())) {
                sa.assertTrue(Validate.asString(sm_art.getBio()), AssertionMsg.print(methodName, methodName, "bio", sm_art.getBio()));
            }

            sa.assertTrue(Validate.asString(sm_art.getRoles()), AssertionMsg.print(methodName, methodName, "roles", sm_art.getRoles()));

            if(Validate.isNonEmptyString(sm_art.getAka())) {
                sa.assertTrue(Validate.asString(sm_art.getAka()), AssertionMsg.print(methodName, methodName, "aka", sm_art.getAka()));
            }

            if(Validate.isNonEmptyString(sm_art.getFb())) {
                sa.assertTrue(Validate.asExternalURL(sm_art.getFb()), AssertionMsg.print(methodName, methodName, "fb", sm_art.getFb()));
            }

            if(Validate.isNonEmptyString(sm_art.getTwitter())) {
                sa.assertTrue(Validate.asExternalURL(sm_art.getTwitter()), AssertionMsg.print(methodName, methodName, "twitter", sm_art.getTwitter()));
            }

            if(Validate.isNonEmptyString(sm_art.getWiki())) {
                sa.assertTrue(Validate.asExternalURL(sm_art.getWiki()), AssertionMsg.print(methodName, methodName, "wiki", sm_art.getWiki()));
            }
            sa.assertTrue(Validate.asString(sm_art.getSimilar()), AssertionMsg.print(methodName, methodName, "similar", sm_art.getSimilar()));

            if(Validate.isNonEmptyString(sm_art.getDob())) {
                sa.assertTrue(Validate.asDate(sm_art.getDob()), AssertionMsg.print(methodName, methodName, "dob", sm_art.getDob()));
            }
            sa.assertTrue(Validate.asUrl(sm_art.getImage_url()), AssertionMsg.print(methodName, methodName, "image_url", sm_art.getImage_url()));

            sa.assertTrue(Validate.asString(sm_art.getSearch_keywords().replaceAll("(\\r?\\n)","")), AssertionMsg.print(methodName, methodName, "search_keywords", sm_art.getSearch_keywords()));
            sa.assertTrue(Validate.asString(sm_art.getPrimary_artist_id()), AssertionMsg.print(methodName, methodName, "primary_artist_id", sm_art.getPrimary_artist_id()));
            sa.assertTrue(Validate.asNum(sm_art.getCombine_artist_pages()), AssertionMsg.print(methodName, methodName, "combine_artist_pages", sm_art.getCombine_artist_pages()));
            sa.assertTrue(Validate.asNum(sm_art.getReplace_with_primary_artists()), AssertionMsg.print(methodName, methodName, "replace_with_primary_artists", sm_art.getReplace_with_primary_artists()));
            sa.assertTrue(Validate.asString(sm_art.getLanguages()), AssertionMsg.print(methodName, methodName, "languages", sm_art.getLanguages()));
            sa.assertTrue(Validate.asUrl(sm_art.getPerma_url()), AssertionMsg.print(methodName, methodName, "perma_url", sm_art.getPerma_url()));
            sa.assertTrue(Validate.asString(sm_art.getType()), AssertionMsg.print(methodName, methodName, "type", sm_art.getType()));
            sa.assertTrue(Validate.asBoolean(sm_art.getMini_obj()), AssertionMsg.print(methodName, methodName, "mini_obj", sm_art.getMini_obj()));
            sa.assertTrue(Validate.asBoolean(sm_art.getIsRadioPresent()), AssertionMsg.print(methodName, methodName, "iSRadioPresent", sm_art.getIsRadioPresent()));
            sa.assertTrue(Validate.asString(sm_art.getDominantType()), AssertionMsg.print(methodName, methodName, "dominantType", sm_art.getDominantType()));

        }

    }

    void validateURLs(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asUrl(artistObj.getUrls().getAlbums()), AssertionMsg.print(methodName, methodName, "artist.urls.albums", artistObj.getUrls().getAlbums()));
        sa.assertTrue(Validate.asString(artistObj.getUrls().getBio()), AssertionMsg.print(methodName, methodName, "artist.urls.bio", artistObj.getUrls().getBio()));
        sa.assertTrue(Validate.asUrl(artistObj.getUrls().getComments()), AssertionMsg.print(methodName, methodName, "artist.urls.comments", artistObj.getUrls().getComments()));
        sa.assertTrue(Validate.asUrl(artistObj.getUrls().getSongs()), AssertionMsg.print(methodName, methodName, "artist.urls.songs", artistObj.getUrls().getSongs()));

    }

    void validateAvailableLanguages(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        for (String language : artistObj.getAvailableLanguages()) {
            musicLanguages ml = musicLanguages.valueOf(language.toUpperCase());
            sa.assertEquals(language, ml.toString().toLowerCase());
        }

    }

    void validateArtistPlaylists(Artist artistObj, SoftAssert sa) {
        List<Playlist> plv = artistObj.getArtistPlaylists();

        for (Playlist pl : plv) {
            new PlaylistMiniValidator().validate(pl, sa);
        }


    }

}
