package validators;

import java.util.List;

import org.testng.asserts.SoftAssert;

import login_pojos.LoginProstatus;
import login_pojos.SlotsUsed;
import login_pojos.UserLogin;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class UserLoginValidator {

	String className = getClass().getName();

	public void validate(UserLogin login, SoftAssert sa) {
		
		
		
		
//		String "validate " = getClass().getEnclosingMethod().getName();
		String product = login.getProstatus().getProduct();
		sa.assertTrue(Validate.asProduct(product), className + "." + "validate product failed - ");
		log.info("LOG Product name " +product);
		System.out.println("product  is " + product);

		LoginProstatus proStatus = login.getProstatus();

		// get product type
		//System.out.println("Product Type: " + proStatus.getOfferTrial();

		Integer time = login.getProstatus().getExpirationTimestamp();
		sa.assertTrue(Validate.asTimeStamp(String.valueOf(time)), className + "." + "validate time failed - ");
		System.out.println("exp time stamp is " + time);

		// get data -email
		String email = login.getData().getEmail();
		System.out.println("email " + login.getData().getEmail());
		sa.assertTrue(Validate.asEmail(email), className + "." + "validate email failed - ");

		// get network
		String network = (String) login.getData().getNetwork();
		System.out.println("network " + login.getData().getNetwork());
		if(network != null)
			sa.assertTrue(Validate.asString(network), className + "." + "validate network failed - ");

		// get fbid
		String fbId = login.getData().getFbid();
		System.out.println("fb id " + login.getData().getFbid());
		sa.assertTrue(Validate.asId(fbId), className + "." + "validate fbId failed - ");

		// get reg date
		String regDate = login.getData().getRegdate();
		System.out.println("reg date " + login.getData().getRegdate());
		sa.assertTrue(Validate.asDateTime(regDate), className + "." + "validate regDate failed - ");

		// username
		String username = login.getData().getUsername();
		System.out.println("Username: " + username);
		sa.assertTrue(Validate.asString(username), className + "." + "validate username failed - ");

		// uid
		String uid = login.getData().getUid();
		System.out.println("Uid: " + uid);
		sa.assertTrue(Validate.asId(uid), className + "." + "validate uid failed - ");

		// phone number
		String ph = login.getData().getPhoneNumber();
		System.out.println("Ph: " + ph);
		sa.assertTrue(Validate.asString(ph), className + "." + "validate ph failed - ");

		// fb token
		String fbToken = login.getData().getFbtoken();
		System.out.println("fbToken: " + fbToken);
		sa.assertTrue(Validate.asString(fbToken), className + "." + "validate fbToken failed - ");

		// status
		String status = login.getData().getStatus();
		System.out.println("Status: " + status);
		sa.assertTrue(Validate.asString(status), className + "." + "validate status failed - ");

		// lastname
		String lastname = login.getData().getLastname();
		System.out.println("lastname: " + lastname);
		sa.assertTrue(Validate.asString(lastname), className + "." + "validate lastname failed - ");

		// first name
		String firstname = login.getData().getFirstname();
		System.out.println("firstname: " + firstname);
		sa.assertTrue(Validate.asString(firstname), className + "." + "validate firstname failed - ");

		// gender
		String gender = login.getData().getGender();
		System.out.println("gender: " + gender);
		sa.assertTrue(Validate.asString(gender), className + "." + "validate gender failed - ");

		// dob
		String dob = login.getData().getDob();
		System.out.println("dob: " + dob);
		sa.assertTrue(Validate.asDate(dob), className + "." + "validate dob failed - ");

		// birthyear
		String birthyear = login.getData().getBirthyear();
		System.out.println("birthyear: " + birthyear);
		sa.assertTrue(Validate.asDate(dob), className + "." + "validate birthyear failed - ");

		// following_count
		String following_count = login.getData().getFollowingCount();
		System.out.println("following_count: " + following_count);
		sa.assertTrue(Validate.asNum(following_count), className + "." + "validate following_count failed - ");

		// follower_count
		String follower_count = login.getData().getFollowerCount();
		System.out.println("follower_count: " + follower_count);
		sa.assertTrue(Validate.asNum(follower_count), className + "." + "validate follower_count failed - ");

		// update_time
		String update_time = login.getData().getUpdateTime();
		System.out.println("update_time: " + update_time);
		sa.assertTrue(Validate.asDateTime(update_time), className + "." + "validate update_time failed - ");

		// paywall_only
		String paywall_only = login.getData().getPaywallOnly();
		System.out.println("paywall_only: " + paywall_only);
		sa.assertTrue(Validate.asBoolean(paywall_only), className + "." + "validate paywall_only failed - ");

		// loginwall
		String loginwall = login.getData().getLoginwall();
		System.out.println("loginwall: " + loginwall);
		sa.assertTrue(Validate.asBoolean(loginwall), className + "." + "validate loginwall failed - ");

		// pro status type
		String type = proStatus.getType();
		System.out.println("type: " + type);
		sa.assertTrue(Validate.asString(type), className + "." + "validate type failed - ");

		// pro status offer_trial
		String offer_trial = proStatus.getOfferTrial();
		System.out.println("offer_trial: " + offer_trial);
		sa.assertTrue(Validate.asString(offer_trial), className + "." + "validate offer_trial failed - ");		

		List<SlotsUsed> slots = proStatus.getSlotsUsed();
		for(SlotsUsed su : slots) {
			String id = su.getId();
			System.out.println("id: " + id);
			sa.assertTrue(Validate.asString(id), className + "." + "validate id failed - ");
			
			String name = su.getName();
			System.out.println("name: " + name);
			sa.assertTrue(Validate.asString(name), className + "." + "validate name failed - ");
		}
		
		String vendor = proStatus.getVendor();
		System.out.println("vendor: " + vendor);
		sa.assertTrue(Validate.asString(vendor), className + "." + "validate vendor failed - ");

	}

}
