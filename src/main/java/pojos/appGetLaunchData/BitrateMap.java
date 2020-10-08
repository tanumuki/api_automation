package pojos.appGetLaunchData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class BitrateMap {
    @JsonProperty("12")
    private Bitrate br12;
    @JsonProperty("48")
    private Bitrate br48;
    @JsonProperty("96")
    private Bitrate br96;
    @JsonProperty("160")
    private Bitrate br160;
    @JsonProperty("320")
    private Bitrate br320;
}
