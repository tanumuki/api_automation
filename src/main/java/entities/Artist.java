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
import pojos.Artist.TopAlbums;
import pojos.Artist.TopSongs;

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
	@JsonProperty("id")
	private String id;
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
	@JsonProperty("follower_count")
	private String follower_count;
	@JsonProperty("isVerified")
	private Boolean isVerified;
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
	private boolean isRadioPresent;
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
	private List<PlaylistMini> artistPlaylists;
	@JsonProperty("dedicated_artist_playlist")
	private List<PlaylistMini> dedicatedArtistPlaylist;
	@JsonProperty("featured_artist_playlist")
	private List<PlaylistMini> featuredArtistPlaylist;
	@JsonProperty("singles")
	private List<Album> singles;
	@JsonProperty("latest_release")
	private List<Album> latestReleases;
	@JsonProperty("modules")
	private ArtistModules modules;
	@JsonProperty("fan_count")
	private String fan_count;
	@JsonProperty("topEpisodes")
	private List<String> topEpisodes;
	@JsonProperty("is_followed")
	private boolean is_followed;
	@JsonProperty("triller")
	private List<Song> triller;
	@JsonProperty("extra")
	private String extra;
	@JsonProperty("description")
	private String description;
	@JsonProperty("position")
	private Integer position;
	@JsonProperty("image_url")
	private String image_url;
	@JsonProperty("artist_videos")
	private List<Song> artist_videos;
	@JsonProperty("type")
	private String type;
}
