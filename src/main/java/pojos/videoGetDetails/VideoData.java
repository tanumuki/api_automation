package pojos.videoGetDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import entities.VideoMoreInfo;
import lombok.Getter;
import lombok.Setter;

@lombok.Data
@Getter
@Setter
public class VideoData extends Entity {

    @JsonProperty("list")
    public String list;
    @JsonProperty("more_info")
    public VideoMoreInfo videoMoreInfo;

}