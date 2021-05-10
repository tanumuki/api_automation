package pojos.browseGetAll;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Mix;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class BrowseGetAllPojo {
    @JsonProperty("modules")
    private BrowseGetAllModules modules;
    @JsonProperty("made_for_you")
    private List<Mix> madeForYou;
}
