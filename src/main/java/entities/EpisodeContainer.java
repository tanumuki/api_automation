package entities;

/**
 * @author ashwinsriv
 *
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class EpisodeContainer extends Entity{

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private List<Episode> data;

}
