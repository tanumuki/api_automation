package pojos.SearchGetEntityResults;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class SearchGetEntityResults {
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("start")
    private Integer start;
    @JsonProperty("results")
    private List<LinkedHashMap> results;
}
