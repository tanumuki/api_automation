package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PlaylistMiniMoreInfo {
    @JsonProperty("song_count")
    private String songCount;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("follower_count")
    private String followerCount;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("uid")
    private String uid;
//    @JsonProperty("song_count")
//    private String song_count;
}
