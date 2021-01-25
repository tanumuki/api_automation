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
public class DeferredLoginConfigObj {
    @JsonProperty("primary_cta")
    private DeferredLoginConfigObjParams primary_cta;
    @JsonProperty("secondary_cta_1")
    private DeferredLoginConfigObjParams secondary_cta_1;
    @JsonProperty("secondary_cta_2")
    private DeferredLoginConfigObjParams secondary_cta_2;
    @JsonProperty("swipe_landing")
    private DeferredLoginConfigObjParams swipe_landing;
    @JsonProperty("swipe_landing_skippable")
    private DeferredLoginConfigObjParams swipe_landing_skippable;

}
