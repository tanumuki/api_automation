package pojos.setJioTune;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@lombok.Data
public class Data {

    @JsonProperty("Success")
    private String success;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("renewDate")
    private String renewDate;
}
