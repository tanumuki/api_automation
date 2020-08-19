package pojos.channelGetDetailsPojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.EditorsNote;
import entities.Tags;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ChannelGetDetailsMoreInfo {

    @JsonProperty("editors_note")
    private EditorsNote editorsNote;
    @JsonProperty("is_followed")
    private String isFollowed;
    @JsonProperty("follower_count")
    private String followerCount;
    @JsonProperty("can_start_radio")
    private String canStartRadio;
    @JsonProperty("tags")
    private Tags tags;
    @JsonProperty("sub_type")
    private String subType;
    @JsonProperty("available")
    private String available;

}
