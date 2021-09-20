package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ChannelMoreInfo {
    @JsonProperty("badge")
    private String badge;
    @JsonProperty("sub_type")
    private String subType;
    @JsonProperty("available")
    private String available;
    @JsonProperty("is_featured")
    private String isFeatured;
    @JsonProperty("tags")
    private Object tags; // Can be both array and object
    @JsonProperty("video_url")
    private String videoUrl;
    @JsonProperty("video_thumbnail")
    private String videoThumbnail;
    @JsonProperty("language")
    private List<String> language;
}
