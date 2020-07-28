/**
 * 
 */
package entities;

import java.util.List;

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
public class ArtistMap {

	@JsonProperty("primary_artists")
	private List<Artist> primaryArtists = null;
	@JsonProperty("featured_artists")
	private List<Artist> featuredArtists = null;
	@JsonProperty("artists")
	private List<Artist> artists = null;
}
