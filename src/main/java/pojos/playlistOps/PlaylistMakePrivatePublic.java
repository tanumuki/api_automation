package pojos.playlistOps;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Playlist;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PlaylistMakePrivatePublic {

    @JsonProperty("status")
    private String status;
    @JsonProperty("details")
    private Playlist details;
}
