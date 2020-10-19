package pojos.podcastGetCategory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ShowDetails;
import entities.ShowMini;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PodcastGetCategory {
    @JsonProperty("data")
    private List<ShowMini> shows = null;
    @JsonProperty("last_page")
    private Boolean last_page;
}
