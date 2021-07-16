package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Modules {

    @JsonProperty("video_stations")
    public ModulesVideoStations videoStations;
    @JsonAnySetter
    private Map<String , List<LinkedHashMap>> videoHomePageDataModule=  new LinkedHashMap<>();

    public void setVideoHomePageDataModule(String key, List<LinkedHashMap> val){
        videoHomePageDataModule.put(key,val);
    }

}
