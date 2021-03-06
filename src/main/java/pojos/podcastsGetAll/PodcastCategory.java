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
public class PodcastCategory extends Entity {
    @JsonProperty("total_count")
    private Integer totalCount;
    @JsonProperty("season_number")
    private Integer seasonNumber;
    @JsonProperty("category_type")
    private String categoryType;
    @JsonProperty("more_info")
    private PodcastCategoryMoreInfo moreInfo;
    @JsonProperty("description")
    private String description;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("languages")
    private List<String> languages;
}
