package pojos.user_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class SongsMoreInfo {

    public SongsMoreInfo() {
    }

    @JsonProperty("music")
    private String music;
    @JsonProperty("album_id")
    private String album_id;
    @JsonProperty("album")
    private String album;
    @JsonProperty("label")
    private String label;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("320kbps")
    private String threeTwentykbps;
    @JsonProperty("encrypted_media_url")
    private String encrypted_media_url;
    @JsonProperty("encrypted_cache_url")
    private String encrypted_cache_url;
    @JsonProperty("album_url")
    private String album_url;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("rights")
    private SongRightsData rights;
    @JsonProperty("cache_state")
    private String cache_state;
    @JsonProperty("has_lyrics")
    private String has_lyrics;
    @JsonProperty("lyrics_snippet")
    private String lyrics_snippet;
    @JsonProperty("starred")
    private String starred;
    @JsonProperty("copyright_text")
    private String copyright_text;
    @JsonProperty("artistMap")
    private SongsArtistMap artistMap;
    @JsonProperty("release_date")
    private String release_date;
    @JsonProperty("label_url")
    private String label_url;
    @JsonProperty("vcode")
    private String vcode;
    @JsonProperty("vlink")
    private String vlink;
    @JsonProperty("lyrics_id")
    private String lyrics_id;
    @JsonProperty("geo_rules")
    private String [] geo_rules;
    @JsonProperty("square_image_url")
    private String square_image_url;
    @JsonProperty("label_id")
    private String label_id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("season_no")
    private String season_no;
    @JsonProperty("show_id")
    private String show_id;
    @JsonProperty("season_id")
    private String season_id;
    @JsonProperty("show_title")
    private String show_title;
    @JsonProperty("season_title")
    private String season_title;
    @JsonProperty("square_image")
    private String square_image;
    @JsonProperty("episode_number")
    private String episode_number;
    @JsonProperty ("ad_breaks")
    private String ad_breaks;
    @JsonProperty("show_url")
    private String show_url;
}
