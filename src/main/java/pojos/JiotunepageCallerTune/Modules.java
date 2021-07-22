package pojos.JiotunepageCallerTune;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import entities.Entity;
import io.cucumber.java.af.En;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter

public class Modules {

//    private Map<String, Entity> allArtistTuneInModules = new HashMap<>();
//    @JsonAnySetter
//    public void setProviders(String key, Entity val){ allArtistTuneInModules.put(key, val);
//    }

// TODO: To figure out how to use @JsonAnySetter for JsonObject (Used it for JsonArray in ArtistCallerTuneContainer)
    @JsonProperty("popular_artist_tune")
    public Entity popularArtistTune;
    @JsonProperty("all_artist_tune_1")
    public Entity allArtistTuneInModules;

}
