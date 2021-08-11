package pojos.jioTuneLogin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JioUserData {

    @JsonProperty("unique")
    public String unique;
    @JsonProperty("uid")
    public String uid;
    @JsonProperty("subscriberId")
    public String subscriberId;
    @JsonProperty("age")
    public String age;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("phone_number")
    public String phoneNumber;
    @JsonProperty("version")
    public String version;
    @JsonProperty("masked_phone_number")
    public String maskedPhoneNumber;
}
