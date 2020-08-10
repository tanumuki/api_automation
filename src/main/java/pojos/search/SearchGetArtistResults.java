package pojos.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Artist;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@Data
public class SearchGetArtistResults {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("start")
    private Integer start;
    @JsonProperty("results")
    private List<Artist> results;



}
