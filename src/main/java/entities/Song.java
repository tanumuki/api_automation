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
public class Song extends Entity {
	
	
	@JsonProperty("list")
	private String list;
	@JsonProperty("more_info")
	private SongMoreInfo moreInfo;

}
