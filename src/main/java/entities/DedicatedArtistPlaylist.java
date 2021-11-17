package entities;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.MatchingMatch.MatchingMatchData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@Getter
@Setter
public class DedicatedArtistPlaylist {

//    @JsonProperty("459320")
//    private List<DedicatedArtistPlaylistMini> playlistMiniList;

    private Map<String, PlaylistMini[]> artistID = new HashMap<>();
    @JsonAnySetter
    public void setProviders(String key, PlaylistMini[] val){
        artistID.put(key, val);
    }
}


