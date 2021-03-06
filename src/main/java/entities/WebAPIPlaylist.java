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
public class WebAPIPlaylist extends Entity{
    @JsonProperty("list")
    private Object list;
    @JsonProperty("more_info")
    private PlaylistMoreInfo more_info;
    @JsonProperty("mini_obj")
    private Boolean mini_obj;
    @JsonProperty("modules")
    private Modules modules;
}
