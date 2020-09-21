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
public class Product {
    @JsonProperty("name")
    private String name;
    @JsonProperty("cat")
    private String cat;
    @JsonProperty("dormant_period")
    private String dormant_period;
    @JsonProperty("grace_period")
    private String grace_period;
    @JsonProperty("storage_limit")
    private String storage_limit;
    @JsonProperty("device_limit")
    private String device_limit;
    @JsonProperty("period")
    private String period;
    @JsonProperty("period_unit")
    private String period_unit;
    @JsonProperty("discount")
    private String discount;
    @JsonProperty("price_display")
    private String price_display;
    @JsonProperty("price_display_per_unit")
    private String price_display_per_unit;
    @JsonProperty("price")
    private String price;
    @JsonProperty("description")
    private String description;

}
