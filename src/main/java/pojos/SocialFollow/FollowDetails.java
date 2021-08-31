package pojos.SocialFollow;

import lombok.Data;


import com.fasterxml.jackson.annotation.JsonProperty;
@Data
public class FollowDetails {

    @JsonProperty("artistid")
    private String artistid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private String image;
    @JsonProperty("follower_count")
    private String follower_count;
    @JsonProperty("is_followed")
    private Boolean is_followed;
}
