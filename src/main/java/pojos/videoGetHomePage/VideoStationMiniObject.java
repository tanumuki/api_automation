package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class VideoStationMiniObject {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("type")
    private String type;
    @JsonProperty("image")
    private String image;
    @JsonProperty("perma_url")
    private String permaUrl;
    @JsonProperty("more_info")
    private VideoStationMiniObjectMoreInfo moreInfo;
    @JsonProperty("explicit_content")
    private String explicitContent;
    @JsonProperty("mini_obj")
    private String miniObj;

}
