package pojos.appGetLaunchData;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.getHomePageDataV2.HomePageDataModules;
import pojos.getTopShows.TopShows;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class AppGetLaunchData {
    @JsonProperty("app_version")
    private String appVersion;
    @JsonProperty("update_config")
    private UpdateConfig updateConfig;
    @JsonProperty("ab_test")
    private Object abTest;
    @JsonProperty("ef")
    private List<String> ef = null;
    @JsonProperty("ab_test_exp")
    private List<String> abTestExp = null;
    @JsonProperty("suggests")
    private List<Suggests> suggests = null;
    @JsonProperty("ping_server")
    private String pingServer;
    @JsonProperty("new_trending")
    private List<LinkedHashMap> newTrending = null;
    @JsonProperty("charts")
    private List<PlaylistMini> charts = null;
    @JsonProperty("new_albums")
    private List<AlbumMiniObject> newAlbums = null;
    @JsonProperty("top_playlists")
    private List<PlaylistMini> topPlaylists = null;
    @JsonProperty("top_shows")
    private TopShows topShows;
    @JsonProperty("browse_discover")
    private List<Channel> browseDiscover = null;
    @JsonProperty("radio")
    private Radio radio;
    @JsonProperty("top_searches")
    private List<TopSearch> topSearches;
    @JsonProperty("loginwall")
    private String loginwall;
    @JsonProperty("jiologinwall")
    private String jiologinwall;
    @JsonProperty("user_state")
    private UserState user_state;
    @JsonProperty("ads")
    private Ads ads;
    @JsonProperty("tag_mixes")
    private List<Mix> tagMixes = null;
    @JsonProperty("artist_recos")
    private List<RadioStation> artistRecos = null;
    @JsonProperty("city_mod")
    private List<LinkedHashMap> cityMod = null;
    @JsonProperty("greeting")
    private String greeting;
    @JsonProperty("last_page")
    private Boolean lastPage;
    @JsonProperty("modules")
    private HomePageDataModules modules;
    @JsonProperty("device_status")
    private String deviceStatus;
    @JsonProperty("global_config")
    private AppGetLaunchDataGlobalConfig global_config;


    private Map<String, List<Object>> topicPromos = new LinkedHashMap<>();
    @JsonAnySetter
    public void setTopicPromos(String key, List<Object> val){
        topicPromos.put(key,val);
    }

}
