package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PlaylistMini extends Entity {

    @JsonProperty("more_info")
    private PlaylistMiniMoreInfo moreInfo;

    @JsonProperty("mini_obj")
    private Boolean mini_obj;

}
