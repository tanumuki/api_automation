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
public class UserChangePasswordSuccess {

    @JsonProperty("status")
    private String status;
    @JsonProperty("success")
    private ResponseMessageJson success;
}
