package pojos.videoGetHomePage;

import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Rights;

import java.util.List;

public class VideoMiniObjectMoreInfo {

    @JsonProperty("music")
    public String music;
    @JsonProperty("label")
    public String label;
    @JsonProperty("origin")
    public String origin;
    @JsonProperty("encrypted_media_url")
    public String encryptedMediaUrl;
    @JsonProperty("thumbnail_url")
    public String thumbnailUrl;
    @JsonProperty("duration")
    public String duration;
    @JsonProperty("rights")
    public Rights rights;
    @JsonProperty("cache_state")
    public String cacheState;
    @JsonProperty("has_lyrics")
    public String hasLyrics;
    @JsonProperty("lyrics_snippet")
    public String lyricsSnippet;
    @JsonProperty("starred")
    public String starred;
    @JsonProperty("copyright_text")
    public String copyrightText;
    @JsonProperty("artistMap")
    public ArtistMap artistMap;
    @JsonProperty("release_date")
    public String releaseDate;
    @JsonProperty("song_mappings")
    public List<String> songMappings = null;
    @JsonProperty("vcode")
    public String vcode;
    @JsonProperty("vlink")
    public String vlink;
    @JsonProperty("video_rate_cap")
    public Integer videoRateCap;
    @JsonProperty("preview_url")
    public String previewUrl;
}
