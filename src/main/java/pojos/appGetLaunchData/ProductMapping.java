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
public class ProductMapping {
    @JsonProperty("prime_1year")
    private ProductType prime_1year;
    @JsonProperty("prime")
    private ProductType prime;
    @JsonProperty("saavn.30day")
    private ProductType saavn_30day;
    @JsonProperty("saavn.1year")
    private ProductType saavn_1year;
}
