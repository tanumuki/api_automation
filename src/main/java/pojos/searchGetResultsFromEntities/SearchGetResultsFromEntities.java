package pojos.searchGetResultsFromEntities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Song;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class SearchGetResultsFromEntities {

    @JsonProperty("total")
    private int total;

    @JsonProperty("start")
    private int start;

    @JsonProperty("results")
    private Song[] results;
}
