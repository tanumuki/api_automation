package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JioTuneLimitPojo {

    @JsonProperty("available")
    private String available;
    @JsonProperty("left")
    private int left;
    @JsonProperty("total")
    private int total;
    @JsonProperty("isPro")
    private Boolean isPro;
}
