package login_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data", "prostatus" })

@Data
@Builder
public class UserLogin {
	
	@JsonProperty("data")
	private LoginData data;
	@JsonProperty("prostatus")
	private LoginProstatus prostatus;
	


}