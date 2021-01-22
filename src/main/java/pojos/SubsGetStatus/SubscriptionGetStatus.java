package pojos.SubsGetStatus;

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
public class SubscriptionGetStatus {
    @JsonProperty("prostatus")
    private LoginProstatus prostatus;
    @JsonProperty("receipt")
    private String receipt;
}
