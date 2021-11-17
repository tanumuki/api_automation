package pojos.setJioTune;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@lombok.Data
public class Result {

    @JsonProperty("data")
    private Data data;
}
