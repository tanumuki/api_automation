package pojos.makePrivatePlaylist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter

public class more_info {
    @JsonProperty("favourite")
    private String favourite;
    @JsonProperty("contents")
    private String contents;
    @JsonProperty("song_count")
    private String songCount;
    @JsonProperty("video_count")
    private String videoCount;
    @JsonProperty("follower_count")
    private String followerCount;
    @JsonProperty("share")
    private String share;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("is_followed")
    private String isFollowed;
    @JsonProperty("last_updated")
    private String lastUpdated;
}
