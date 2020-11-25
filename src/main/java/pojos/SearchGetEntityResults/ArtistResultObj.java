package pojos.SearchGetEntityResults;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class ArtistResultObj {
    @JsonProperty("artists_id")
    private String artists_id;
    @JsonProperty("artists_name")
    private String artists_name;
    @JsonProperty("artists_sequence")
    private String artists_sequence;
    @JsonProperty("artists_role")
    private String artists_role;


}
