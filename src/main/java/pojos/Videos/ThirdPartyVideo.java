package pojos.Videos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@lombok.Data
@Getter
@Setter
public class ThirdPartyVideo {
    @JsonProperty("user_url")
    private String userUrl;
    @JsonProperty("Media_url")
    private String mediaUrl;
    @JsonProperty("user_image")
    private String userImage;
    @JsonProperty("image")
    private String image;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("language")
    private String language;
    @JsonProperty("partner_id")
    private String partnerId;
    @JsonProperty("video_id")
    private String videoId;
}
