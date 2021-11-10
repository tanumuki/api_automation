package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Rights;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class VideoStationMiniObjectMoreInfo {

    @JsonProperty("music")
    private String music;
    @JsonProperty("label")
    private String label;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("encrypted_media_url")
    private String encryptedMediaUrl;
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("rights")
    private Rights rights;
    @JsonProperty("cache_state")
    private String cacheState;
    @JsonProperty("has_lyrics")
    private String hasLyrics;
    @JsonProperty("lyrics_snippet")
    private String lyricsSnippet;
    @JsonProperty("starred")
    private String starred;
    @JsonProperty("copyright_text")
    private String copyrightText;
    @JsonProperty("artistMap")
    private ArtistMap artistMap;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("song_mappings")
    private List<String> songMappings = null;
    @JsonProperty("vcode")
    private String vcode;
    @JsonProperty("vlink")
    private String vlink;
    @JsonProperty("video_rate_cap")
    private Integer videoRateCap;
    @JsonProperty("preview_url")
    private String previewUrl;
}
