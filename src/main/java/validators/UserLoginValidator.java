package validators;

import java.util.List;

import org.json.JSONObject;
import org.testng.asserts.SoftAssert;

import lombok.extern.slf4j.Slf4j;
import pojos.login_pojos.LoginData;
import pojos.login_pojos.LoginProstatus;
import pojos.login_pojos.SlotsUsed;
import pojos.login_pojos.UserLogin;


@Slf4j
public class UserLoginValidator {

	String className = getClass().getName();

	public void validate(UserLogin login, SoftAssert sa) {
		
		
		JSONObject inputJSONOBject = new JSONObject(login);
		
		
//		String "validate " = getClass().getEnclosingMethod().getName();
		//JsonParser.getKey(inputJSONOBject, "phone_number");
		System.out.println("starting");
		
		if(Validate.isNonEmptyString(login.getProstatus().getProduct())) {
			String product = login.getProstatus().getProduct();
			System.out.println("product "+product);
			sa.assertTrue(Validate.asProduct(product), className + "." + "validate product failed - ");
		}
		else {
			log.info("product is NULL or empty");
		}

		
	
		LoginProstatus proStatus = login.getProstatus();

		// get product type

		// get product type
		if(Validate.isNonEmptyString(String.valueOf(login.getProstatus().getExpirationTimestamp()))) {
			Integer time = login.getProstatus().getExpirationTimestamp();
			sa.assertTrue(Validate.asTimeStamp(String.valueOf(time)), className + "." + "validate time failed - ");
			System.out.println("exp time stamp is " + time);
		

		}
		else {
			System.out.println("product is NULL or empty");
		}

		//get email

		if(Validate.isNonEmptyString(login.getData().getEmail())) {

			String email = login.getData().getEmail();
			System.out.println("email " + login.getData().getEmail());
			sa.assertTrue(Validate.asEmail(email), className + "." + "validate email failed - ");
		}
		else {
			System.out.println("Email field is NULL or empty");
		}


		// get network
		if(Validate.isNonEmptyString(login.getData().getNetwork())) {
			String network =  login.getData().getNetwork();
			System.out.println("network " + network);
				sa.assertTrue(Validate.asString(network), className + "." + "validate network failed - ");
		}
		else{
			System.out.println("Network field is NULL or empty");

		}
		//get phone no
		
		
	if(Validate.isNonEmptyString(login.getData().getPhoneNumber())) {
		sa.assertTrue(Validate.asString(login.getData().getPhoneNumber()), className + "." + "validate phone failed - ");
	}
	else {
		System.out.println("phone is NULL or empty");
	}


		// get fbid
		if(Validate.isNonEmptyString(login.getData().getFbid())){
			sa.assertTrue(Validate.asString(login.getData().getFbid()), className + "." +"validate FBID failed - ");
		}
		else{
			System.out.println("FBID is NULL or empty");
		}


		// get reg date
			if(Validate.isNonEmptyString(login.getData().getRegdate())){
				String regDate = login.getData().getRegdate();
				sa.assertTrue(Validate.asDateTime(regDate), className + "." + "validate regDate failed - ");
			}
			else{
				System.out.println("Reg date is NULL or empty");
			}




		// username
			if(Validate.isNonEmptyString(login.getData().getUsername())){
				String username = login.getData().getRegdate();
				sa.assertTrue(Validate.asString(username), className + "." + "validate username failed - ");
			}
			else{
				System.out.println("User name is NULL or empty");
			}




		// uid
			if(Validate.isNonEmptyString(login.getData().getUid())){
				String uid = login.getData().getUid();
				sa.assertTrue(Validate.asId(uid), className + "." + "validate uid failed - ");
			}
			else{
				System.out.println(" UID is NULL or empty");
			}


		// phone number
			if(Validate.isNonEmptyString(login.getData().getPhoneNumber())){
				String ph = login.getData().getPhoneNumber();
				sa.assertTrue(Validate.asString(ph), className + "." + "validate ph failed - ");
			}
			else{
				System.out.println(" phone is NULL or empty");
			}
		

		// fb token
			if(Validate.isNonEmptyString(login.getData().getFbtoken())){
				String fbtoken = login.getData().getFbtoken();
				sa.assertTrue(Validate.asString(fbtoken), className + "." + "validate fbToken failed - ");
			}
			else{
				System.out.println(" FB TOKEN is NULL or empty");
			}



		// status
			if(Validate.isNonEmptyString(login.getData().getStatus())){
				String status = login.getData().getStatus();
				sa.assertTrue(Validate.asString(status), className + "." + "validate status failed - ");
			}
			else{
				System.out.println(" Status is NULL or empty");
			}


		// lastname
			if(Validate.isNonEmptyString(login.getData().getLastname())){
				String lastname = login.getData().getLastname();
				sa.assertTrue(Validate.asString(lastname), className + "." + "validate lastname failed - ");
			}
			else{
				System.out.println(" lastname is NULL or empty");
			}

		// first name

			if(Validate.isNonEmptyString(login.getData().getFirstname())){
				String firstname = login.getData().getFirstname();
				sa.assertTrue(Validate.asString(firstname), className + "." + "validate firstname failed - ");
			}
			else{
				System.out.println(" firstname is NULL or empty");
			}


		// gender

			if(Validate.isNonEmptyString(login.getData().getGender())){
				String gender = login.getData().getGender();
				sa.assertTrue(Validate.asGender(gender), className + "." + "validate gender failed - ");
			}
			else{
				System.out.println(" gender is NULL or empty");
			}

		// dob

			if(Validate.isNonEmptyString(login.getData().getDob())){
				String dob = login.getData().getDob();
				sa.assertTrue(Validate.asDate(dob), className + "." + "validate dob failed - ");
			}
			else{
				System.out.println(" DOB is NULL or empty");
			}


		// birthyear

			if(Validate.isNonEmptyString(login.getData().getBirthyear())){
				String birthyear = login.getData().getBirthyear();
				sa.assertTrue(Validate.asDate(birthyear), className + "." + "validate birthyear failed - ");
			}
			else{
				System.out.println(" birthyear is NULL or empty");
			}


		// following_count

			if(Validate.isNonEmptyString(login.getData().getFollowingCount())){
				String followingCount = login.getData().getFollowingCount();
				sa.assertTrue(Validate.asNum(followingCount), className + "." + "validate following_count failed - ");
			}
			else{
				System.out.println(" following count is NULL or empty");
			}


		// follower_count
			if(Validate.isNonEmptyString(login.getData().getFollowerCount())){
				String followerCount = login.getData().getFollowerCount();
				sa.assertTrue(Validate.asNum(followerCount), className + "." + "validate follower_count failed - ");
			}
			else {
				System.out.println(" follower count is NULL or empty");
			}

		// update_time
			if(Validate.isNonEmptyString(login.getData().getUpdateTime())){
				String updateTime = login.getData().getUpdateTime();
				sa.assertTrue(Validate.asDateTime(updateTime), className + "." + "validate update_time failed - ");
			}
			else {
				System.out.println(" updateTime  is NULL or empty");
			}


		// paywall_only

			if(Validate.isNonEmptyString(login.getData().getPaywallOnly())){
				String paywallOnly = login.getData().getPaywallOnly();
				sa.assertTrue(Validate.asBoolean(paywallOnly), className + "." + "validate paywall_only failed - ");
			}
			else {
				System.out.println(" paywall only  is NULL or empty");
			}


		// loginwall
			if(Validate.isNonEmptyString(login.getData().getLoginwall())){
				String loginwall = login.getData().getLoginwall();
				sa.assertTrue(Validate.asBoolean(loginwall), className + "." + "validate loginwall failed - ");
			}
			else {
				System.out.println(" loginwall   is NULL or empty");
			}


		// pro status type
			if(Validate.isNonEmptyString(proStatus.getType())){
				String type = proStatus.getType();
				sa.assertTrue(Validate.asString(type), className + "." + "validate type failed - ");
			}
			else {
				System.out.println(" pro status Type  is NULL or empty");
			}

		// pro status offer_trial
			if(Validate.isNonEmptyString(proStatus.getOfferTrial())){
				String offerTrial = proStatus.getOfferTrial();
				sa.assertTrue(Validate.asString(offerTrial), className + "." + "validate offer_trial failed - ");
			}
			else {
				System.out.println(" Offer trial  is NULL or empty");
			}


		//slots used


		List<SlotsUsed> slots = proStatus.getSlotsUsed();
		for(SlotsUsed su : slots) {
			String id = su.getId();
			System.out.println("id: " + id);
			sa.assertTrue(Validate.asString(id), className + "." + "validate id failed - ");
			
			String name = su.getName();
			System.out.println("name: " + name);
			sa.assertTrue(Validate.asString(name), className + "." + "validate name failed - ");
		}

		//vendor
			if(Validate.isNonEmptyString(proStatus.getVendor())){
				String vendor = proStatus.getVendor();
				sa.assertTrue(Validate.asString(vendor), className + "." + "validate vendor failed - ");
			}
			else {
				System.out.println(" Vendor  is NULL or empty");
			}


	}

	public void validateErrorMessage(UserLogin login, SoftAssert sa) {
	System.out.println(" error message");



	}
}


