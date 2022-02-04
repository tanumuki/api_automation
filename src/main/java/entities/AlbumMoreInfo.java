/**
 * 
 */
package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aswingokulachandran
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class AlbumMoreInfo {
	
	@JsonProperty("artistMap")
	private ArtistMap artistMap;
	@JsonProperty("query")
	private String query;
	@JsonProperty("text")
	private String text;
	@JsonProperty("music")
	private String music;
	@JsonProperty("song_count")
	private String songCount;
	@JsonProperty("copyright_text")
	private String copyrightText;
	@JsonProperty("release_date")
	private String release_date;
	@JsonProperty("mini_obj")
	private String miniObj;
	@JsonProperty("ctr")
	private Integer ctr;
	@JsonProperty("year")
	private String year;
	@JsonProperty("is_movie")
	private String isMovie;
	@JsonProperty("language")
	private String language;
	@JsonProperty("song_pids")
	private String songPids;
	@JsonProperty("is_dolby_content")
	private Boolean is_dolby_content;
	@JsonProperty("release_year")
	private Integer release_year;
	@JsonProperty("video_mappings")
	private String [] video_mappings;
	@JsonProperty("contents")
	private String contents;
	@JsonProperty("album_id") // Added for web-release 28.10.2021
	private String albumId;
	@JsonProperty("album")
	private String album;
	@JsonProperty("label")
	private String label;
	@JsonProperty("origin")
	private String origin;
	@JsonProperty("320kbps")
	private Boolean kbps320;
	@JsonProperty("encrypted_media_url")
	private String encrypted_media_url;
	@JsonProperty("encrypted_cache_url")
	private String encrypted_cache_url;
	@JsonProperty("album_url")
	private String album_url;
	@JsonProperty("duration")
	private String duration;
	@JsonProperty("rights")
	private Rights rights;
	@JsonProperty("cache_state")
	private String cache_state;
	@JsonProperty("has_lyrics")
	private Boolean has_lyrics;
	@JsonProperty("lyrics_snippet")
	private String lyrics_snippet;
	@JsonProperty("starred")
	private String starred;
	@JsonProperty("triller_available")
	private Boolean triller_available;
	@JsonProperty("vcode")
	private String vcode;
	@JsonProperty("vlink")
	private String vlink;
	@JsonProperty("isWeekly")
	private Boolean isWeekly;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("follower_count")
	private String followerCount;
	@JsonProperty("fan_count")
	private String fanCount;
	@JsonProperty("webp")
	private String webp;
}
