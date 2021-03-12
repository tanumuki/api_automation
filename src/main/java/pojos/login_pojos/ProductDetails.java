package pojos.login_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class ProductDetails {
    @JsonProperty("name")
    private String name;
    @JsonProperty("cat")
    private String cat;
    @JsonProperty("id")
    private String id;
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
    @JsonProperty("description")
    private String description;
    @JsonProperty("tier_id")
    private String tier_id;
    @JsonProperty("price_display_per_unit")
    private String price_display_per_unit;
    @JsonProperty("price")
    private String price;
    @JsonProperty("price_display")
    private String price_display;
    @JsonProperty("highlight")
    private String highlight;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("price_text")
    private String price_text;
    @JsonProperty("vendor")
    private List<String> vendor;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("autorenew_text")
    private String autorenew_text;

}
