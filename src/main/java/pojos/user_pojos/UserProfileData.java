package pojos.user_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class UserProfileData {
    public UserProfileData() {
    }

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty ("lastname")
    private String lastname;

    @JsonProperty("dob")
    private String dob;

    @JsonProperty("gender")
    private String gender;
}
