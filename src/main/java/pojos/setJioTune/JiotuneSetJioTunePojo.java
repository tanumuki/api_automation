package pojos.setJioTune;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JiotuneSetJioTunePojo {

    @JsonProperty("messageCode")
    private String messageCode;
    @JsonProperty("result")
    private Result result;
}
