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
public class Rights {
	
	@JsonProperty("code")
	private String code;
	@JsonProperty("cacheable")
	private String cacheable;
	@JsonProperty("delete_cached_object")
	private String deleteCachedObject;
	@JsonProperty("reason")
	private String reason;

}
