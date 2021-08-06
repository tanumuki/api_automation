package pojos.JiotuneHomePageData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class JTGetHomepageModules extends Entity {
    @JsonProperty("data")
    private List<PlaylistMini> data;
    @JsonProperty("last_page")
    private Boolean lastPage;
}
