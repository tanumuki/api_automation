package pojos.podcastsGetAll;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Episode;
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
public class PodcastGetAllPojo {
    @JsonProperty("modules")
    private PodcastsGetAllModules modules;
    @JsonProperty("base_menu")
    private List<PodcastsBaseMenu> baseMenu;
    @JsonProperty("new_and_trending")
    private List<Episode> newAndTrending;

    Map<String, List<LinkedHashMap>> podcastHomeModule = new LinkedHashMap<>();
    @JsonAnySetter
    public void setPodcastHomeModule(String key, List<LinkedHashMap> val) { podcastHomeModule.put(key, val); }

}
