/**
 * 
 */
package pojos.Artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ashwinsriv
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Data
public class SimilarArtistsContainer {

	@JsonProperty("status")
	private String status;
	@JsonProperty("data")
	private List<SimilarArtists> data;
}
