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
public class BenefitsUserProType {
    @JsonProperty("title")
    private String title;
    @JsonProperty("color")
    private String color;
    @JsonProperty("deeplink")
    private String deeplink;
}
