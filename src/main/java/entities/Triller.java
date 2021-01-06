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
public class Triller {

	@JsonProperty("user_url")
	private String userURL;
	@JsonProperty("Media_url")
	private String Media_url;
	@JsonProperty("user_image")
	private String user_image;
	@JsonProperty("image")
	private String image;
	@JsonProperty("triller_id")
	private String triller_id;
	@JsonProperty("user_name")
	private String user_name;
	@JsonProperty("language")
	private String language;

}
