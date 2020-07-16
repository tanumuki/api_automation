package login_pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "username", "uid", "fbid", "email", "phone_number", "fbtoken", "regdate", "status", "lastname",
		"firstname", "gender", "dob", "birthyear", "network", "following_count", "follower_count", "update_time",
		"paywall_only", "loginwall" })
public class LoginData {

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

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public LoginData() {
	}

	/**
	 *
	 * @param firstname
	 * @param gender
	 * @param birthyear
	 * @param loginwall
	 * @param updateTime
	 * @param followingCount
	 * @param lastname
	 * @param network
	 * @param fbtoken
	 * @param uid
	 * @param phoneNumber
	 * @param dob
	 * @param fbid
	 * @param regdate
	 * @param paywallOnly
	 * @param followerCount
	 * @param email
	 * @param username
	 * @param status
	 */
	public LoginData(String username, String uid, String fbid, String email, String phoneNumber, String fbtoken,
			String regdate, String status, String lastname, String firstname, String gender, String dob,
			String birthyear, Object network, String followingCount, String followerCount, String updateTime,
			String paywallOnly, String loginwall) {
		super();
		this.username = username;
		this.uid = uid;
		this.fbid = fbid;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.fbtoken = fbtoken;
		this.regdate = regdate;
		this.status = status;
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
		this.dob = dob;
		this.birthyear = birthyear;
		this.network = network;
		this.followingCount = followingCount;
		this.followerCount = followerCount;
		this.updateTime = updateTime;
		this.paywallOnly = paywallOnly;
		this.loginwall = loginwall;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("uid")
	public String getUid() {
		return uid;
	}

	@JsonProperty("uid")
	public void setUid(String uid) {
		this.uid = uid;
	}

	@JsonProperty("fbid")
	public String getFbid() {
		return fbid;
	}

	@JsonProperty("fbid")
	public void setFbid(String fbid) {
		this.fbid = fbid;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phone_number")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonProperty("fbtoken")
	public String getFbtoken() {
		return fbtoken;
	}

	@JsonProperty("fbtoken")
	public void setFbtoken(String fbtoken) {
		this.fbtoken = fbtoken;
	}

	@JsonProperty("regdate")
	public String getRegdate() {
		return regdate;
	}

	@JsonProperty("regdate")
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("lastname")
	public String getLastname() {
		return lastname;
	}

	@JsonProperty("lastname")
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@JsonProperty("firstname")
	public String getFirstname() {
		return firstname;
	}

	@JsonProperty("firstname")
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@JsonProperty("gender")
	public String getGender() {
		return gender;
	}

	@JsonProperty("gender")
	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonProperty("dob")
	public String getDob() {
		return dob;
	}

	@JsonProperty("dob")
	public void setDob(String dob) {
		this.dob = dob;
	}

	@JsonProperty("birthyear")
	public String getBirthyear() {
		return birthyear;
	}

	@JsonProperty("birthyear")
	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}

	@JsonProperty("network")
	public Object getNetwork() {
		return network;
	}

	@JsonProperty("network")
	public void setNetwork(Object network) {
		this.network = network;
	}

	@JsonProperty("following_count")
	public String getFollowingCount() {
		return followingCount;
	}

	@JsonProperty("following_count")
	public void setFollowingCount(String followingCount) {
		this.followingCount = followingCount;
	}

	@JsonProperty("follower_count")
	public String getFollowerCount() {
		return followerCount;
	}

	@JsonProperty("follower_count")
	public void setFollowerCount(String followerCount) {
		this.followerCount = followerCount;
	}

	@JsonProperty("update_time")
	public String getUpdateTime() {
		return updateTime;
	}

	@JsonProperty("update_time")
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@JsonProperty("paywall_only")
	public String getPaywallOnly() {
		return paywallOnly;
	}

	@JsonProperty("paywall_only")
	public void setPaywallOnly(String paywallOnly) {
		this.paywallOnly = paywallOnly;
	}

	@JsonProperty("loginwall")
	public String getLoginwall() {
		return loginwall;
	}

	@JsonProperty("loginwall")
	public void setLoginwall(String loginwall) {
		this.loginwall = loginwall;
	}

}