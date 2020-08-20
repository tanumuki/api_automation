package entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import entities.Song;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)


@Data
@Getter
@Setter
public class Radio extends Entity {

    @JsonProperty("song")
    public Song song;
    @JsonProperty("stationid")
    public String stationid;
    @JsonProperty("featured_stations")
    private List<RadioStation> featured_stations;

}