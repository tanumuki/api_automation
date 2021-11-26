package cookieManager;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class GetCookies {
	

	static final String COOKIES_HEADER = "Set-Cookie";
	static java.net.CookieManager msCookieManager;
	static HashMap<String, String> cookieMap;
	static List<HttpCookie> cookies;
	static String cookieString = "";
	static int i = 0;
	static String baseUrl;

	public static String initCookies(String userName, String password) throws IOException {

		
		baseUrl= resources.ConfigReader.getInstance().getBaseUrl();
		cookieString = "";

		URL url = new URL(baseUrl + "/api.php?__call=user.login&username=" + userName + "&password="
				+ password + "&api_version=4&_format=json&_marker=0");
		System.out.println(url);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		msCookieManager = new java.net.CookieManager();
		Map<String, List<String>> headerFields = connection.getHeaderFields();
		List<String> cookiesHeader = headerFields.get(COOKIES_HEADER);

		if (cookiesHeader != null) {
			for (String cookie : cookiesHeader) {
				msCookieManager.getCookieStore().add(null, HttpCookie.parse(cookie).get(0));
			}
			cookies = msCookieManager.getCookieStore().getCookies();
			cookieMap = new HashMap<String, String>();
			for (HttpCookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie.getValue());
			}
		}

		// Returning the default cookies as a string

		for (Map.Entry<String, String> entry : cookieMap.entrySet()) {
			cookieString = cookieString + entry.getKey() + "=" + entry.getValue() + ";";
		}
		return cookieString;
	}

	public static void clearCookies(String uid) throws IOException {


		baseUrl= resources.ConfigReader.getInstance().getBaseUrl();
		cookieString = "";

		URL url = new URL(baseUrl + "/api.php?__call=user.logout&uid=" + uid + "&api_version=4&_format=json&_marker=0");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	}


	public static String initCookies( String languageCookie, Map<String, List<String>> headerFields) throws IOException {
		msCookieManager = new java.net.CookieManager();
		List<String> cookiesHeader = headerFields.get(COOKIES_HEADER);
		System.out.println("init debug 3 " +COOKIES_HEADER.toString());
		if (cookiesHeader != null) {
			for (String cookie : cookiesHeader) {
				msCookieManager.getCookieStore().add(null, HttpCookie.parse(cookie).get(0));
			}
			cookies = msCookieManager.getCookieStore().getCookies();
			cookieMap = new HashMap<String, String>();
			for (HttpCookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie.getValue());
			}
			System.out.println("map" +cookieMap.toString());
		}

		cookieMap.put("L", languageCookie);
		for(Map.Entry<String, String> entry : cookieMap.entrySet())	{
			
			cookieString=cookieString+entry.getKey()+"="+entry.getValue()+";";
		}
		System.out.println("string " +cookieString);
		return cookieString;
	}
}
