package pojos.JiotuneHomePageData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ModulesData;
import entities.PlaylistMini;
import entities.Song;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class JiotuneHomePageData {
    @JsonProperty("data_0")
    private List<Song> data_0;
    @JsonProperty("data_1")
    private List<JTPlaylistEmptyMI> data_1;
    @JsonProperty("data_2")
    private List<JiotunePlaylistObj> data_2;
    @JsonProperty("data_3")
    private List<JiotunePlaylistObj> data_3;
    @JsonProperty("data_4")
    private List<JiotunePlaylistObj> data_4;
    @JsonProperty("modules")
    private List<ModulesData> modules;
}
