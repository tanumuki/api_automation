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
    private Map<String, ModulesData> allArtistTuneInModules = new LinkedHashMap<>();

    public void setModulesDataForAllArtistTunes(String key, ModulesData val){ allArtistTuneInModules.put(key, val);
    }

    private Map<String, ModulesData> popularArtistTune = new LinkedHashMap<>();

    public void setModulesDataForPopularArtistTunes(String key, ModulesData val){ popularArtistTune.put(key, val);
    }

// TODO: To figure out how to use @JsonAnySetter for JsonObject (Used it for JsonArray in ArtistCallerTuneContainer)
//    @JsonProperty("popular_artist_tune")
//    public ModulesData popularArtistTune;
//    @JsonProperty("all_artist_tune_1")
//    public ModulesData allArtistTuneInModules;

}
