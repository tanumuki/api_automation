package pojos.podcastsGetAll;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class PodcastsMenu extends Entity {
    @JsonProperty("source_api")
    private Boolean sourceApi;
    @JsonProperty("source")
    private String source;
    @JsonProperty("source_view")
    private String sourceView;
    @JsonProperty("search_api")
    private String searchApi;
    @JsonProperty("search_param")
    private PodcastsSearchParams searchParam;
    @JsonProperty("source_params")
    private PodcastsSourceParams sourceParams;
    @JsonProperty("tags")
    private List<PodcastsTag> tags;
}
