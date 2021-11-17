package pojos.benefits;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter

public class BenefitsMonetaryValue {
    @JsonProperty("saved")
    private String saved;
    @JsonProperty("to_unlock")
    private String to_unlock;
    @JsonProperty("currency")
    private String currency;
}
