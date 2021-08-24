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
    @JsonProperty("referee")
    private AdRefree referee;
    @JsonProperty("adproduct_abtest")
    private String adproduct_abtest;
    @JsonProperty("audio_companion_exp")
    private String audio_companion_exp;
    @JsonProperty("pa_exp")
    private String pa_exp;
    @JsonProperty("adload_abtest")
    private String adload_abtest;

}
