package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import entities.ModuleWithViewMoreArray;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@Data
public class Modules {

//    @JsonAnySetter
//    private Map<String , ModuleWithViewMoreArray>  videoStations =new LinkedHashMap<>();
//    public void setVideoStationModule(String key, ModuleWithViewMoreArray val){
//        videoStations.put(key,val);
//    }



   @JsonAnySetter
    private Map<String , ModuleWithViewMoreArray> viewMoreArrayDataModule =  new LinkedHashMap<>();

    public void setViewMoreArrayDataModule(String key, ModuleWithViewMoreArray val){
        viewMoreArrayDataModule.put(key,val);
    }


//      //JsonArray elementArray;
//      @JsonProperty("video_stations")
//      Object elementArr;




}
