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
public class BenefitsCategories {
    @JsonProperty("category_title")
    private String category_title;
    @JsonProperty("category_id")
    private String category_id;
    @JsonProperty("position")
    private String position;
}
