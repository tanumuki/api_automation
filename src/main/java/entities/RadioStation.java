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
public class RadioStation extends Entity {
    @JsonProperty("more_info")
    private RadioStationMoreInfo more_info;

    @JsonProperty("mini_obj")
    private Boolean mini_obj;


}
