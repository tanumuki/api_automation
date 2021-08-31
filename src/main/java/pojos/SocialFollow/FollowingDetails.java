package pojos.SocialFollow;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FollowingDetails {

    @JsonProperty("usersCount")
    private Integer usersCount;
    @JsonProperty("artistsCount")
    private Integer artistsCount;
    @JsonProperty("playlistsCount")
    private Integer playlistsCount;
}
