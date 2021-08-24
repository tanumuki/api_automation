package pojos.UpdatedLink;

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
public class GetUpdatedLink {

	public GetUpdatedLink(){}


	@JsonProperty("status")
	private String status;
	@JsonProperty("data")
	private UpdatedURL data;

}
