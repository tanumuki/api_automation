package entities;

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
public class ShowMini extends Entity {
    @JsonProperty("season_number")
    private Integer seasonNumber;
    @JsonProperty("artists")
    private List<Artist> artists = null;
    @JsonProperty("featured_artists")
    private List<Artist> featuredArtists = null;
    @JsonProperty("primary_artists")
    private List<Artist> primaryArtists = null;
    @JsonProperty("more_info")
    private ShowMoreInfo moreInfo;
}
