package pojos.SocialFollow;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FollowingCount {
    @JsonProperty("following")
    private FollowingDetails following;
    @JsonProperty("followed_by")
    private FollowedByDetails followed_by;
    @JsonProperty("status")
    private String status;


}

