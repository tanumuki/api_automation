package pojos.podcastGetMoreData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.podcastsGetAll.PodcastsMenu;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PodcastGetMoreData {
    @JsonProperty("data")
    private List<PodcastsMenu> data;
    @JsonProperty("last_page")
    private Boolean lastPage;
}
