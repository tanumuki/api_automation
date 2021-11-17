package pojos.appGetLaunchData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppLanguages {

    @JsonProperty("default_selection")
    private String default_selection;

    @JsonProperty("list")
    private AppLanguagesList appLanguagesList;

}
