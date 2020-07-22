/**
 * 
 */
package pojos.search;

/**
 * @author aswingokulachandran
 *
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "albums", "songs", "radios", "playlists", "artists", "topquery", "shows", "episodes" })
public class SearchResponse {

	@JsonProperty("albums")
	private SearchResultEntity albums;
	@JsonProperty("songs")
	private SearchResultEntity songs;
	@JsonProperty("radios")
	private SearchResultEntity radios;
	@JsonProperty("playlists")
	private SearchResultEntity playlists;
	@JsonProperty("artists")
	private SearchResultEntity artists;
	@JsonProperty("topquery")
	private SearchResultEntity topquery;
	@JsonProperty("shows")
	private SearchResultEntity shows;
	@JsonProperty("episodes")
	private SearchResultEntity episodes;

	@JsonProperty("albums")
	public SearchResultEntity getAlbums() {
		return albums;
	}

	@JsonProperty("albums")
	public void setAlbums(SearchResultEntity albums) {
		this.albums = albums;
	}

	public SearchResponse withAlbums(SearchResultEntity albums) {
		this.albums = albums;
		return this;
	}

	@JsonProperty("songs")
	public SearchResultEntity getSongs() {
		return songs;
	}

	@JsonProperty("songs")
	public void setSongs(SearchResultEntity songs) {
		this.songs = songs;
	}

	public SearchResponse withSongs(SearchResultEntity songs) {
		this.songs = songs;
		return this;
	}

	@JsonProperty("radios")
	public SearchResultEntity getRadios() {
		return radios;
	}

	@JsonProperty("radios")
	public void setRadios(SearchResultEntity radios) {
		this.radios = radios;
	}

	public SearchResponse withRadios(SearchResultEntity radios) {
		this.radios = radios;
		return this;
	}

	@JsonProperty("playlists")
	public SearchResultEntity getPlaylists() {
		return playlists;
	}

	@JsonProperty("playlists")
	public void setPlaylists(SearchResultEntity playlists) {
		this.playlists = playlists;
	}

	public SearchResponse withPlaylists(SearchResultEntity playlists) {
		this.playlists = playlists;
		return this;
	}

	@JsonProperty("artists")
	public SearchResultEntity getArtists() {
		return artists;
	}

	@JsonProperty("artists")
	public void setArtists(SearchResultEntity artists) {
		this.artists = artists;
	}

	public SearchResponse withArtists(SearchResultEntity artists) {
		this.artists = artists;
		return this;
	}

	@JsonProperty("topquery")
	public SearchResultEntity getTopquery() {
		return topquery;
	}

	@JsonProperty("topquery")
	public void setTopquery(SearchResultEntity topquery) {
		this.topquery = topquery;
	}

	public SearchResponse withTopquery(SearchResultEntity topquery) {
		this.topquery = topquery;
		return this;
	}

	@JsonProperty("shows")
	public SearchResultEntity getShows() {
		return shows;
	}

	@JsonProperty("shows")
	public void setShows(SearchResultEntity shows) {
		this.shows = shows;
	}

	public SearchResponse withShows(SearchResultEntity shows) {
		this.shows = shows;
		return this;
	}

	@JsonProperty("episodes")
	public SearchResultEntity getEpisodes() {
		return episodes;
	}

	@JsonProperty("episodes")
	public void setEpisodes(SearchResultEntity episodes) {
		this.episodes = episodes;
	}

	public SearchResponse withEpisodes(SearchResultEntity episodes) {
		this.episodes = episodes;
		return this;
	}

}