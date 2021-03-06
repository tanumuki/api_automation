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
public class Album extends Entity {
	@JsonProperty("list")
	private Object list = null;
	@JsonProperty("more_info")
	private AlbumMoreInfo moreInfo;
	@JsonProperty("modules")
	private Modules modules;
	@JsonProperty("description")
	private String description;
}
