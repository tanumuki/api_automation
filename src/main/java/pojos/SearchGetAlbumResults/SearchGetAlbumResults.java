package pojos.SearchGetAlbumResults;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Album;
import io.cucumber.java.sl.In;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class SearchGetAlbumResults {
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("start")
    private Integer start;
    @JsonProperty("results")
    private List<Album> results;
}
