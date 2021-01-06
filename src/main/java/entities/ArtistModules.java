/**
 * 
 */
package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pojos.Artist.ArtistURLs;
import pojos.Artist.SimilarArtists;
import pojos.Artist.TopAlbums;
import pojos.Artist.TopSongs;

import java.util.List;

/**
 * @author ashwinsriv
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
public class ArtistModules {

	@JsonProperty("topSongs")
	private ModuleWithViewMoreArray topSongs;
	@JsonProperty("latest_release")
	private ModuleWithViewMoreArray latest_release;
	@JsonProperty("topAlbums")
	private ModuleWithViewMoreArray topAlbums;
	@JsonProperty("artistPlaylists")
	private ModuleWithViewMoreArray artistPlaylists;
	@JsonProperty("dedicated_artist_playlist")
	private ModuleWithViewMoreArray dedicated_artist_playlist;
	@JsonProperty("featured_artist_playlist")
	private ModuleWithViewMoreArray featured_artist_playlist;
	@JsonProperty("singles")
	private ModuleWithViewMoreArray singles;
	@JsonProperty("similarArtists")
	private ModuleWithViewMoreArray similarArtists;
	@JsonProperty("triller")
	private ModuleWithViewMoreArray triller;
}
