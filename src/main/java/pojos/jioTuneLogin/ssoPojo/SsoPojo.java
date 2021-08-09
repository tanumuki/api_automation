package pojos.jioTuneLogin.ssoPojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class SsoPojo {

    @JsonProperty("deviceInfo")
    private DeviceInfo deviceInfo;

    @Override
    public String toString() {
        return super.toString();
    }
}
