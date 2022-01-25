package pojos.SocialFollow;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class GetFollowDetails {

    @JsonProperty("type")
    private String type;
    @JsonProperty("details")
    private FollowDetails details;


}

