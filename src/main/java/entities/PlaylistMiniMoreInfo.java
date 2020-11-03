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
    @JsonProperty("fan_count")
    private String fanCount;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("isWeekly")
    private String isWeekly;
    @JsonProperty("reward")
    private String reward;
    @JsonProperty("artist_name")
    private String artist_name;
    @JsonProperty("entity_type")
    private String entity_type;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("share")
    private String share;
    @JsonProperty("language")
    private String language;


}
