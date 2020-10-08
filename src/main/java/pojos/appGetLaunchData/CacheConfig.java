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

public class CacheConfig {
    @JsonProperty("enabled")
    private String enabled;
    @JsonProperty("max_content_size")
    private String maxContentSize;
    @JsonProperty("min_free_storage_pct")
    private String min_free_storage_pct;
}
