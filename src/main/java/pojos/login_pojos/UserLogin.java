package pojos.login_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@JsonInclude(JsonInclude.Include.NON_NULL)

@Data
@Getter
@Setter
public class UserLogin {
	
	
	
	
	
	public UserLogin() {
		super();
	}
	
	
	@JsonProperty("data")
	private LoginData data;
	@JsonProperty("prostatus")
	private LoginProstatus prostatus;
	


}