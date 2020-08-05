package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Season extends Entity {

    @JsonProperty("mini_obj")
    private Boolean mini_obj;
    @JsonProperty("more_info")
    private SeasonMoreInfo moreInfo;
}
