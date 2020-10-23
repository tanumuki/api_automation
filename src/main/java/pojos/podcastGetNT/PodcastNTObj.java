package pojos.podcastGetNT;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PodcastNTObj extends Entity {
    @JsonProperty("list")
    private String list;
    @JsonProperty("more_info")
    private PodcastNTMoreInfo moreInfo;
}
