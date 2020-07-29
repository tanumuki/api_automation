package pojos.user_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class UserGetProfileFollowingData {
    public UserGetProfileFollowingData() {
    }

    @JsonProperty("usersCount")
    private String usersCount;
    @JsonProperty("artistsCount")
    private String artistsCount;
    @JsonProperty("playlistsCount")
    private String playlistsCount;
}
