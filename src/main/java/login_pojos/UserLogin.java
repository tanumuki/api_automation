package login_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data", "prostatus" })
public class UserLogin {

	@JsonProperty("data")
	private LoginData data;
	@JsonProperty("prostatus")
	private LoginProstatus prostatus;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public UserLogin() {
	}

	/**
	 *
	 * @param data
	 * @param prostatus
	 */
	public UserLogin(LoginData data, LoginProstatus prostatus) {
		super();
		this.data = data;
		this.prostatus = prostatus;
	}

	@JsonProperty("data")
	public LoginData getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(LoginData data) {
		this.data = data;
	}

	@JsonProperty("prostatus")
	public LoginProstatus getProstatus() {
		return prostatus;
	}

	@JsonProperty("prostatus")
	public void setProstatus(LoginProstatus prostatus) {
		this.prostatus = prostatus;
	}

}