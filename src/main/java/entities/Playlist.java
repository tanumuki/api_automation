package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class Playlist extends Entity{
    @JsonProperty("list")
    private Object list;
    @JsonProperty("more_info")
    private Object more_info; //can be a JSONArray or JSONObject
    @JsonProperty("mini_obj")
    private Boolean mini_obj;
    @JsonProperty("modules")
    private MixDetailsModules modules;
}
