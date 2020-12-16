package pojos.user_pojos.UserChangePassword;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class UserChangePasswordFailure {

    @JsonProperty("status")
    private String status;
    @JsonProperty("error")
    private FailureMessageJson error;
}
