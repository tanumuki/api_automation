package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Data
public class Modules {

    @JsonProperty("video_stations")
    private ModulesVideoStations videoStations;
    @JsonAnySetter
    private Map<String , List<LinkedHashMap>> videoHomePageDataModule=  new LinkedHashMap<>();

    public void setVideoHomePageDataModule(String key, List<LinkedHashMap> val){
        videoHomePageDataModule.put(key,val);
    }

}
