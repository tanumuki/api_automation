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
public class AB_test {
    @JsonProperty("splash")
    private String splash;
    @JsonProperty("paywall")
    private String paywall;
    @JsonProperty("freemium")
    private String freemium;
}
