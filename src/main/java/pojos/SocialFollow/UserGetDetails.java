package pojos.SocialFollow;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter

public class UserGetDetails {

    @JsonProperty("uid")
    private String uid;
    @JsonProperty("username")
    private String username;
    @JsonProperty("image")
    private String image;
    @JsonProperty("name")
    private String name;
    @JsonProperty("follower_count")
    private String followerCount;
    @JsonProperty("is_followed")
    private Boolean isFollowed;
}
