/**
 * 
 */
package search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@Getter
@Setter
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

	

}