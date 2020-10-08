package pojos.channelGetDetailsPojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ModuleWithViewMoreArray;
import entities.ModulesData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter

public class ChannelGetDetailsModules {
    @JsonProperty("editors_note")
    private ModuleWithViewMoreArray editorsNote;
    @JsonProperty("top_playlists")
    private ModuleWithViewMoreArray topPlaylists;
    @JsonProperty("quick_stations")
    private ModuleWithViewMoreArray quickStations;
    @JsonProperty("top_songs")
    private ModuleWithViewMoreArray topSongs;
}
