package pojos.makePrivatePlaylist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter

public class details {
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("header_desc")
    private String headerDesc;
    @JsonProperty("type")
    private String type;
    @JsonProperty("perma_url")
    private String permaUrl;
    @JsonProperty("image")
    private String image;
    @JsonProperty("language")
    private String language;
    @JsonProperty("year")
    private String year;
    @JsonProperty("play_count")
    private String playCount;
    @JsonProperty("explicit_content")
    private String explicitContent;
    @JsonProperty("list_count")
    private String listCount;
    @JsonProperty("list_type")
    private String listType;
    @JsonProperty("list")
    private String list;
    @JsonProperty("more_info")
    private more_info moreInfo;

}
