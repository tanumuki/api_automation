package entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter

public class deeplinkContainer extends Entity {
    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private Object  data; //can be a JSONArray or JSONObject

}
