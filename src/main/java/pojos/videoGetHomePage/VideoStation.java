package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoStation {

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
    public MoreInfo moreInfo;
    @JsonProperty("explicit_content")
    public String explicitContent;
    @JsonProperty("mini_obj")
    public Boolean miniObj;
}
