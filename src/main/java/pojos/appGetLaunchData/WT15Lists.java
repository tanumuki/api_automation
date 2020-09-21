package pojos.appGetLaunchData;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class WT15Lists {
    private Map<String, SongsListMini> langWt15Map = new LinkedHashMap<>();
    @JsonAnySetter
    public void setLangWt15Map(String key, SongsListMini val){
        langWt15Map.put(key, val);
    }

}
