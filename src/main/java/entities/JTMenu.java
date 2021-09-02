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
 * @author snigdhamajee
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Getter
@Setter
public class JTMenu extends Entity {

	@JsonProperty("source_api")
	private Boolean sourceAPI;
	@JsonProperty("source")
	private String source;
	@JsonProperty("source_view")
	private String source_view;
	@JsonProperty("search_api")
	private String search_api;
	@JsonProperty("search_placeholder")
	private String search_placeholder;
	@JsonProperty("source_params")
	private ModulesSourceParams source_params;
}
