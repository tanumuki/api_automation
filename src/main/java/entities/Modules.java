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
public class Modules {

    @JsonProperty("list")
    private ModuleWithViewMoreArray list;
    @JsonProperty("reco")
    private ModuleWithViewMoreArray reco;
    @JsonProperty("videos")
    private  ModuleWithViewMoreArray videos;
    @JsonProperty("topAlbumsFromSameYear")
    private  ModuleWithViewMoreArray topAlbumsFromSameYear;
    @JsonProperty("relatedPlaylist")
    private ModuleWithViewMoreArray relatedPlaylist;

}
