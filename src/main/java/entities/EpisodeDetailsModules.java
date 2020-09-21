package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class EpisodeDetailsModules {
    @JsonProperty("episode_details")
    private ModuleWithViewMoreArray episode_details;
    @JsonProperty("episode_starring")
    private ModuleWithViewMoreArray episode_starring;
}
