/**
 * 
 */
package entities;

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
@Data
@Getter
@Setter
public class TopAlbums {

	@JsonProperty("albums")
	private List<AlbumMiniObject> albums;

	@JsonProperty("total")
	private int total;

}
