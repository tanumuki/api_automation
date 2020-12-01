package pojos.SubsCheckSongRights;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Rights;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class CheckSongsRights {

    private Map<String, Rights> songRights = new LinkedHashMap<>();

    @JsonAnySetter
    public void setSongRights(String key, Rights val) {
        songRights.put(key, val);
    }
}
