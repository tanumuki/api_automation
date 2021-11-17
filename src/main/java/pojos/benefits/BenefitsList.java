package pojos.benefits;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
public class BenefitsList {

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private BenefitsListData [] data;
    @JsonProperty("metadata")
    private Metadata metadata;
}
