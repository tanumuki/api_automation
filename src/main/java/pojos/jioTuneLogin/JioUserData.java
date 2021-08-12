package pojos.jioTuneLogin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class JioUserData {

    @JsonProperty("unique")
    private String unique;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("subscriberId")
    private String subscriberId;
    @JsonProperty("age")
    private String age;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("version")
    private String version;
    @JsonProperty("masked_phone_number")
    private String maskedPhoneNumber;
}
