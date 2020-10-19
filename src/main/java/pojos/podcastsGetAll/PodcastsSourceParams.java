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
public class PodcastsSourceParams {
    @JsonProperty("page_param")
    private String pageParam;
    @JsonProperty("size_param")
    private String sizeParam;
    @JsonProperty("type_param")
    private String typeParam;
}
