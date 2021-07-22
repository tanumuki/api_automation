package pojos.JiotunepageCallerTune;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
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

public class ArtistCallerTuneContainer {
    @JsonProperty("popular_artist_tune")
    public List<Entity> popularArtistTune = null;
    @JsonProperty("last_page")
    public Integer lastPage;
    @JsonProperty("modules")
    public Modules modules;
    private Map<String, Entity[]> allArtistTune = new HashMap<>();
    @JsonAnySetter
    public void setProviders(String key, Entity[] val){
        allArtistTune.put(key, val);
    }

}
