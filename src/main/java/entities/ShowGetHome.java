package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class ShowGetHome {
    @JsonProperty("show_details")
    private ShowDetails showDetails;
    @JsonProperty("seasons")
    private List<Season> seasons = null;
    @JsonProperty("episodes")
    private List<Episode> episodes = null;
    @JsonProperty("modules")
    private ShowHomePageModules modules;
}
