package pojos.appGetLaunchData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class Deeplink extends Entity {
    @JsonProperty("deeplink")
    private String deeplink;
    @JsonProperty("color")
    private String color;
}
