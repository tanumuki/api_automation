package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.RadioStationMoreInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class VideoStationMoreInfo extends RadioStationMoreInfo {

//    @JsonProperty("description")
//    private String description;
//    @JsonProperty("featured_station_type")
//    private String featuredStationType;
//    @JsonProperty("color")
//    private String color;
//    @JsonProperty("language")
//    private String language;
//    @JsonProperty("station_display_text")
//    private String stationDisplayText;
//    @JsonProperty("tags")
//    private Tags tags;
//    @JsonProperty("pro_only")
//    private Boolean proOnly;

    @JsonProperty ("pro_only")
    private String proOnly;

}