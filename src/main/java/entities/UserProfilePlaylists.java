package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class UserProfilePlaylists extends Entity {
    @JsonProperty("list")
    private String list;
    @JsonProperty("more_info")
    private PlaylistMoreInfo more_info;
}
