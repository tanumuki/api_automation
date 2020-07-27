package pojos.login_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.tools.xjc.reader.Util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import validators.Validate;




@JsonInclude(JsonInclude.Include.NON_NULL)



@Data
@Getter
@Setter
public  class LoginData {

	public LoginData() {
		super();
	}
	
	
	@JsonProperty("username")
	private String username;
	@JsonProperty("uid")
	private String uid;
	@JsonProperty("fbid")
	private String fbid;
	@JsonProperty("email")
	private String email;
	@JsonProperty("phone_number")
	private String phoneNumber;
	@JsonProperty("fbtoken")
	private String fbtoken;
	@JsonProperty("regdate")
	private String regdate;
	@JsonProperty("status")
	private String status;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("dob")
	private String dob;
	@JsonProperty("birthyear")
	private String birthyear;
	@JsonProperty("network")
	private Object network;
	@JsonProperty("following_count")
	private String followingCount;
	@JsonProperty("follower_count")
	private String followerCount;
	@JsonProperty("update_time")
	private String updateTime;
	@JsonProperty("paywall_only")
	private String paywallOnly;
	@JsonProperty("loginwall")
	private String loginwall;
	
	
	
	public boolean validateNull() {
		
		if(!Validate.isNonEmptyString(phoneNumber)) {
			System.out.println("****************************");
			System.out.println("Phone is empty");
			return false;
		}
		return true;

	}

	
}