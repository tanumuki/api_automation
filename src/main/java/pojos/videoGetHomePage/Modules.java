package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ModuleWithViewMoreArray;
import io.cucumber.messages.internal.com.google.gson.JsonArray;
import io.cucumber.messages.internal.com.google.gson.JsonElement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Data
public class Modules {

    @JsonProperty("video_stations")
    private ModuleWithViewMoreArray videoStations;



   @JsonAnySetter
    private Map<String , ModuleWithViewMoreArray> videoHomePageDataModule=  new LinkedHashMap<>();

    public void setVideoHomePageDataModule(String key, ModuleWithViewMoreArray val){
        videoHomePageDataModule.put(key,val);
    }


//      //JsonArray elementArray;
//      @JsonProperty("video_stations")
//      Object elementArr;




}
