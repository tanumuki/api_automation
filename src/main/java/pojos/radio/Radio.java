package pojos.radio;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import entities.Song;

@JsonInclude(JsonInclude.Include.NON_NULL)



public class Radio {

@JsonProperty("song")
public Song song;
@JsonProperty("stationid")
public String stationid;

}