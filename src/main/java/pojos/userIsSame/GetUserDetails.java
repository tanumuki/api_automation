package pojos.userIsSame;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GetUserDetails {

    @JsonProperty("is_same")
    private Boolean is_same;
    @JsonProperty("is_popup")
    private Boolean is_popup;
    @JsonProperty("msg")
    private String msg;
}
