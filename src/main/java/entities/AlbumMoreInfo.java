/**
 * 
 */
package entities;

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
public class AlbumMoreInfo {
	
	@JsonProperty("artistMap")
	private ArtistMap artistMap;
	@JsonProperty("query")
	private String query;
	@JsonProperty("text")
	private String text;
	@JsonProperty("music")
	private String music;
	@JsonProperty("song_count")
	private String songCount;
	@JsonProperty("copyright_text")
	private String copyrightText;
	@JsonProperty("release_date")
	private String release_date;
	@JsonProperty("mini_obj")
	private String miniObj;

}
