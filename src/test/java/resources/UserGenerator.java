package resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import cookieManager.GetCookies;

public class UserGenerator {

	
	
	   private static UserGenerator userGenerator ;

	
	

	   /* A private Constructor prevents any other
	    * class from instantiating.
	    */
	   private UserGenerator() { }

	   // Static 'instance' method */
	    //Now we are providing gloabal point of access.  

	   public static UserGenerator getInstance( ) {
		   if(userGenerator== null) {
			   userGenerator = new UserGenerator();
		   }
		   
	      return userGenerator;
	   }
	
	   /* Other methods protected by singleton-ness */
	
	
	   public HashMap<String, String> generateNewUserCookie() throws Exception {
		   
		   System.out.println("howdy");
		
		HashMap<String,String> map = new HashMap<String, String>();
		StringBuffer response = null;
		String baseurl = ConfigReader.getInstance().getBaseUrl();
		long time = System.currentTimeMillis();
		String randoms = String.valueOf(time);
		String domain = "@saavn.com";
		String username = randoms + domain;
		String password = "Saavn123";
		System.out.println(username);
		String url = baseurl+"/api.php?__call=user.createV2&username="+username+"&email="+username+"&password="+password+"&api_version=4&_format=json&_marker=0&ctx=android";	
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 8.0.0; SM-G960F Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.84 Mobile Safari/537.36");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		
		} else {
			System.out.println("GET request not worked");
		}
		String cookie = GetCookies.initCookies(username,password);

		map.put("username", username);
		map.put("password", password);
		map.put("cookie", cookie);
		return map;

	}


}
