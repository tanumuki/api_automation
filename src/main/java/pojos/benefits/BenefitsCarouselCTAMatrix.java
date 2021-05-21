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
public class BenefitsCarouselCTAMatrix {
    @JsonProperty("free")
    private BenefitsUserProType free;
    @JsonProperty("expired")
    private BenefitsUserProType expired;
    @JsonProperty("trial")
    private BenefitsUserProType trial;
    @JsonProperty("plus")
    private BenefitsUserProType plus;
}
