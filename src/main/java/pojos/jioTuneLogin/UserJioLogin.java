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
    private LoginData data;
    @JsonProperty("jio_trial_redeem")
    private String jioTrialRedeem;
    @JsonProperty("jio_trial_duration")
    private String jioTrialDuration;
    @JsonProperty("jio_user_data")
    private JioUserData jioUserData;
}
