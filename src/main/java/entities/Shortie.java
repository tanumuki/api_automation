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
public class Shortie {

	@JsonProperty("duration")
	private int duration;
	@JsonProperty("is_primary")
	private Boolean is_primary;
	@JsonProperty("media_url")
	private String media_url;
	@JsonProperty("image")
	private String image;
}
