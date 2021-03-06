package pojos.jioPhoneGetLaunchData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class Styles {

    @JsonProperty("article")
    private String article;
    @JsonProperty("span")
    private String span;
}
