package pojos.user_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class SongsArtistMap {
    public SongsArtistMap() {
    }

    @JsonProperty("primary_artists")
    private List<SongsArtists> primary_artists;
    @JsonProperty("featured_artists")
    private List<SongsArtists> featured_artists;
    @JsonProperty("artists")
    private List<SongsArtists> artists;
}
