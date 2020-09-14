package pojos.channelGetDetailsPojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class ChannelGetDetails extends Entity {


    @JsonProperty("top_playlists")
    private List<PlaylistMini> topPlaylists = null;
    @JsonProperty("quick_stations")
    private List<RadioStation> quickStations = null;
    @JsonProperty("top_songs")
    private List<Song> topSongs = null;
    @JsonProperty("list")
    private String list;
    @JsonProperty("more_info")
    private ChannelGetDetailsMoreInfo moreInfo;

    @JsonProperty("modules")
    private ChannelGetDetailsModules modules;


}
