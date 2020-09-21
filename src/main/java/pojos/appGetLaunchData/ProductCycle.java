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
public class ProductCycle {
    @JsonProperty("id")
    private String id;
    @JsonProperty("renewal_cycle")
    private String renewal_cycle;
    @JsonProperty("price_display")
    private String price_display;
    @JsonProperty("price_display_per_unit")
    private String price_display_per_unit;
    @JsonProperty("price")
    private String price;

}
