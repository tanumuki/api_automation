/**
 * 
 */
package pojos.Artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Song;
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
public class TopSongs {

	@JsonProperty("songs")
	private List<Song> songs;
	@JsonProperty("total")
	private int total;
	@JsonProperty("last_page")
	private Boolean last_page;


}
