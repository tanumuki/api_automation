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
	@JsonProperty("vcode")
	private String vcode;
	@JsonProperty("vlink")
	private String vlink;
	@JsonProperty("lyrics_id")
	private String lyricsId;

}
