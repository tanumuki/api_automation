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
public class Trial {
    @JsonProperty("period")
    private String period;
    @JsonProperty("dormant_period")
    private String dormantPeriod;
    @JsonProperty("storage_limit")
    private String storageLimit;
    @JsonProperty("device_limit")
    private String deviceLimit;


}
