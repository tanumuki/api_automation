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

public class Ads {
    @JsonProperty("carrier")
    private String carrier;
    @JsonProperty("segment_ids")
    private String segmentIds;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("cohort")
    private String cohort;
}
