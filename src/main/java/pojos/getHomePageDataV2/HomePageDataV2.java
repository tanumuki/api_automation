package pojos.getHomePageDataV2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.getTopShows.TopShows;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class HomePageDataV2 {

    @JsonProperty("last_page")
    private Boolean lastPage;
    @JsonProperty("new_trending")
    private List<Object> newTrending = null;
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
    private List<Object> suggests = null;
}
