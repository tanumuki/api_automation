package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class ArtistMap {

    @JsonProperty("primary_artists")
    private List<PrimaryArtist> primaryArtists = null;
    @JsonProperty("featured_artists")
    private List<Object> featuredArtists = null;
    @JsonProperty("artists")
    private List<Artist> artists = null;

}