package pojos.JiotuneHomePageData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.PlaylistMiniMoreInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter

public class JTPlaylistMoreInfo extends PlaylistMiniMoreInfo {

    @JsonProperty("primary_artists")
    private String primaryArtists;
    @JsonProperty("singers")
    private String singers;
    @JsonProperty("ctr")
    private Integer ctr;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("vcode")
    private String vcode;
    @JsonProperty("vlink")
    private String vlink;
}
