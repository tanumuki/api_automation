package pojos.jioPhoneGetLaunchData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
public class Pagination {

    @JsonProperty("page")
    private String page;
    @JsonProperty("count")
    private String count;
    @JsonProperty("default_count")
    private String default_count;
}
