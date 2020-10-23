package pojos.podcastGetNT;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ShowDetails;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PodcastGetNT {
    @JsonProperty("data")
    private List<PodcastNTObj> data = null;
    @JsonProperty("last_page")
    private Boolean lastPage;
}
