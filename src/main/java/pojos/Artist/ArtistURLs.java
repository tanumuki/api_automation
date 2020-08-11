/**
 * 
 */
package pojos.Artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ashwinsriv
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
public class ArtistURLs {

	@JsonProperty("albums")
	private String albums;
	@JsonProperty("bio")
	private String bio;
	@JsonProperty("comments")
	private String comments;
	@JsonProperty("songs")
	private String songs;
}
