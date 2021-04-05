package pojos.podcastsGetAll;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ModulesWithViewMoreObj;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PodcastsGetAllModules {
    @JsonProperty("base_menu")
    private ModulesWithViewMoreObj baseMenu;
    @JsonProperty("new_trending")
    private ModulesWithViewMoreObj newTrending;

    Map<String, ModulesWithViewMoreObj> podcasts = new LinkedHashMap<>();
    @JsonAnySetter
    public void setPodcasts(String key, ModulesWithViewMoreObj val){
        podcasts.put(key, val);
    }

}
