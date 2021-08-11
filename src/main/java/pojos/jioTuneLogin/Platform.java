package pojos.jioTuneLogin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Platform {


    @JsonProperty("name")
    private String name="RMX2001";


}
