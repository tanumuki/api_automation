package pojos.podcastGetNT;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.ArtistMap;
import entities.ShowMoreInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class PodcastNTMoreInfo extends ShowMoreInfo {

    @JsonProperty("_id")
    private PodcastIDClass _id;
    @JsonProperty("copyright_text")
    private String copyrightText;
    @JsonProperty("m4a")
    private String m4a;
    @JsonProperty("artist_map")
    private ArtistMap artist_map;


}
