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
public class SongGetParamPojo {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private SongParamData data;
}
