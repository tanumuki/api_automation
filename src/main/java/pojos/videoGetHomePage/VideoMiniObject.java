package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoMiniObject {

    @JsonProperty("id")
    public String id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("subtitle")
    public String subtitle;
    @JsonProperty("type")
    public String type;
    @JsonProperty("image")
    public String image;
    @JsonProperty("perma_url")
    public String permaUrl;
    @JsonProperty("more_info")
    public VideoMiniObjectMoreInfo moreInfo;
    @JsonProperty("explicit_content")
    public String explicitContent;
    @JsonProperty("mini_obj")
    public String miniObj;

}
