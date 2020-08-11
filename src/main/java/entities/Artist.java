/**
 * 
 */
package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.Artist.SimilarArtists;
import pojos.Artist.ArtistURLs;

import java.util.List;

/**
 * @author aswingokulachandran
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
public class Artist extends Entity{

	@JsonProperty("artistId")
	private String artistId;
//	@JsonProperty("id")
//	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("role")
	private String role;
	@JsonProperty("image")
	private String image;
	@JsonProperty("ctr")
	private Integer ctr;
	@JsonProperty("entity")
	private Integer entity;
	@JsonProperty("mini_obj")
	private Boolean mini_obj;
//	@JsonProperty("type")
//	private String type;
//	@JsonProperty("perma_url")
//	private String permaUrl;
	@JsonProperty("follower_count")
	private String follower_count;
	@JsonProperty("isVerified")
	private String isVerified;
	@JsonProperty("dominantLanguage")
	private String dominantLanguage;
	@JsonProperty("dominantType")
	private String dominantType;
	@JsonProperty("topSongs")
	private TopSongs topSongs;
	@JsonProperty("topAlbums")
	private TopAlbums topAlbums;
	@JsonProperty("similarArtists")
	private List<SimilarArtists> similarArtists;
	@JsonProperty("isRadioPresent")
	private String isRadioPresent;
	@JsonProperty("bio")
	private String bio;
	@JsonProperty("dob")
	private String dob;
	@JsonProperty("fb")
	private String fb;
	@JsonProperty("twitter")
	private String twitter;
	@JsonProperty("wiki")
	private String wiki;
	@JsonProperty("urls")
	private ArtistURLs urls;
	@JsonProperty("availableLanguages")
	private List<String> availableLanguages;
	@JsonProperty("artistPlaylists")
	private List<Playlist> artistPlaylists;
	@JsonProperty("fan_count")
	private String fan_count;
	@JsonProperty("is_followed")
	private String is_followed;
}
