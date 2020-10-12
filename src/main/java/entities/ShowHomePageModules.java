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
public class ShowHomePageModules {
    @JsonProperty("seasons")
    private ModuleWithViewMoreArray seasons;
    @JsonProperty("episodes")
    private ModuleWithViewMoreArray episodes;
    @JsonProperty("show_details")
    private ModuleWithViewMoreArray showDetails;
    @JsonProperty("show_starring")
    private ModuleWithViewMoreArray showStarring;
}
