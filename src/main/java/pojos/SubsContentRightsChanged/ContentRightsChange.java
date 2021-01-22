package pojos.SubsContentRightsChanged;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class ContentRightsChange {
    @JsonProperty("last_change_at")
    private Long last_change_at;
    @JsonProperty("check_frequency")
    private Integer check_frequency;
}
