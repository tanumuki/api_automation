package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class PlaylistMini extends Entity {

    @JsonProperty("more_info")
    private PlaylistMiniMoreInfo moreInfo;
    @JsonProperty("list")
    private String list;
    @JsonProperty("mini_obj")
    private Boolean mini_obj;
    @JsonProperty("modules")
    private Object modules;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("explicit_content")
    private String explicit_content;

}
