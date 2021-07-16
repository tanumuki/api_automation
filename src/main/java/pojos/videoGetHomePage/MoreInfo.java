package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoreInfo {

    @JsonProperty("description")
    public String description;
    @JsonProperty("featured_station_type")
    public String featuredStationType;
    @JsonProperty("color")
    public String color;
    @JsonProperty("language")
    public String language;
    @JsonProperty("station_display_text")
    public String stationDisplayText;
    @JsonProperty("tags")
    public Tags tags;
    @JsonProperty("pro_only")
    public Boolean proOnly;

}