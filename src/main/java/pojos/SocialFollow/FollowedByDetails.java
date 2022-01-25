package pojos.SocialFollow;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FollowedByDetails {

    @JsonProperty("usersCount")
    private Integer usersCount;

}
