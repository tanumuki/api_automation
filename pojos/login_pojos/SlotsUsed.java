package login_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name" })



@Data
@Getter
@Setter
public class SlotsUsed {
	
	

	public SlotsUsed() {
		super();
	}
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
}