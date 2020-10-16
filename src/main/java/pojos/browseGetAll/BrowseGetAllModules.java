package pojos.browseGetAll;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ModuleWithViewMoreArray;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class BrowseGetAllModules {
    @JsonProperty("made_for_you")
    private ModuleWithViewMoreArray madeForYou;
}
