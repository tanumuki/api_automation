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
public class RandomSongsLists {
    private Map<String, SongsListMini> langListMap = new LinkedHashMap<>();
    @JsonAnySetter
    private void setLangListMap(String key, SongsListMini val){
        langListMap.put(key, val);
    }
}
