/**
 * 
 */
package pojos.UpdatedLink;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import entities.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author snigdhamajee
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class UpdatedURL extends Entity {

	public UpdatedURL(){}


	@JsonProperty("url")
	private String url;

}
