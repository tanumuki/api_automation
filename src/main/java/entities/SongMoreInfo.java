package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.Videos.ThirdPartyVideo;

import java.util.List;

/**
 * @author aswingokulachandran
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class SongMoreInfo {

	@JsonProperty("music")
	private String music;
	@JsonProperty("album_id")
	private String albumId;
	@JsonProperty("album")
	private String album;
	@JsonProperty("label")
	private String label;
	@JsonProperty("origin")
	private String origin;
	@JsonProperty("320kbps")
	private String _320kbps;
	@JsonProperty("encrypted_media_url")
	private String encryptedMediaUrl;
	@JsonProperty("thumbnail_url")
	private String thumbnail_url;
	@JsonProperty("encrypted_cache_url")
	private String encryptedCacheUrl;
	@JsonProperty("album_url")
	private String albumUrl;
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
	private List<String> song_mappings;
	@JsonProperty("vcode")
	private String vcode;
	@JsonProperty("vlink")
	private String vlink;
	@JsonProperty("video_rate_cap")
	private String video_rate_cap;
	@JsonProperty("preview_url")
	private String preview_url;
	@JsonProperty("lyrics_id")
	private String lyricsId;
	@JsonProperty("geo_rules")
	private String[] geo_rules;
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
	@JsonProperty("ad_breaks")
	private String ad_breaks;
	@JsonProperty("show_url")
	private String show_url;
	@JsonProperty("ctr")
	private Integer ctr;
	@JsonProperty("score")
	private Double score;
	@JsonProperty("primary_artists")
	private String primary_artists;
	@JsonProperty("singers")
	private String singers;
	@JsonProperty("video_available")
	private Boolean video_available;
	@JsonProperty("third_party_video_available")
	private Boolean third_party_video_available;
	@JsonProperty("third_party_video_partners")
	private List<String> third_party_video_partners;
	@JsonProperty("third_party_videos")
	private List<ThirdPartyVideo> third_party_videos;
	@JsonProperty("triller_available")
	private Boolean triller_available;
	@JsonProperty("video_thumbnail")
	private String video_thumbnail;
	@JsonProperty("shortie")
	private Shortie shortie;
	@JsonProperty("triller")
	private List<Triller> triller;
	@JsonProperty("language")
	private String language;
	@JsonProperty("is_dolby_content")
	private Boolean is_dolby_content;
	@JsonProperty("video_mappings")
	private String [] video_mappings;
	@JsonProperty("multiple_tunes")
	private List<MultipleTunes> multiPleTunes;
	@JsonProperty("content_category")
	private String contentCategory;
}
