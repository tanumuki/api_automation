package pojos.SocialFollow;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import entities.PlaylistMini;
import entities.RadioStation;
import entities.Song;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter

public class GetFollowingDetails extends Entity{
    @JsonProperty("status")
    private String status;
    @JsonProperty("follow")
    private List<GetFollowDetails> follow;
    @JsonProperty("counts")
    private FollowingCount counts;
}
