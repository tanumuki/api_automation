package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.RadioStation;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.videoGetDetails.VideoData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Data
public class VideoGetHomePage {


    @JsonProperty("video_stations")
    private List<VideoStation> videoStations = null;
    @JsonProperty("modules")
    private Modules modules;


    private Map<String, List<VideoData>> videoHomePageData=  new LinkedHashMap<>();
    @JsonAnySetter
    public void setVideoHomePageData(String key, List<VideoData> val){
        videoHomePageData.put(key,val);
    }
}
