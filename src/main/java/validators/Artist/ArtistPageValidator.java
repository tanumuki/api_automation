package validators.Artist;

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

    final String className = getClass().getName();

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
        if(artistObj.getArtistPlaylists() != null) {
            validateArtistPlaylists(artistObj, sa);
        }


    }

    public void validateArtistFields(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(Validate.isNonEmptyString(artistObj.getArtistId())){
            sa.assertTrue(Validate.asNum(artistObj.getArtistId()), AssertionMsg.print(className, methodName, "artistID", artistObj.getArtistId()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist ID is null/empty");
        }

        if(Validate.isNonEmptyString(artistObj.getSubtitle())) {
            sa.assertTrue(Validate.asSubtitleArtist(artistObj.getSubtitle()), AssertionMsg.print(className, methodName, "subtitle", artistObj.getSubtitle()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist Subtitle is null/empty");
        }

        if(Validate.isNonEmptyString(artistObj.getName())) {
            sa.assertTrue(Validate.asString(artistObj.getName()), AssertionMsg.print(className, methodName, "name", artistObj.getName()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist name is null/empty");
        }

        if(Validate.isNonEmptyString(artistObj.getFollower_count())) {
            sa.assertTrue(Validate.asNum(artistObj.getFollower_count()), AssertionMsg.print(className, methodName, "follower_count", artistObj.getFollower_count()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist follower count is null/empty");
        }

        if(Validate.isNonEmptyString(artistObj.getType())) {
            sa.assertTrue(Validate.asArtistType(artistObj.getType()), AssertionMsg.print(className, methodName, "type", artistObj.getType()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist type is null/empty");
        }

        if(artistObj.getIsVerified() != null) {
            sa.assertTrue(Validate.asBoolean(artistObj.getIsVerified()), AssertionMsg.print(className, methodName, "isVerified", Boolean.toString(artistObj.getIsVerified())));
        }else{
            sa.fail(className+"--"+ methodName + "Artist is verified is null");
        }

        if(Validate.isNonEmptyString(artistObj.getDominantLanguage())) {
            sa.assertTrue(Validate.asMusicLanguage(artistObj.getDominantLanguage()), AssertionMsg.print(className, methodName, "dominantLanguage", artistObj.getDominantLanguage()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist dominant language is null/empty");
        }

        if(Validate.isNonEmptyString(artistObj.getDominantType())) {
            sa.assertTrue(Validate.asArtistType(artistObj.getDominantType()), AssertionMsg.print(className, methodName, "dominantType", artistObj.getDominantType()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist dominant type is null/empty");
        }

//        if(artistObj.isRadioPresent() ) {
            sa.assertTrue(Validate.asBoolean(artistObj.isRadioPresent()), AssertionMsg.print(className, methodName, "isRadioPresent", Boolean.toString(artistObj.isRadioPresent())));
//        }
        if(Validate.isNonEmptyString(artistObj.getBio())) {
            sa.assertTrue(Validate.asString(artistObj.getBio()), AssertionMsg.print(className, methodName, "bio", artistObj.getBio()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist bio is null/empty");
        }

        if(Validate.isNonEmptyString(artistObj.getDob())) {
            sa.assertTrue(Validate.asDate(artistObj.getDob()), AssertionMsg.print(className, methodName, "dob", artistObj.getDob()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist DOB is null/empty");
        }

        if(Validate.isNonEmptyString(artistObj.getFb())) {
            sa.assertTrue(Validate.asExternalURL(artistObj.getFb()), AssertionMsg.print(className, methodName, "fb", artistObj.getFb()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist FB is null/empty");
        }

        if(Validate.isNonEmptyString(artistObj.getTwitter())) {
            sa.assertTrue(Validate.asExternalURL(artistObj.getTwitter()), AssertionMsg.print(className, methodName, "twitter", artistObj.getTwitter()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist twitter is null/empty");
        }

        if(Validate.isNonEmptyString(artistObj.getWiki())) {
            sa.assertTrue(Validate.asExternalURL(artistObj.getWiki()), AssertionMsg.print(className, methodName, "wiki", artistObj.getWiki()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist wiki is null/empty");
        }

        if(Validate.isNonEmptyString(artistObj.getFan_count())) {
            sa.assertTrue(Validate.asNum(artistObj.getFan_count()), AssertionMsg.print(className, methodName, "fan_count", artistObj.getFan_count()));
        }else{
            sa.fail(className+"--"+ methodName + "Artist fan count is null/empty");
        }

        sa.assertTrue(Validate.asBoolean(artistObj.is_followed()), AssertionMsg.print(className, methodName, "is_followed", Boolean.toString(artistObj.is_followed())));

    }

    public void validateTopSongs(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(artistObj.getTopSongs() != null){
            List<Song> songListing = artistObj.getTopSongs().getSongs();
            for (Song song : songListing) {
                new SongValidator().validate(song, sa, artistObj.getArtistId(), "artist top songs");
            }

            sa.assertTrue(Validate.asNum((artistObj.getTopSongs().getTotal())),
                    AssertionMsg.print(className, methodName, "total songs", Integer.toString(artistObj.getTopSongs().getTotal())));

            if (artistObj.getTopSongs().getLast_page() != null) {
                sa.assertTrue(Validate.asBoolean((artistObj.getTopSongs().getLast_page())),
                        AssertionMsg.print(className, methodName, "is_last_page", Boolean.toString(artistObj.getTopSongs().getLast_page())));
            }
        }else{
            sa.fail(className+"--"+ methodName + "Artist Top songs is null");
        }


    }

    public void validateTopAlbums(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(artistObj.getTopAlbums() != null) {
            List<AlbumMiniObject> albumListing = artistObj.getTopAlbums().getAlbums();
            for (AlbumMiniObject album : albumListing) {
                new AlbumMiniValidator().validate(album, sa, artistObj.getArtistId(),"artist top albums");
            }

            sa.assertTrue(Validate.asNum((artistObj.getTopAlbums().getTotal())),
                    AssertionMsg.print(className, methodName, "total albums", Integer.toString(artistObj.getTopAlbums().getTotal())));

            if (artistObj.getTopAlbums().getLast_page() != null) {
                sa.assertTrue(Validate.asBoolean((artistObj.getTopAlbums().getLast_page())),
                        AssertionMsg.print(className, methodName, "is_last_page", Boolean.toString(artistObj.getTopAlbums().getLast_page())));
            }
        }else{
            sa.fail(className+"--"+ methodName + "Artist top albums is null");
        }


    }

    /**
     * This method is used to validate the SimilarArtists array in the artist.getArtistPageDetails API response.
     * @param artistObj
     * @param sa
     */
    public void validateSimilarArtists(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        //        Validate similarArtists
        List<SimilarArtists> similarArtistsObj = artistObj.getSimilarArtists();
        if(similarArtistsObj != null && similarArtistsObj.size() > 0) {
            for (SimilarArtists sm_art : similarArtistsObj) {
                validateSimilarArtistFields(sm_art, sa);

            }
        }

    }

    /**
     * This method is used to validate the artist.GetArtistSimilarArtists API response.
     * @param similarArtistObj
     * @param sa
     */
    public void validateSimilarArtists(SimilarArtists similarArtistObj, SoftAssert sa) {
        validateSimilarArtistFields(similarArtistObj, sa);
    }

    /**
     * Generic method that will validate all the fields inside the similarArtists object.
     * AVOID calling this method directly. Use validateSimilarArtists method instead
     * @param sm_art
     * @param sa
     */
    private void validateSimilarArtistFields(SimilarArtists sm_art, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        sa.assertTrue(Validate.asNum(sm_art.get_id()), AssertionMsg.print(className, methodName, "id", sm_art.get_id()));
        sa.assertTrue(Validate.asString(sm_art.getName()), AssertionMsg.print(className, methodName, "name", sm_art.getName()));

        if(Validate.isNonEmptyString(sm_art.getBio())) {
            sa.assertTrue(Validate.asString(sm_art.getBio()), AssertionMsg.print(className, methodName, "bio", sm_art.getBio()));
        }

        sa.assertTrue(Validate.asString(sm_art.getRoles()), AssertionMsg.print(className, methodName, "roles", sm_art.getRoles()));

        if(Validate.isNonEmptyString(sm_art.getAka())) {
            sa.assertTrue(Validate.asString(sm_art.getAka()), AssertionMsg.print(className, methodName, "aka", sm_art.getAka()));
        }

        if(Validate.isNonEmptyString(sm_art.getFb())) {
            sa.assertTrue(Validate.asExternalURL(sm_art.getFb()), AssertionMsg.print(className, methodName, "fb", sm_art.getFb()));
        }

        if(Validate.isNonEmptyString(sm_art.getTwitter())) {
            sa.assertTrue(Validate.asExternalURL(sm_art.getTwitter()), AssertionMsg.print(className, methodName, "twitter", sm_art.getTwitter()));
        }

        if(Validate.isNonEmptyString(sm_art.getWiki())) {
            sa.assertTrue(Validate.asExternalURL(sm_art.getWiki()), AssertionMsg.print(className, methodName, "wiki", sm_art.getWiki()));
        }
        sa.assertTrue(Validate.asString(sm_art.getSimilar()), AssertionMsg.print(className, methodName, "similar", sm_art.getSimilar()));

        if(Validate.isNonEmptyString(sm_art.getDob())) {
            sa.assertTrue(Validate.asDate(sm_art.getDob()), AssertionMsg.print(className, methodName, "dob", sm_art.getDob()));
        }
        sa.assertTrue(Validate.asCDNURL(sm_art.getImage_url()), AssertionMsg.print(className, methodName, "image_url", sm_art.getImage_url()));

        sa.assertTrue(Validate.asString(sm_art.getSearch_keywords().replaceAll("(\\r?\\n)","")), AssertionMsg.print(className, methodName, "search_keywords", sm_art.getSearch_keywords()));
        sa.assertTrue(Validate.asString(sm_art.getPrimary_artist_id()), AssertionMsg.print(className, methodName, "primary_artist_id", sm_art.getPrimary_artist_id()));
        sa.assertTrue(Validate.asNum(sm_art.getCombine_artist_pages()), AssertionMsg.print(className, methodName, "combine_artist_pages", sm_art.getCombine_artist_pages()));
        sa.assertTrue(Validate.asNum(sm_art.getReplace_with_primary_artists()), AssertionMsg.print(className, methodName, "replace_with_primary_artists", sm_art.getReplace_with_primary_artists()));
        sa.assertTrue(Validate.asString(sm_art.getLanguages()), AssertionMsg.print(className, methodName, "languages", sm_art.getLanguages()));
        sa.assertTrue(Validate.asPermaURL(sm_art.getPerma_url()), AssertionMsg.print(className, methodName, "perma_url", sm_art.getPerma_url()));
        sa.assertTrue(Validate.asString(sm_art.getType()), AssertionMsg.print(className, methodName, "type", sm_art.getType()));
        sa.assertTrue(Validate.asBoolean(sm_art.getMini_obj()), AssertionMsg.print(className, methodName, "mini_obj", sm_art.getMini_obj()));
        sa.assertTrue(Validate.asBoolean(sm_art.getIsRadioPresent()), AssertionMsg.print(className, methodName, "iSRadioPresent", sm_art.getIsRadioPresent()));
        sa.assertTrue(Validate.asArtistType(sm_art.getDominantType()), AssertionMsg.print(className, methodName, "dominantType", sm_art.getDominantType()));
    }

    void validateURLs(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();
        if(artistObj.getUrls() != null) {
            sa.assertTrue(Validate.asPermaURL(artistObj.getUrls().getAlbums()), AssertionMsg.print(className, methodName, "artist.urls.albums", artistObj.getUrls().getAlbums()));

            if(Validate.isNonEmptyString(artistObj.getUrls().getBio())) {
                sa.assertTrue(Validate.asString(artistObj.getUrls().getBio()), AssertionMsg.print(className, methodName, "artist.urls.bio", artistObj.getUrls().getBio()));
            }

            if(Validate.isNonEmptyString(artistObj.getUrls().getComments())) {
                sa.assertTrue(Validate.asPermaURL(artistObj.getUrls().getComments()), AssertionMsg.print(className, methodName, "artist.urls.comments", artistObj.getUrls().getComments()));
            }

            if(Validate.isNonEmptyString(artistObj.getUrls().getSongs())) {
                sa.assertTrue(Validate.asPermaURL(artistObj.getUrls().getSongs()), AssertionMsg.print(className, methodName, "artist.urls.songs", artistObj.getUrls().getSongs()));
            }
        }
    }

    void validateAvailableLanguages(Artist artistObj, SoftAssert sa) {
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();

        if(artistObj.getAvailableLanguages() != null && artistObj.getAvailableLanguages().size() > 0) {
            for (String language : artistObj.getAvailableLanguages()) {
                musicLanguages ml = musicLanguages.valueOf(language.toUpperCase());
                sa.assertEquals(language, ml.toString().toLowerCase());
            }
        }


    }

    void validateArtistPlaylists(Artist artistObj, SoftAssert sa) {
        List<Playlist> plv = artistObj.getArtistPlaylists();
        if(plv != null && plv.size() > 0) {
            for (Playlist pl : plv) {
                new PlaylistMiniValidator().validate(pl, sa);
            }
        }
    }

}
