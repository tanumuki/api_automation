package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Channel extends Entity {
    @JsonProperty("mini_obj")
    private boolean mini_obj;
    @JsonProperty("more_info")
    private ChannelMoreInfo more_info;
}
