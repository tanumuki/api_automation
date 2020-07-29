package pojos.user_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class SongRightsData {
    public SongRightsData() {
    }
    @JsonProperty("code")
    private String code;
    @JsonProperty("cacheable")
    private String cacheable;
    @JsonProperty("delete_cached_object")
    private String delete_cached_object;
    @JsonProperty("reason")
    private String reason;
}
