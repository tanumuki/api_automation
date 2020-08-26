package pojos.getTopShows;

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
public class TopShows {
    @JsonProperty("badge")
    private String badge;
    @JsonProperty("shows")
    private List<ShowDetails> shows;
    @JsonProperty("last_page")
    private Boolean last_page;
}