package pojos.SongGetParam;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class SongParamData {
    private Map<String, SongParamMoreInfo> songPid = new HashMap<>();
    @JsonAnySetter
    public void setProviders(String key, SongParamMoreInfo val){
        songPid.put(key, val);
    }
}
