package pojos.JioSendOtp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JioSendOtpData {
    @JsonProperty("correlation_id")
    private String correlation_id;
}
