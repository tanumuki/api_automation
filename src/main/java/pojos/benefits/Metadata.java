package pojos.benefits;

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
public class Metadata {
    @JsonProperty("carousel_cta_matrix")
    private BenefitsCarouselCTAMatrix carousel_cta_matrix;
    @JsonProperty("categories")
    private List<BenefitsCategories> categories;
    @JsonProperty("monetary_value")
    private BenefitsMonetaryValue monetary_value;
}
