package pojos.getHomePageDataV2;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ModuleWithViewMoreArray;
import entities.ModulesData;
import entities.ModulesWithViewMoreObj;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class HomePageDataModules {

    @JsonProperty("history")
    private ModuleWithViewMoreArray history;
    @JsonProperty("top_shows")
    private ModuleWithViewMoreArray topShows;
    @JsonProperty("favorites")
    private ModulesWithViewMoreObj favorites;
    @JsonProperty("city_mod")
    private ModuleWithViewMoreArray cityMod;
    @JsonProperty("new_trending")
    private ModulesWithViewMoreObj newTrending;
    @JsonProperty("top_playlists")
    private ModulesWithViewMoreObj topPlaylists;
    @JsonProperty("mixes")
    private ModuleWithViewMoreArray mixes;
    @JsonProperty("artist_recos")
    private ModuleWithViewMoreArray artistRecos;
    @JsonProperty("tag_mixes")
    private ModuleWithViewMoreArray tagMixes;
    @JsonProperty("radio")
    private ModuleWithViewMoreArray radio;
    @JsonProperty("new_albums")
    private ModulesWithViewMoreObj newAlbums;
    @JsonProperty("charts")
    private ModulesWithViewMoreObj charts;
    private Map<String, Object> topic = new LinkedHashMap<>();
    @JsonAnySetter
    public void setTopic(String key, Object val){
        topic.put(key, val);
    }

}
