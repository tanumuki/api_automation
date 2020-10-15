package pojos.podcastsGetAll;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class PodcastsTag {
    @JsonProperty("name")
    private String name;
    @JsonProperty("type_param_value")
    private String typeParamValue;
    @JsonProperty("source_view")
    private String sourceView;
}
