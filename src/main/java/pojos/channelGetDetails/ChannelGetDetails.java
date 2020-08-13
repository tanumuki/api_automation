package pojos.channelGetDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ChannelMoreInfo;
import entities.Entity;
import entities.Playlist;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ChannelGetDetails extends Entity {

    @JsonProperty("more_info")
    private ChannelGetDetailsMoreInfo more_info;

    @JsonProperty("top_playlists")
    private List<Playlist> top_playlists;

    @JsonProperty("quiick_stations")
    private List<>

}
