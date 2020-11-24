package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ShowDetails extends Entity{

    @JsonProperty("list")
    private String list;

    @JsonProperty("more_info")
    private ShowMoreInfo moreInfo;

    @JsonProperty("mini_obj")
    private Boolean mini_obj;

    @JsonProperty("image_file_url")
    private String imageFileUrl;
    @JsonProperty("partner_name")
    private String partner_name;

    @JsonProperty("disable_ads")
    private String disable_ads;
    @JsonProperty("background_color")
    private String background_color;

    @JsonProperty("label_name")
    private String label_name;

    @JsonProperty("song_info")
    private String song_info;
    @JsonProperty("latest_season_sequence")
    private String latest_season_sequence;
    @JsonProperty("square_image_url")
    private String square_image_url;



    @JsonProperty("artists")
    private List<String> artists;
    @JsonProperty("primary_artists")
    private List<String> primary_artists;
    @JsonProperty("featured_artists")
    private List<String> featured_artists;
}
