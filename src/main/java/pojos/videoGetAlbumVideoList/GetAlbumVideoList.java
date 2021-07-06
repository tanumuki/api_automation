package pojos.videoGetAlbumVideoList;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pojos.videoGetDetails.VideoData;

import java.util.List;

@lombok.Data
@Getter
@Setter
public class GetAlbumVideoList {

    @JsonProperty("status")
    public String status;
    @JsonProperty("data")
    public List<VideoData> data ;
}
