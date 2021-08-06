package pojos.JiotunepageCallerTune;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ModulesData;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter

public class JTModules {

    @JsonAnySetter
    private Map<String, ModulesData> artistTuneModules = new LinkedHashMap<>();

    public void setModulesDataForAllArtistTunes(String key, ModulesData val){ artistTuneModules.put(key, val);
    }

}
