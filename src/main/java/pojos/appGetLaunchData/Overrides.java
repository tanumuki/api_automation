package pojos.appGetLaunchData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class Overrides {
    @JsonProperty("name")
    private String name;
    @JsonProperty("limit")
    private String limit;
    @JsonProperty("error")
    private String error;
}
