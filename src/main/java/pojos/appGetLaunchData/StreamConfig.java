package pojos.appGetLaunchData;

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
public class StreamConfig {
    @JsonProperty("available_bitrates")
    private List<String> availableBitrates;
    @JsonProperty("bitrates_map")
    private BitrateMap bitratesMap;

    private Map<String,Integer> bitrate = new HashMap<>();
    @JsonAnySetter
    public void setBitrate(String key, Integer val){
        bitrate.put(key, val);
    }


}
