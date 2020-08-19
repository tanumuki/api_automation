package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class RadioStationMoreInfo {
    @JsonProperty("tags")
    private Tags tags;
    @JsonProperty("description")
    private String description;
    @JsonProperty("featured_station_type")
    private String featuredStationType;
    @JsonProperty("query")
    private String query;
    @JsonProperty("color")
    private String color;
    @JsonProperty("language")
    private String language;
    @JsonProperty("station_display_text")
    private String stationDisplayText;
}
