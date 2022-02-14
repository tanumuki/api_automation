package pojos.userIsSame;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class UserIsSameDetails extends Entity {

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private GetUserDetails data;
}
