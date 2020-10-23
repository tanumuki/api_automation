package pojos.podcastGetAllCategories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.podcastsGetAll.PodcastCategory;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PodcastGetAllCategories {
    @JsonProperty("data")
    private List<PodcastCategory> data = null;
    @JsonProperty("last_page")
    private Boolean lastPage;
}
