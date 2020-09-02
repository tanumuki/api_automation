/**
 *
 */
package validators;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.*;
import enums.artistTypes;
import enums.musicLanguages;
import io.restassured.response.Response;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import validators.genericValidators.AlbumMiniValidator;
import validators.genericValidators.EpisodeValidator;
import validators.genericValidators.PlaylistValidator;
import validators.genericValidators.SongValidator;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author aswingokulachandran
 *
 */
@Slf4j
public class Validate {
    /*
     * Validate as number
     */
    public static boolean asNum(String str) {
        //return str.matches("\\d+|^$");
        log.debug("Testing as number: \"" + str + "\"");
        return str.matches("^$|^[0-9]\\d*(\\.\\d+)?$|\\d+");
    }

    public static boolean asNum(int number) {
        log.debug("Testing as integer: " + number);
        if (number >=0 || number < 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Use this to verify floating point numbers.
     * @param floatingPtNumber
     * @return
     */
    public static boolean asFloat(String floatingPtNumber) {
        try {
            Float number = Float.parseFloat(floatingPtNumber);
            return true;
        }

        catch(NumberFormatException | NullPointerException ex) {
            return false;
        }
    }

    /*
     * Validate timestamp
     */

    public static boolean asTimeStamp(String time) {
        //return str.matches("\\d+|^$");
        return time.matches("^[0-9]{10}");
    }

    /*
     * Validate featured station type
     */

    public static boolean asFeaturedStationType(String type) {
        //return str.matches("\\d+|^$");
        return type.matches("artist|featured");
    }


    /*
     * Validate as id
     */
    public static boolean asId(String str) {
        return str.matches("[0-9A-Za-z_-]{8}|[0-9]{7}|[0-9A-Za-z_-]{6}|[0-9]{0,9}|[0-9A-Za-z]{32}|[0-9A-Za-z]{42}|[0-9]{96}|[0-9A-Za-z]{42}|[0-9A-Za-z_]{42}");
    }


    /*
     * Validate as role
     */
    public static boolean asRole(String str) {
        return str.matches("music|.+|^$");
    }

    /*
     * Validate as String
     */
    public static boolean asString(String str) {
        log.debug("Testing as string: \"" + str + "\"");
        return str.matches("^$|.+");

    }

    /* DEPRECATED; Use the more specific URL matching methods instead
     * Validate as url
     */
    //http(s)?
    @Deprecated
    public static boolean asUrl(String str) {
        return false;
//        log.debug("str size: " + str.length());
//        log.debug("Testing url: \"" + str + "\"");
//        return str.matches("^$|((https|http)://(c|www|staging|c.sop|pli|qa-az|staging-az|prod-az|static|c-origin)?.(saavn|saavncdn|jiosaavn).com/(s|editorial|artists|.+)(/.+)?.(png|jpg)?(/.+)?)|((https|http)://(c|www|staging|c.sop|qa-az|staging-az|prod-az)?.(saavn|saavncdn).com/(s|editorial|artists|.+)(/.+)?.(png|jpg)?(/.+)?)|(https://graph.facebook.com/v2.9/.+/picture|https://static.saavncdn.com/_i/share-image.png)");
//        //return str.matches("(https|http)://(c|c.sop|staging|www|.+)?.(saavncdn|saavn).com/(s|editorial|artists|.+)/(.+/)?.(png|jpg)?/(s/radio/.+/.+)?|https://graph.facebook.com/v2.9/.+/.+");
//        //return str.matches("(https|http)://(c|c.sop|staging|www|.+)?.(saavncdn|saavn).com/(s|editorial|artists|.+)/(.+)?.(png|jpg)?");
    }

    /**
     * Verify as external third party URLs like fb, wiki, twitter
     * @param url
     * @return
     */
    public static boolean asExternalURL(String url) {
        log.debug("Testing as external url: \"" + url + "\"");
        return url.matches("^(https?):\\/\\/(www.)?[a-zA-Z0-9].+");
    }

    /**
     * Verify as a saavn CDN URL
     * @param url
     * @return
     */
    public static boolean asCDNURL(String url) {
        return url.matches("^$|((https|http)://(c|c.sop|pli|static|c-origin)?.(saavn|saavncdn|jiosaavn).com/(s|.+)(/.+)?.(png|jpg|mp4)?(/.+)?)" +
                "|(https:\\/\\/static.saavncdn.com\\/_i\\/share-image.png)" +
                "|(http:\\/\\/(staging|www|qa|d[0-9].+).(jio)?saavn.com\\/_i\\/3.0\\/artist-default-(music|film).png)" +
                "|(https:\\/\\/(staging|www|qa|d[0-9].+).(jio)?saavn.com\\/_i\\/3.0\\/user-default.png)");
    }

    /**
     * Verify as perma_url of any entity
     * @param url
     * @return
     */
    public static boolean asPermaURL(String url) {
        if (!url.isEmpty()) {
            return url.matches("^(https|http):\\/\\/(staging|www|qa|d[0-9].+).(jio)?saavn.com(\\/s|\\/p|\\/play)?\\/(song|album|featured|show(s)?|channel|radio|artist|playlist|mix)\\/.+$");
        }
        else
//          perma_url is empty, just verify it as a string and return it
            return asString(url);
    }

    /**
     * Validates jiotune preview links.
     * @param url
     * @return
     */
    public static boolean asVlinkURL(String url) {
        return url.matches("^(https|http):\\/\\/jiotunepreview.*");
    }

    /*
     * Validate as boolean
     */
    public static boolean asBoolean(String str) {
        log.debug("Testing as string boolean: \"" + str + "\"");
        return str.matches("^$|true|false|0|1|True|False|yes|no|Yes|No");
    }

    /*
     * Validate as primitive boolean
     */
    public static boolean asBoolean(boolean value) {
        log.debug("Testing as primitive boolean: \"" + value + "\"");
        if (value || !value) {
            return true;
        }
        else
            return false;
    }

    /*
     * Validate as language
     */
    public static boolean asLang(String str) {
        // HomeUtils.getSupportedLangs();
        // return HomeUtils.languages.contains(str);
        return str.matches(".+");
    }

    /*
     * Validate as Date
     */
    public static boolean asDate(String str) {
        log.debug("Testing as date: \"" + str + "\"");
        return (str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}") || str.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")
                || str.matches("[0-9]{1}-[0-9]{2}-[0-9]{4}"));
    }

    public static boolean asProduct(String str) {
        return str.matches("PRIME|prime|saavn.30day|SAAVN.30DAY");
    }

    public static boolean asEmail(String str) {
        return str.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
    }

    public static boolean asDateTime(String str) {
        return str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}");
    }

    public static boolean asGender(String str) {
        return str.matches("m|f|u");
    }
    public static boolean asSubtitleArtist(String str) {
        return str.matches("Artist.*[0-9]+.Fans");
    }

    /**
     * Will verify music languages from the list of music languages defined in the enum
     * @param str
     * @return
     */
    public static boolean asMusicLanguage(String str) {
        if(!str.isEmpty()) {
            try {
                musicLanguages ml = musicLanguages.valueOf(str.toUpperCase());
            }
            catch (IllegalArgumentException ex) {
                log.error("Not a valid music language: " + ex.getMessage());
                return false;
            }
            return true;
        }
        else
//          language field is empty, just verify it as a string and return it
            return asString(str);
    }

    /**
     * Will verify artist types like artist, singer, music director, lyricist, etc. Refer the enum class for more details
     * @param str
     * @return
     */
    public static boolean asArtistType(String str) {
        str = str.replaceAll(" ","_");
        try {
//          Sanitize the string to use _ instead of whitespaces
            artistTypes at = artistTypes.valueOf(str.toUpperCase());
        }
        catch (IllegalArgumentException ex) {
            log.error("Not a valid artist type: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public static boolean asSongRightsCode(String str) {
        return str.matches("0|1|2");
    }

    public static boolean asChannelSubtype(String str) {
        return str.matches("genre|mood|music_plus");
    }

	public static boolean isNonEmptyString(String str){
	    return str != null && !str.equals("") && !str.trim().isEmpty();
	}

	public static boolean asModulesSource(String source) {
        return source.matches("list|reco.getAlbumReco");
    }

    public static boolean asModulesPosition(int pos){
        return pos <= 10;
    }

    public static boolean asModulesScrollType(String scrollType){
        return scrollType.matches("SS_Basic|SS_Basic_Double|SS_Condensed|SS_Condensed_Double|SS_Widescreen|SS_Widescreen_Double|SS_Description|SS_Video|Cells_Standard|Cells_EditorsNote|Cells_Text|THREETILE_MENU");
    }

    public static boolean asProStatusType(String type) {
        return type.matches("pro | free | expired | trial");
    }

    public static void asAssortedEntity(LinkedHashMap entity, SoftAssert sa) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        String type = entity.get("type").toString();
        System.out.println("id: " + entity.get("id").toString());
        switch (type){
            case "playlist":
                PlaylistMini playlist = mapper.convertValue(entity, PlaylistMini.class);
                new PlaylistValidator().validate(playlist, sa);
                break;
            case "album":
                AlbumMiniObject album = mapper.convertValue(entity, AlbumMiniObject.class);
                new AlbumMiniValidator().validate(album, sa);
                break;
            case "episode":
                EpisodeMini episode = mapper.convertValue(entity, EpisodeMini.class);
                new EpisodeValidator().validate(episode, sa);
                break;
            case "song":
                Song song = mapper.convertValue(entity, Song.class);
                new SongValidator().validate(song, sa);
                break;
            case "artist":
                Artist artist = mapper.convertValue(entity, Artist.class);
                break;
        }
    }

    public static void asAssortedEntity(Response response,SoftAssert sa) {
        List<LinkedHashMap> entityList = response.jsonPath().getJsonObject("$");
        for(LinkedHashMap entity : entityList){
            Validate.asAssortedEntity(entity, sa);
        }
    }

}
