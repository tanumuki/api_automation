package pojos.JioSendOtp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JioSendOtpPojo {

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private JioSendOtpData data;
    @JsonProperty("msg")
    private String msg;
}
