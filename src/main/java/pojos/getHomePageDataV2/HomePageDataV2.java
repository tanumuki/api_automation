package pojos.getHomePageDataV2;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.getTopShows.TopShows;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class HomePageDataV2 {

    @JsonProperty("last_page")
    private Boolean lastPage;

    @JsonProperty("new_trending")
    private List<LinkedHashMap> newTrending = null;

    @JsonProperty("charts")
    private List<PlaylistMini> charts = null;

    @JsonProperty("new_albums")
    private List<AlbumMiniObject> newAlbums = null;

    @JsonProperty("top_playlists")
    private List<PlaylistMini> topPlaylists = null;

    @JsonProperty("genres")
    private List<Genre> genres = null;

    @JsonProperty("top_shows")
    private TopShows topShows;

    @JsonProperty("browse_discover")
    private List<Channel> browseDiscover = null;

    @JsonProperty("radio")
    private Radio radio;

    @JsonProperty("user_state")
    private UserState userState;

    @JsonProperty("suggests")
    private Object suggests = null;

    @JsonProperty("mixes")
    private List<Mix> mixes = null; //mix type

    @JsonProperty("tag_mixes")
    private List<Mix> tagMixes = null; //mix type

    @JsonProperty("favorites")
    private List<LinkedHashMap> favorites = null; //favorite type

    @JsonProperty("artist_recos")
    private List<RadioStation> artistRecos = null;

    @JsonProperty("city_mod")
    private List<LinkedHashMap> cityMod = null;

    @JsonProperty("modules")
    private HomePageDataModules modules;

    @JsonProperty("greeting")
    private String greeting;

    @JsonProperty("most_popular_trillers")
    private List<Song> most_popular_trillers;
    @JsonProperty("most_popular_artist_trillers")
    private List<Song> most_popular_artist_trillers;

    private Map<String, List<LinkedHashMap>> topicPromos = new LinkedHashMap<>();
    @JsonAnySetter
    public void setTopicPromos(String key, List<LinkedHashMap> val){
        topicPromos.put(key,val);
    }




}
