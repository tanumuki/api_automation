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
 * @author ashwinsriv
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class AlbumMiniObject extends Entity {

	public AlbumMiniObject(){}
	
	@JsonProperty("list")
	private String list;
	@JsonProperty("more_info")
	private AlbumMoreInfo moreInfo;
	@JsonProperty("modules")
	private Object modules;
	@JsonProperty("description")
	private String description;
}
