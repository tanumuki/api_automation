package pojos.login_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import validators.Validate;


@JsonInclude(JsonInclude.Include.NON_NULL)


@Data
@Getter
@Setter
public class LoginData {

    public LoginData() {
        super();
    }

    @JsonProperty("username")
    public String username;
    @JsonProperty("uid")
    public String uid;
    @JsonProperty("fbid")
    public String fbid;
    @JsonProperty("email")
    public String email;
    @JsonProperty("phone_number")
    public String phoneNumber;
    @JsonProperty("fbtoken")
    public String fbtoken;
    @JsonProperty("regdate")
    public String regdate;
    @JsonProperty("status")
    public String status;
    @JsonProperty("lastname")
    public String lastname;
    @JsonProperty("firstname")
    public String firstname;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("dob")
    public String dob;
    @JsonProperty("birthyear")
    public String birthyear;
    @JsonProperty("network")
    public String network;
    @JsonProperty("following_count")
    public String followingCount;
    @JsonProperty("follower_count")
    public String followerCount;
    @JsonProperty("update_time")
    public String updateTime;
    @JsonProperty("require_otp")
    public Boolean requireOtp;
    @JsonProperty("mandatory_verify")
    public Boolean mandatoryVerify;
    @JsonProperty("email_verified_status")
    public String emailVerifiedStatus;
    @JsonProperty("paywall_only")
    public String paywallOnly;
    @JsonProperty("loginwall")
    public String loginwall;

    public boolean validateNull() {

        if (!Validate.isNonEmptyString(phoneNumber)) {
            System.out.println("****************************");
            System.out.println("Phone is empty");
            return false;
        }
        return true;

    }


}