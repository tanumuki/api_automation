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

public class TopSearch {
    @JsonProperty("entity_id")
    private String entityId;
    @JsonProperty("image")
    private String image;
    @JsonProperty("entity_name")
    private String entityName;
    @JsonProperty("entity_type")
    private String entityType;
}
