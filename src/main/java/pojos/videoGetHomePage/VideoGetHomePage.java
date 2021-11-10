package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import entities.ModuleWithViewMoreArray;
import entities.RadioStation;
import io.cucumber.messages.internal.com.google.gson.JsonArray;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import pojos.videoGetDetails.VideoData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Data
@JsonIgnoreProperties
public class VideoGetHomePage {


    @JsonProperty("video_stations")
    private List<VideoStation> videoStations = null;
    @JsonProperty("modules")
    private Modules modules;


    private Map<String, List<LinkedHashMap>> videoHomePageData=  new LinkedHashMap<>();
    @JsonAnySetter
    public void setVideoHomePageData(String key, List<LinkedHashMap> val){
        videoHomePageData.put(key,val);
    }
}
