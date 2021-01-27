package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private List<String> artist_name;
    @JsonProperty("entity_type")
    private String entity_type;
    @JsonProperty("entity_sub_type")
    private String entity_sub_type;
    @JsonProperty("video_available")
    private String video_available;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("share")
    private String share;
    @JsonProperty("language")
    private String language;
    @JsonProperty("release_date")
    private String release_date;
    @JsonProperty("description")
    private String description;

    //Jiophone fields
    @JsonProperty("primary_artists")
    private String primaryArtists;
    @JsonProperty("singers")
    private String singers;
    @JsonProperty("ctr")
    private Integer ctr;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("vcode")
    private String vcode;
    @JsonProperty("vlink")
    private String vlink;

}
