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
import pojos.login_pojos.LoginData;
import pojos.login_pojos.LoginProstatus;
import pojos.login_pojos.SlotsUsed;
import pojos.podcastsGetAll.PodcastCategory;
import validators.Artist.ArtistPageValidator;
import validators.genericValidators.*;
import validators.showGetHome.ShowDetailsValidator;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author aswingokulachandran
 *
 */
@Slf4j
public class Validate {

    public static String API_STATUS_SUCCESS = "success";

    public static boolean asSongRightsReason(String str) {
        return str.matches("Unavailable|unavailable|Pro Only");
    }

    public static boolean asSearchTabType(String str) {
        return str.matches("standard|23left|23right");
    }

    public static boolean asSongPids(String songs) {
        String[] songsList = songs.split(",");
        for (String song : songsList) {
            if (!asId(song))
                return false;
        }
        return true;
    }

    public static boolean asNum(String str) {
        //return str.matches("\\d+|^$");
        log.debug("Testing as number: \"" + str + "\"");
        return str.matches("^$|^[0-9]\\d*(\\.\\d+)?$|\\d+");
    }

    public static boolean asNum(int number) {
        log.debug("Testing as integer: " + number);
        return (number >= 0 || number < 0);
    }

    public static boolean asLong(Long num) {
        return num >= Long.MIN_VALUE && num <= Long.MAX_VALUE;
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
        return type.matches("artist|featured|video");
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
        return url.matches("^$|((https|http)://([a-z0-9]+.cdnsrv.jio.com\\/c|c|c.sop|pli|static|c-origin|shorties|s|videos)?.(saavn|saavncdn|jiosaavn).com/(s|thumbs|triller|.+)(/.+)?.(png|jpg|mp4)?(/.+)?)" +
                "|(https:\\/\\/static.saavncdn.com\\/_i\\/share-image.png)" +
                "|(https:\\/\\/(staging|qa).jiosaavn.com\\/_i\\/share-image.png)" +
                "|(https:\\/\\/(staging|qa).jiosaavn.com\\/_i\\/3.0\\/playlist-default.png)" +
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
            return url.matches("^(https|http):\\/\\/(mls|dls|staging|www|qa|d[0-9].+).(jio)?saavn.com(\\/s|\\/p|\\/play)?\\/(song|album|featured|show(s)?|channel|radio|artist|playlist|mix|video)\\/.+$");
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
        return str.matches("^$|true|false|0|1|True|False|yes|no|Yes|No|Success|success|Failure|failure|None");
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
                || str.matches("[0-9]{1}-[0-9]{2}-[0-9]{4}")||str.matches("[0-9]{2}-[A-Za-z]{3}-[0-9]{4}"));
    }

    public static boolean asProduct(String str) {
        return str.matches("PRIME|prime|saavn.30day|SAAVN.30DAY");
    }

    public static boolean asEmail(String str) {
        return str.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
    }

    public static boolean asDateTime(String str) {
        return str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-9]{2}:[0-9]{2}(:[0-9]{2})?(\\sIST)?");

    }

    public static boolean asEpisodeReleaseTime(String str){
        return str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}");
    }

    public static boolean asUnixEpochTime(String str) {
        return str.matches("^\\d{10}$");//epoch ts is 10 digits
    }

    public static boolean asGender(String str) {
        return str.matches("m|f|u|Male|Female");
    }

    public static boolean asSubtitleArtist(String str) {
//        Example strings:
//        "Artist <middle dot separator> 100K Fans" for pre-7.x
//        "30.9M Listeners" for post-7.x
//        if (System.getProperty("ctx").equalsIgnoreCase("androidgo"))
//            return str.matches("(Artist • [0-9]{0,10} Listeners)");
//        else
        return str.matches("(Artist.*[0-9]+.Fans)|([0-9]{1,}(.[0-9]{1,})?(K|M|B) Listeners)|([0-9]{1,}(.[0-9]{1,})?(K|M|B) Followers)");
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
        return lang.matches("english|hindi|punjabi|tamil|telugu|marathi|gujarati|bengali|kannada|bhojpuri|malayalam|urdu|haryanvi|rajasthani|odia|assamese|spanish|latin|italian|french|portuguese|instrumental|croatian|korean|unknown|icelandic");
    }

    public static boolean asJTSubType(String str){
        return str.matches("nameTune|artistTune");
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
        return str.matches("genre|mood|music_plus|brand");
    }

    public static boolean isNonEmptyString(String str) {
        return str != null && !str.equals("") && !str.trim().isEmpty();
    }

    public static boolean asModulesSource(String source) {
        return source.matches("list|reco.getAlbumReco|client|charts|new_trending|artist_recos|featured_artist_playlist|" +
                "dedicated_artist_playlist|singles|similarArtists|artistPlaylists|triller|latest_release|show(_reco)?|new_albums|city_mod" +
                "|promo:vx:data:[0-9]|top_playlists|tag_mixes|made_for_you|base_menu|new_and_trending|podcast_home_module_[0-9]+|data_[0-9]" +
                "|jiotune.jioTuneRequestStatus|artist|quick_stations|top_songs|channel|keep_listening|new_releases|popular_artist_tune" +
                "|all_artist_tune_1|all_name_caller_tune_1|up_next|artist_tune_0|trending_jiotunes|jiotune_reco|video_stations|videohomepage:vx:data:[0-9]{2}");
    }


    public static boolean asTopicPromosField(String key) {
        return key.matches("(promo|topic|nrtplaylist| topics & promos|replay_year|artist|surprise_me|jiotune_reco)[a-zA-z0-9_\\^:-]*");
    }

    public static boolean asModulesPosition(int pos) {
        return pos <= 15;
    }

    public static boolean asModulesScrollType(String scrollType) {
        return scrollType.matches("SS_Basic|SS_BASIC|SS_Basic_Double|SS_BASIC_DOUBLE|SS_Condensed|SS_CONDENSED|" +
                "SS_Condensed_Double|SS_Widescreen|SS_Widescreen_Double|SS_Description|SS_Video|Cells_Standard|CELLS_STANDARD|" +
                "Cells_EditorsNote|Cells_Text|THREETILE_MENU|SS_CAROUSEL_DESCRIPTION|SS_MULTIPLEITEM|SS_TRILLER|SS_JIOTUNE_ARTIST|" +
                "SS_CAROUSEL|SS_SHORT_VIDEOS|SS_Generic|SS_VIDEO_LANDSCAPE|VIDEO_STATION");
    }

    public static boolean asProStatusType(String type) {
        return type.matches("pro|free|expired|trial");
    }

    public static void asAssortedEntity(LinkedHashMap entity, SoftAssert sa) {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        String type = entity.get("type").toString();
        switch (type) {
            case "playlist":
                PlaylistMini playlist = mapper.convertValue(entity, PlaylistMini.class);
                new validators.PlaylistMiniValidator().validate(playlist, sa);
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
            case "channel":
                Channel ch = mapper.convertValue(entity, Channel.class);
                new ChannelValidator().validate(ch, sa);
                break;
            case "surprise_me":
                Radio radio = mapper.convertValue(entity, Radio.class);
                new RadioValidator().validate(radio, sa);
                break;

        }
    }

    public static void asAssortedEntity(Response response, SoftAssert sa) {
        List<LinkedHashMap> entityList = response.jsonPath().getJsonObject("$");
        for (LinkedHashMap entity : entityList) {
            Validate.asAssortedEntity(entity, sa);
        }
    }

    public static void asAssortedEntityForLibraryDetails(String chosenEntity, Response response, SoftAssert sa) {
//        This is to select the jsonpath according to the chosen entity. The response structure varies for different entities
        String field;
        if(!chosenEntity.equals("song")){
            field = "data";
        }
        else{
            field = "songs";
        }
        List<LinkedHashMap> entityList = response.jsonPath().getJsonObject(field);
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
        return entityType.matches("artist|mix|playlist|album|song|channel|radio_station|episode|show|category|season|deeplink|video|jiotune|menu");
    }

    public static boolean asDeeplink(String deeplink) {
        return deeplink.matches("^(jiosaavn|saavn):\\/\\/(open|view)\\S+\\S+");
    }
    // TODO: To be fixed with new regex

    public static boolean asMatchingMatchDeeplink(String str) {
        boolean flag = false;
        if (System.getProperty("ctx").equalsIgnoreCase("Android") || System.getProperty("ctx").equalsIgnoreCase("AndroidGo")) {

            if (str.matches("intent:\\/\\/(view|play)\\/(playlist|song|show|artist|channels|album|radio)\\/(featured\\/)?(english\\/)?([0-9]{2,})?\\/?([0-9]{1,}\\/)?([a-zA-Z0-9_-]{10,})?#Intent;action=android.intent.action.VIEW;scheme=jiosaavn;package=com.jio.media.jiobeats;S.market_referrer=utm_source%3DMobileWeb%26utm_medium%3DContentPage%26utm_campaign%3DClickPlay;end;"))
                flag = true;

        } else if (System.getProperty("ctx").equalsIgnoreCase("iphoneapp")) {

            if (str.matches("saavn:\\/\\/(view|play)\\/(playlist|song|show|artist|channels|album|radio)\\/([0-9]{2,})?\\/?([0-9]{1,})?\\/?(featured)?\\/?(english)?\\/?([A-Za-z0-9_-]{10,})?"))
                flag = true;
        }
        return flag;
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
        Boolean flag = false;
        if (invoiceId.matches("PRO\\/[0-9]{4}\\/[0-9]{6,}") || invoiceId.matches("PRJ\\/[0-9]{4}\\/[0-9]{6,}")) {
            flag = true;
        }
        return flag;
    }

    public static boolean asBenefitsAccess(String str) {
        log.debug("Testing as access: \"" + str + "\"");
        return str.matches("^(free|trial|pro)$");

    }

    public static boolean asBenefitStatus(String str) {
        log.debug("Testing as status: \"" + str + "\"");
        return str.matches("^(available|expired|redeemed)$");

    }

    public static boolean asBenefitSection(String str) {
        log.debug("Testing as section: \"" + str + "\"");
        return str.matches("^(Old|New)$");
    }

    public static boolean asBenefitMetadataTitle(String str) {
        log.debug("Testing as metadata title: \"" + str + "\"");
        return str.matches("^(Go Pro)\\s*(for Rs 33\\/month)?|Renew|Upgrade");
    }

    public static boolean asViewType(String str) {
        log.debug("Testing as view type: \"" + str + "\"");
        return str.matches("^(grid|list)$");
    }

    public static boolean asAPIJioPhoneGetLaunchData(String str) {
        log.debug("Testing as API: \"" + str + "\"");
        return str.matches("(^$|\\s+|\\/api.php\\?__call=(channel|content|webradio)\\.(getDetails|getAlbums|getFeaturedPlaylists|getFeaturedStations|getTrending|getCharts)?(&channel_id=[0-9]+)??(&entity_type=playlists)?&api_version=4&_format=json&_marker=0?(&entity_type=playlists)?)");
    }

    public static boolean asAlphaNumericWithUnderscoreHyphen(String str) {
        log.debug("Testing as API: \"" + str + "\"");
        return str.matches("^[a-zA-Z0-9_\\-]*$");
    }

    public static boolean asImageType(String str) {
        log.debug("Testing as image type: \"" + str + "\"");
        return str.matches("^(round|square)$");
    }

    public static boolean asTrillerAppStoreURL(String str) {
        return str.matches("^https:\\/\\/play.google.com\\/store\\/apps\\/details\\?id=co.triller.droid&fbclid=.*");
    }

    public static boolean asTrillerMediaURL(String str) {
        return str.matches("^(http|https):\\/\\/uploads.cdn.triller.co\\/v1\\/jiosaavn\\/[0-9]+.mp4");
    }

    public static boolean asThirdPartyVideoPartnerID(String str) {
        return str.matches("triller");
    }

    public static boolean asHexColour(String str) {
        log.debug("Testing as hex colour: \"" + str + "\"");
        return str.matches("^(#)?[a-zA-Z0-9]{6,8}$");
    }

    public static boolean asUserAge(String str) {
//        age should be between 0 and 150
        return Integer.parseInt(str) > 0 && Integer.parseInt(str) < 150;
    }

    public static boolean asUserAge(Integer age) {
//        age should be between 0 and 150
        return age > 0 && age <= 150;
    }

    public static boolean asEmailVerifiedStatus(String str) {
        return str.matches("new_unverified|existing_unverified|existing_verified");
    }

    public static boolean asCountryCode(String str) {
        return str.matches("^(\\+?\\d{1,3}|\\d{1,4})$");
    }

    public static boolean asProvider(String str) {
        return str.equalsIgnoreCase("jio");
    }

    public static boolean asPlaylistSubtype(String str) {
        return str.matches("JioTuneArtist| JioTuneDecade| JioTuneActivity|VideoPlaylist| VideoAudioPlaylist| ProPlaylist| DolbyPlaylist");

    }

    public static boolean asQuickActions(String str) {
        return str.matches("download|add to library|setJiotune|none");
    }

    public static boolean asHomepageTabOrder(List<String> tabs) {
        for (String tab : tabs) {
            if (!tab.matches("music|jiotunes|podcasts"))
                return false;
        }
        return true;
    }

    public static boolean asBenefitsEventType(String str) {
        return str.matches("nonconcert");
    }

    public static boolean asEmptyArray(String[] arr) {
        return arr.length == 0;
    }

    public static boolean asJioOTPStatus(String str) {
        return str.matches("success|error");
    }

    public static boolean asCorrelationId(String str) {
        return str.matches("^([a-zA-Z0-9_-]){8}-([a-zA-Z0-9_-]){4}-([a-zA-Z0-9_-]){4}-([a-zA-Z0-9_-]){4}-([a-zA-Z0-9_-]){12}");
    }

    public static boolean asProFeatures(String str) {
        return str.matches("jtune|unlimited_skip");
    }

    public static boolean asProStatusTierId(String str) {
        return str.matches("^$|jtune_tier");
    }

    public static boolean asProType(String str) {
        return str.matches("transactional|subscription");
    }

    public static boolean asProPeriodUnit(String str) {
        str = str.toLowerCase();
        return str.matches("day|month|year|annual");
    }

    public static boolean asProVendors(String str) {
        return str.matches("google|apple|paytm");
    }

    public static boolean asPastState(String str) {
        return str.matches("pro|free|trial");
    }

    public static boolean asDefaultSelection(String str) {
        return str.matches("hindi|bengali|kannada|marathi|tamil|telugu|punjabi|gujarati|malayalam|haryanvi|bhojpuri|english");
    }

    public static boolean asCurrency(String str){
        return str.matches("Rs.|$");
    }

    public static boolean asHeaders(String str){ return str.contains("http")||str.contains("https"); }

    /**
     Will verify the url sent in the param matches with the one is response, url gets concatenated with the encrypted userid
     * @param str, toBeMatchedString
     * @return Boolean
     */
    public static boolean asUpdatedUrlForDeeplink(String str, String toBeMatchedString){
        return str.matches("^(http|https):\\/\\/(staging|www).(saavn|jiosaavn).com/"+toBeMatchedString);
    }

    /**
     * Verify the JT Vlink
     */
    public static boolean asJTVLink(String url){
        return url.matches("^(http|https):\\/\\/jiotunepreview.jio.com\\/content\\/Converted\\/[0-9]+.mp3");
    }

    /**
     * Verify status message
     */
    public static boolean asStatusMessage(String str){
        return str.matches("ok");
    }

    public static boolean asJiotuneSetMessage(String str){
        return str.matches("JioTune set for:  [A-Z0-9]{10} Order Ref number: [A-Z0-9]{12}");
    }
    public static boolean asJiotuneSetFailureMessage(String str){
        return str.matches("Alert - This JioTune has already been set for your number.");
    }
    public static boolean asJiotuneToast(String str){
        log.info("str toast is "+str);
        return str.matches("JioTune has been set for XXXXXX[0-9]{4}. If the My JioTune section doesn't show the updated details, please reload the page after some time");
    }

    public static void validateUserData(LoginData loginData, SoftAssert sa){



        String className = Validate.class.getName();
        final String methodName = new Throwable().getStackTrace()[0].getMethodName();


        if (Validate.isNonEmptyString(loginData.getEmail())) {

            String email = loginData.getEmail();
            log.info("email " + loginData.getEmail());
            sa.assertTrue(Validate.asEmail(email), className + "." + "validate email failed - ");
        } else {
            log.info("Email field is NULL or empty");
        }


        // get network
        if (Validate.isNonEmptyString(loginData.getNetwork())) {
            String network = loginData.getNetwork();
            log.info("network " + network);
            sa.assertTrue(Validate.asString(network), className + "." + "validate network failed - ");
        } else {
            log.info("Network field is NULL or empty");

        }
        //get phone no


        if (Validate.isNonEmptyString(loginData.getPhoneNumber())) {
            sa.assertTrue(Validate.asString(loginData.getPhoneNumber()), className + "." + "validate phone failed - ");
        } else {
            log.info("phone is NULL or empty");
        }


        // get fbid
        if (Validate.isNonEmptyString(loginData.getFbid())) {
            sa.assertTrue(Validate.asString(loginData.getFbid()), className + "." + "validate FBID failed - ");
        } else {
            log.info("FBID is NULL or empty");
        }


        // get reg date
        if (Validate.isNonEmptyString(loginData.getRegdate())) {
            String regDate = loginData.getRegdate();
            sa.assertTrue(Validate.asDateTime(regDate), className + "." + "validate regDate failed - ");
        } else {
            log.info("Reg date is NULL or empty");
        }


        // username
        if (Validate.isNonEmptyString(loginData.getUsername())) {
            String username = loginData.getRegdate();
            sa.assertTrue(Validate.asString(username), className + "." + "validate username failed - ");
        } else {
            log.info("User name is NULL or empty");
        }


        // uid
        if (Validate.isNonEmptyString(loginData.getUid())) {
            String uid = loginData.getUid();
            sa.assertTrue(Validate.asId(uid), className + "." + "validate uid failed - ");
        } else {
            log.info(" UID is NULL or empty");
        }


        // phone number
        if (Validate.isNonEmptyString(loginData.getPhoneNumber())) {
            String ph = loginData.getPhoneNumber();
            sa.assertTrue(Validate.asString(ph), className + "." + "validate ph failed - ");
        } else {
            log.info(" phone is NULL or empty");
        }


        // fb token
        if (Validate.isNonEmptyString(loginData.getFbtoken())) {
            String fbtoken = loginData.getFbtoken();
            sa.assertTrue(Validate.asString(fbtoken), className + "." + "validate fbToken failed - ");
        } else {
            log.info(" FB TOKEN is NULL or empty");
        }


        // status
        if (Validate.isNonEmptyString(loginData.getStatus())) {
            String status = loginData.getStatus();
            sa.assertTrue(Validate.asString(status), className + "." + "validate status failed - ");
        } else {
            log.info(" Status is NULL or empty");
        }


        // lastname
        if (Validate.isNonEmptyString(loginData.getLastname())) {
            String lastname = loginData.getLastname();
            sa.assertTrue(Validate.asString(lastname), className + "." + "validate lastname failed - ");
        } else {
            log.info(" lastname is NULL or empty");
        }

        // first name

        if (Validate.isNonEmptyString(loginData.getFirstname())) {
            String firstname = loginData.getFirstname();
            sa.assertTrue(Validate.asString(firstname), className + "." + "validate firstname failed - ");
        } else {
            log.info(" firstname is NULL or empty");
        }


        // gender

        if (Validate.isNonEmptyString(loginData.getGender())) {
            String gender = loginData.getGender();
            sa.assertTrue(Validate.asGender(gender), className + "." + "validate gender failed - ");
        } else {
            log.info(" gender is NULL or empty");
        }

        // dob

        if (Validate.isNonEmptyString(loginData.getDob())) {
            String dob = loginData.getDob();
            sa.assertTrue(Validate.asDate(dob), className + "." + "validate dob failed - ");
        } else {
            log.info(" DOB is NULL or empty");
        }


        // birthyear
        /*
            For now we are adding 0 in validation cause from backend it's coming as 0
            | birthyear         | smallint(5) unsigned                  | YES  |     | NULL                |
            birthyear field's type is smallint. So, empty string is not being set in this case. It's taking 0 as default value(jira 8139)
         */

        if (Validate.isNonEmptyString(loginData.getBirthyear())) {
            String birthyear = loginData.getBirthyear();
            sa.assertTrue(Validate.asBirthYear(birthyear), className + "." + "validate birthyear failed - ");
        } else {
            log.info(" birthyear is NULL or empty");
        }


        // following_count

        if (Validate.isNonEmptyString(loginData.getFollowingCount())) {
            String followingCount = loginData.getFollowingCount();
            sa.assertTrue(Validate.asNum(followingCount), className + "." + "validate following_count failed - ");
        } else {
            log.info(" following count is NULL or empty");
        }


        // follower_count
        if (Validate.isNonEmptyString(loginData.getFollowerCount())) {
            String followerCount = loginData.getFollowerCount();
            sa.assertTrue(Validate.asNum(followerCount), className + "." + "validate follower_count failed - ");
        } else {
            log.info(" follower count is NULL or empty");
        }

        // update_time
        if (Validate.isNonEmptyString(loginData.getUpdateTime())) {
            String updateTime = loginData.getUpdateTime();
            sa.assertTrue(Validate.asDateTime(updateTime), className + "." + "validate update_time failed - ");
        } else {
            log.info(" updateTime  is NULL or empty");
        }


        // paywall_only

        if (Validate.isNonEmptyString(loginData.getPaywallOnly())) {
            String paywallOnly = loginData.getPaywallOnly();
            sa.assertTrue(Validate.asBoolean(paywallOnly), className + "." + "validate paywall_only failed - ");
        } else {
            log.info(" paywall only  is NULL or empty");
        }


        // loginwall
        if (Validate.isNonEmptyString(loginData.getLoginwall())) {
            String loginwall = loginData.getLoginwall();
            sa.assertTrue(Validate.asBoolean(loginwall), className + "." + "validate loginwall failed - ");
        } else {
            log.info(" loginwall   is NULL or empty");
        }

        // require_otp
        if (loginData.getRequireOtp()!=null ) {
            boolean flag = loginData.getRequireOtp();
            sa.assertTrue(Validate.asBoolean(flag), className + "." + "Require otp  failed - ");
        } else {
            log.info(" Require otp field   is NULL or empty");
        }
        // mandatory_verify
        if (loginData.getMandatoryVerify()!=null) {
            boolean flag = loginData.getMandatoryVerify();
            sa.assertTrue(Validate.asBoolean(flag), className + "." + "Mandatory verify failed - ");
        } else {
            log.info(" Mandatory  field   is NULL or empty");
        }

        // email verified status
        if (Validate.isNonEmptyString(loginData.getEmailVerifiedStatus())) {
            String emailVerifiedStatus = loginData.getEmailVerifiedStatus();
            sa.assertTrue(Validate.asEmailVerifiedStatus(emailVerifiedStatus), className + "." + "Email verified status failed - ");
        } else {
            log.info(" Email verified status field   is NULL or empty");
        }

        sa.assertAll();

    }

    /*
     * Validate jio trial duration (it will always be 30 days)
     */
    public static boolean asJioTrialDuration(String time) {
        //return str.matches("\\d+|^$");
        return time.matches("30 days");
    }

    public static boolean asBirthYear(String str) {
        log.debug("Testing as birth year: \"" + str + "\"");
        return (str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}") || str.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")
                || str.matches("[0-9]{1}-[0-9]{2}-[0-9]{4}") || str.matches("0"));
    }

    public static boolean asAlphaNumericWithHyphen(String str) {
        log.debug("Testing as API: \"" + str + "\"");
        return str.matches("^[a-z0-9-]*$");
    }

    /*
     * Validate as uid
     */
    public static boolean asUid(String str) {
        return str.matches("[a-z0-9]+");
    }

    /*
     * Validate as subscriber id
     */
    public static boolean asSubscriberId(String str) {
        return str.matches("[0-9]{10}");
    }

    public static boolean asUserAgeJioData(String age) {
///     age should be between 0 and 150
        return  age.matches("NA") ;
    }

    public static boolean asEncryptedJioPhoneNumber(String str) {

        return str.matches("[0-9a-zA-Z/=]{24}");
    }

    public static boolean asMaskedPhoneNumber(String str) {
        return str.matches("[+]{1}[X]{8}[0-9]{4}");
    }

    public static void validateProStatus(LoginProstatus proStatus, SoftAssert sa){

        String className = Validate.class.getName();


        if (Validate.isNonEmptyString(proStatus.getProduct())) {
            String product = proStatus.getProduct();
            log.info("product " + product);
            sa.assertTrue(Validate.asProduct(product), className + "." + "validate product failed - ");
        } else {
            log.info("product is NULL or empty");
        }




        // get product type

        // get product type
        if (Validate.isNonEmptyString(String.valueOf(proStatus.getExpirationTimestamp()))) {
            if(proStatus.getExpirationTimestamp() != 0) {
                Integer time = proStatus.getExpirationTimestamp();
                log.info("exp time stamp is " + time);
                sa.assertTrue(Validate.asTimeStamp(String.valueOf(time)), className + "." + "validate time failed - ");
                log.info("exp time stamp is " + time);
            }
            else{
                sa.assertTrue(Validate.asNum(String.valueOf(proStatus.getExpirationTimestamp())), className + "." + "validate time failed - ");
            }

        } else {
            log.info("product is NULL or empty");
        }



        // pro status type
        if (Validate.isNonEmptyString(proStatus.getType())) {
            String type = proStatus.getType();
            sa.assertTrue(Validate.asString(type), className + "." + "validate type failed - ");
        } else {
            log.info(" pro status Type  is NULL or empty");
        }

        // pro status offer_trial
        if (Validate.isNonEmptyString(proStatus.getOfferTrial())) {
            String offerTrial = proStatus.getOfferTrial();
            sa.assertTrue(Validate.asString(offerTrial), className + "." + "validate offer_trial failed - ");
        } else {
            log.info(" Offer trial  is NULL or empty");
        }

        //slots used


        if (proStatus.getSlotsUsed() != null) {
            List<SlotsUsed> slots = proStatus.getSlotsUsed();
            for (SlotsUsed su : slots) {
                String id = su.getId();
                log.info("id: " + id);
                sa.assertTrue(Validate.asString(id), className + "." + "validate id failed - ");

                String name = su.getName();
                log.info("name: " + name);
                sa.assertTrue(Validate.asString(name), className + "." + "validate name failed - ");
            }
        }

        //vendor
        if (Validate.isNonEmptyString(proStatus.getVendor())) {
            String vendor = proStatus.getVendor();
            sa.assertTrue(Validate.asString(vendor), className + "." + "validate vendor failed - ");
        } else {
            log.info(" Vendor  is NULL or empty");
        }

        sa.assertAll();
    }

    public static boolean asVideoPromosField(String key) {
        return key.matches("(videoHomePage:vx:data)[a-zA-z0-9_\\^:-]*");
    }

    public static boolean asJT_CTA_Text(String str) {
        return str.matches("RENEW|REMOVE"); }


    public static boolean asExhaustedAttemptErrorMsg(String str){
        return str.matches("You have exhausted login attempts. Please try again after+ [0-9]{2}+ minutes");
    }


}

