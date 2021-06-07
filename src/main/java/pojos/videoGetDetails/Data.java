package pojos.videoGetDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import entities.VideoMoreInfo;
import lombok.Getter;
import lombok.Setter;

@lombok.Data
@Getter
@Setter
public class Data extends Entity {
//    @JsonProperty("id")
//    public String id;
//    @JsonProperty("title")
//    public String title;
//    @JsonProperty("subtitle")
//    public String subtitle;
//    @JsonProperty("header_desc")
//    public String headerDesc;
//    @JsonProperty("type")
//    public String type;
//    @JsonProperty("perma_url")
//    public String permaUrl;
//    @JsonProperty("image")
//    public String image;
//    @JsonProperty("language")
//    public String language;
//    @JsonProperty("year")
//    public String year;
//    @JsonProperty("play_count")
//    public String playCount;
//    @JsonProperty("explicit_content")
//    public String explicitContent;
//    @JsonProperty("list_count")
//    public String listCount;
//    @JsonProperty("list_type")
//    public String listType;
    @JsonProperty("list")
    public String list;
    @JsonProperty("more_info")
    public VideoMoreInfo videoMoreInfo;

}