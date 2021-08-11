package pojos.jioTuneLogin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.login_pojos.LoginData;

@Setter
@Getter
@Data
public class UserJioLogin {

    @JsonProperty("data")
    public LoginData data;
    @JsonProperty("jio_trial_redeem")
    public String jioTrialRedeem;
    @JsonProperty("jio_trial_duration")
    public String jioTrialDuration;
    @JsonProperty("jio_user_data")
    public JioUserData jioUserData;
}
