package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.login_pojos.LoginProstatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class UserState {
    @JsonProperty("user_logged_in")
    private Integer userLoggedIn;
    @JsonProperty("username")
    private String username;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("encrypted_uid")
    private String encryptedUid;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("email_verified_status")
    private String email_verified_status;
    @JsonProperty("require_otp")
    private Boolean require_otp;
    @JsonProperty("mandatory_verify")
    private Boolean mandatory_verify;
    @JsonProperty("enc_uid")
    private String encUid;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("dob")
    private String dob;
//    @JsonProperty("age")
//    private String age;
    @JsonProperty("network")
    private String network;
    @JsonProperty("fbid")
    private String fbid;
    @JsonProperty("registered_date")
    private String registeredDate;
    @JsonProperty("prostatus")
    private LoginProstatus prostatus;
    @JsonProperty("secondary_information")
    private SecondaryInformation secondary_information;
    @JsonProperty("device_status")
    private String deviceStatus;
    @JsonProperty("email")
    private String email;
    @JsonProperty("free_stream_limit")
    private String free_stream_limit;
    @JsonProperty("free_stream_counter")
    private Integer free_stream_counter;
    @JsonProperty("free_downloads_enabled")
    private Boolean free_downloads_enabled;
}
