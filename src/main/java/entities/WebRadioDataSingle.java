package entities;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class WebRadioDataSingle {

    @JsonProperty("stationid")
    public String stationid;
    @JsonProperty("song")
    public Song song;

//    private Map<String, Song> songEntity = new HashMap<>();
//    @JsonAnySetter
//    public void setProviders(String key, Song val) { songEntity.put(key, val);

}