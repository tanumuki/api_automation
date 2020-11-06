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
import lombok.extern.slf4j.Slf4j;
import org.testng.asserts.SoftAssert;
import pojos.podcastsGetAll.PodcastCategory;
import validators.Artist.ArtistPageValidator;
import validators.genericValidators.*;
import validators.showGetHome.ShowDetailsValidator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        if (number >= 0 || number < 0) {
            return true;
        } else {
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
        } catch (NumberFormatException | NullPointerException ex) {
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
        return str.matches("^$|.+|.*[\u0000-\uFFEE]*");

    }

    /* DEPRECATED; Use the more specific URL matching methods instead
     * Validate as url
     */

    public static boolean asUpdateUrl(String str) {
        return str.matches("^(http|https):\\/\\/(staging|www).(saavn|jiosaavn).com/android_soft_upgrade.php");
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
        } else
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
        return str.matches("^$|true|false|0|1|True|False|yes|no|Yes|No|Success|success|Failure|failure");
    }

    /*
     * Validate as primitive boolean
     */
    public static boolean asBoolean(boolean value) {
        log.debug("Testing as primitive boolean: \"" + value + "\"");
        if (value || !value) {
            return true;
        } else
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
        boolean result = false;
        if (str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}\\s(IST)?") || str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-9]{2}:[0-9]{2}(:[0-9]{2})?"))
            result = true;
        return result;

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
        if (!str.isEmpty()) {
            String[] splits = str.split(",");
            if (splits.length > 1) {
                for (int i = 0; i < splits.length; i++) {
                    try {
                        musicLanguages ml = musicLanguages.valueOf(splits[i].toUpperCase());
                    } catch (IllegalArgumentException ex) {
                        log.error("Not a valid music language: " + ex.getMessage());
                        return false;
                    }
                }
            } else {
                try {
                    musicLanguages ml = musicLanguages.valueOf(splits[0].toUpperCase());
                } catch (IllegalArgumentException ex) {
                    log.error("Not a valid music language: " + ex.getMessage());
                    return false;
                }
            }

            return true;
        } else
//          language field is empty, just verify it as a string and return it
            return asString(str);
    }

    public static boolean asMusicLanguages(String lang) {
        return lang.matches("english|hindi|punjabi|tamil|telugu|marathi|gujarati|bengali|kannada|bhojpuri|malayalam|urdu|haryanvi|rajasthani|odia|assamese|spanish|latin|italian|french|portuguese|instrumental|croatian|korean|unknown");
    }

    /**
     * Will verify artist types like artist, singer, music director, lyricist, etc. Refer the enum class for more details
     * @param str
     * @return
     */
    public static boolean asArtistType(String str) {
        str = str.replaceAll(" ", "_");
        try {
//          Sanitize the string to use _ instead of whitespaces
            artistTypes at = artistTypes.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException ex) {
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

    public static boolean isNonEmptyString(String str) {
        return str != null && !str.equals("") && !str.trim().isEmpty();
    }

    public static boolean asModulesSource(String source) {
        return source.matches("list|reco.getAlbumReco|client|charts|new_trending|artist_recos|new_albums|city_mod|promo:vx:data:[0-9]+|top_playlists|tag_mixes|made_for_you|base_menu|new_and_trending|podcast_home_module_[0-9]+");
    }

    public static boolean asModulesPosition(int pos) {
        return pos <= 15;
    }

    public static boolean asModulesScrollType(String scrollType) {
        return scrollType.matches("SS_Basic|SS_BASIC|SS_Basic_Double|SS_Condensed|SS_CONDENSED|SS_Condensed_Double|SS_Widescreen|SS_Widescreen_Double|SS_Description|SS_Video|Cells_Standard|CELLS_STANDARD|Cells_EditorsNote|Cells_Text|THREETILE_MENU|SS_CAROUSEL_DESCRIPTION|SS_MULTIPLEITEM");
    }

    public static boolean asProStatusType(String type) {
        return type.matches("pro|free|expired|trial");
    }

    public static void asAssortedEntity(LinkedHashMap entity, SoftAssert sa) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        String type = entity.get("type").toString();
        System.out.println("id: " + entity.get("id").toString());
        switch (type) {
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
                new ArtistPageValidator().validateAll(artist, sa);
                break;
            case "mix":
                Mix mix = mapper.convertValue(entity, Mix.class);
                new MixValidator().validate(mix, sa);
                break;
            case "show":
                ShowDetails show = mapper.convertValue(entity, ShowDetails.class);
                new ShowDetailsValidator().validate(show, sa);
                break;
            case "category":
                PodcastCategory category = mapper.convertValue(entity, PodcastCategory.class);
                break;
        }
    }

    public static void asAssortedEntity(Response response, SoftAssert sa) {
        List<LinkedHashMap> entityList = response.jsonPath().getJsonObject("$");
        for (LinkedHashMap entity : entityList) {
            Validate.asAssortedEntity(entity, sa);
        }
    }

    public static void asAssortedEntity(List<LinkedHashMap> entityList, SoftAssert sa) {
        if (entityList != null && entityList.size() > 0) {
            for (LinkedHashMap entity : entityList) {
                Validate.asAssortedEntity(entity, sa);
            }
        }
    }

    public static boolean asEntityType(String entityType) {
        return entityType.matches("artist|mix|playlist|album|song|channel|radio_station|episode|show|category");
    }

    public static boolean asCategoryType(String categoryType) {
        return categoryType.matches("static|user_defined");
    }

    public static void asChartsAndPlaylists(List<PlaylistMini> plObj, SoftAssert sa) {
        if (plObj != null && plObj.size() > 0) {
            for (PlaylistMini pl : plObj) {
                new PlaylistMiniValidator().validate(pl, sa);
            }
        }
    }

    public static void asTopicsPromos(Map<String, List<Object>> map, SoftAssert sa) {
        for (String key : map.keySet()) {
            System.out.println("key: " + key);
            for (Object entity : map.get(key)) {
                LinkedHashMap entityMap = (LinkedHashMap) entity;
                Validate.asAssortedEntity(entityMap, sa);
            }

        }
    }

    public static void asArtistRecos(List<RadioStation> artistRecos, SoftAssert sa) {
        if (artistRecos != null && artistRecos.size() > 0) {
            for (RadioStation rs : artistRecos) {
                new RadioStationValidator().validate(rs, sa);
            }
        }
    }

    public static void asMixes(List<Mix> mixes, SoftAssert sa) {
        if (mixes != null && mixes.size() > 0) {
            for (Mix mix : mixes) {
                new MixValidator().validate(mix, sa);
            }
        }
    }

    public static void asBrowseAndDiscover(List<Channel> channels, SoftAssert sa) {
        if (channels != null && channels.size() > 0) {
            for (Channel channel : channels) {
                new ChannelValidator().validate(channel, sa);
            }
        }

    }

    public static void asFeaturedStations(Radio radio, SoftAssert sa) {
        if (radio != null) {
            List<RadioStation> featuredStations = radio.getFeatured_stations();
            for (RadioStation station : featuredStations) {
                new RadioStationValidator().validate(station, sa);
            }
        }

    }

    public static boolean asReceiptInvoiceId(String invoiceId) {
        return invoiceId.matches("PRO\\/[0-9]{4}\\/[0-9]{6}");
    }

}
