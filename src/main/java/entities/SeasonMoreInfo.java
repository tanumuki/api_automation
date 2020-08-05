package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SeasonMoreInfo {

    @JsonProperty("description")
    private String description;
    @JsonProperty("song_info")
    private String songInfo;
    @JsonProperty("show_id")
    private String showId;
    @JsonProperty("show_title")
    private String showTitle;
    @JsonProperty("numEpisodes")
    private String numEpisodes;
    @JsonProperty("encrypted_media_url")
    private String encryptedMediaUrl;
    @JsonProperty("season_number")
    private String seasonNumber;
    @JsonProperty("artistMap")
    private ArtistMap artistMap;
}
