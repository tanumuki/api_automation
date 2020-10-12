package pojos.benefits;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.mozilla.javascript.annotations.JSConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
public class List {

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private BenefitsListData [] data;
}
