package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class ModulesSourceParams {
    @JsonProperty("albumid")
    private String albumid;
    @JsonProperty("p")
    private Integer page;
    @JsonProperty("n")
    private Integer numItems;
    @JsonProperty("video_pids")
    private String video_pids;
    @JsonProperty("album_year")
    private String album_year;

}
