package pojos.jioTuneLogin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Info {





        @JsonProperty("platform")
        private Platform platform;
        @JsonProperty("type")
        private String type="android";
        @JsonProperty("androidId")
        private String androidId="54a18c4b9c8cb694";


}
