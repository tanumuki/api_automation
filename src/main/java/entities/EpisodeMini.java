package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EpisodeMini extends Entity{

    @JsonProperty("list")
    private String list;
    @JsonProperty("more_info")
    private EpisodeMoreInfo moreInfo;
    @JsonProperty("modules")
    private Object modules;
    @JsonProperty("description")
    private String description;
}
