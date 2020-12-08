package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class Channel extends Entity {
    @JsonProperty("image_file_url")
    private String imageFileUrl;
    @JsonProperty("channel_subtype")
    private String channel_subtype;

    @JsonProperty("mini_obj")
    private boolean mini_obj;
    @JsonProperty("more_info")
    private ChannelMoreInfo more_info;
    @JsonProperty("channel_language")
    private List<String> channel_language;
    @JsonProperty("artists")
    private List<String> artists;
    @JsonProperty("primary_artists")
    private List<String> primary_artists;
    @JsonProperty("featured_artists")
    private List<String> featured_artists;

}
