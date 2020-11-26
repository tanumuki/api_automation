package pojos.jioPhoneGetLaunchData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class JioPhoneGetLaunchData {
    @JsonProperty("config")
    private Config config;

    @JsonProperty("homepage_data")
    private ConfigData [] configData;

}
