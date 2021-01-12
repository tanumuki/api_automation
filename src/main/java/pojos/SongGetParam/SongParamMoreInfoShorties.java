package pojos.SongGetParam;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class SongParamMoreInfoShorties {

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("is_primary")
    private String is_primary;

    @JsonProperty("media_url")
    private String media_url;
}
