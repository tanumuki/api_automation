package resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class GetConnection {

	public static String getConnectionDetails(String url) throws Exception {

		URLConnection connection = openConnection(url);
		String response = parseResponse(connection);

		return response;
	}
	
	public static String getConnectionDetails(String url, boolean setUserAgentRequired) throws Exception {
		
		String response;
		
		if(setUserAgentRequired==true) {
			System.out.println("agent applied");
			URL con = new URL(url);
			System.out.println("url: " + url);
			HttpURLConnection httpCon = (HttpURLConnection) con.openConnection();
			httpCon.addRequestProperty("User-Agent","Mozilla/5.0 (Linux; U; Android 4.0.3; ko-kr; LG-L160L Build/IML74K) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
			 response = parseResponse(httpCon);
		}
		else {
			System.out.println("agent not applied");
			URL con = new URL(url);
			System.out.println("url: " + url);
			HttpURLConnection httpCon = (HttpURLConnection) con.openConnection();
			 response = parseResponse(httpCon);
		}
		

		return response;
	}

	public static String getConnectionDetailsPutRequest(String url) throws IOException {
		URL con= new URL(url);
		HttpURLConnection httpCon =  (HttpURLConnection) con.openConnection();
		httpCon.setRequestMethod("PUT");
		BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
		String inputLine;
		String resp="";
		while((inputLine=in.readLine())!=null) {
			resp=resp.concat(inputLine);
		}
		return resp;
		
	}
	public static String getConnectionDetailsPostRequest(String url) throws IOException {
		URL con= new URL(url);
		HttpURLConnection httpCon =  (HttpURLConnection) con.openConnection();
		httpCon.setRequestMethod("POST");
		BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
		String inputLine;
		String resp="";
		while((inputLine=in.readLine())!=null) {
			resp=resp.concat(inputLine);
		}
		return resp;
		
	}
		

	public static String getConnectionDetails(String url, String cookieName, String cookieValue) throws Exception {



		URLConnection connection = openConnection(url);
		connection.setRequestProperty("Cookie", cookieName + "=" + cookieValue + ";network=linkedfb");
		connection.setRequestProperty("network", "linkedfb");
		//System.out.println("Request Props: " + connection.getRequestProperties().toString());
		String response = parseResponse(connection);
		System.out.println("resp is "+response);
		return response;
	}
	
	public static String getConnectionDetails(String url, String cookieName, String cookieValue, boolean setUserAgentRequired) throws Exception {
	
		
		
		String response;
		
		if(setUserAgentRequired) {
			System.out.println("agent applied");
			URL con = new URL(url);
			System.out.println("url: " + url);
			HttpURLConnection httpCon = (HttpURLConnection) con.openConnection();
			//httpCon.addRequestProperty("User-Agent","Mozilla/5.0 (Linux; U; Android 4.0.3; ko-kr; LG-L160L Build/IML74K) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
			httpCon.addRequestProperty("User-Agent","Mozilla/5.0 (Linux; Android 8.0.0; SM-G960F Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.84 Mobile Safari/537.36");

			httpCon.setRequestProperty("Cookie", cookieName + "=" + cookieValue + ";network=linkedfb");
			httpCon.setRequestProperty("network", "linkedfb");
			 response = parseResponse(httpCon);
		}
		else {
			System.out.println("agent not applied");
			URL con = new URL(url);
			System.out.println("url: " + url);
			HttpURLConnection httpCon = (HttpURLConnection) con.openConnection();
			httpCon.setRequestProperty("Cookie", cookieName + "=" + cookieValue + ";network=linkedfb");
			httpCon.setRequestProperty("network", "linkedfb");
			 response = parseResponse(httpCon);
		}
		
		System.out.println("returning reponse when no user agent is applied" +response);
		return response;
		
		
	}

	public static String getConnectionDetailsLatLong(String url, String latLong) throws Exception {

		// System.out.println("cookie is" +cookieValue);
		URLConnection connection = openConnection(url);
	//System.out.println("tanu: " + connection.getHeaderFields().toString());
		//connection.setRequestProperty("Cookie", "geo="+latLong+";");
		connection.setRequestProperty("Cookie", "latlong="+latLong+";");
		//System.out.println("getConnectionDetailsLatLong: " + connection.getRequestProperties().toString());
		
//		connection.setRequestProperty("latlong", "19.0760,72.8777");
		String response = parseResponse(connection);
		return response;
	}

	public static String getConnectionDetails(String url, HashMap<String, String> cookieMap) throws Exception {

		String lCookie = cookieMap.get("L");
		String bCookie = cookieMap.get("B");
		String latlong = cookieMap.get("latlong");

		// System.out.println("cookie is" +cookieValue);
		URLConnection connection = openConnection(url);
		// connection.setRequestProperty("Cookie",
		// cookieName+"="+cookieValue+";network=linkedfb");
		connection.setRequestProperty("network", "linkedfb");
		System.out.println(lCookie);
		if (lCookie != null) {
			connection.setRequestProperty("L", lCookie);
		}
		if (bCookie != null) {
			connection.setRequestProperty("B", bCookie);
		}
		
		if(latlong!=null){
			connection.setRequestProperty("latlong", latlong);
		}
		System.out.println("Aswin: " + connection.getHeaderFields().toString());
		String response = parseResponse(connection);
		return response;
	}

	/*
	 * A wrapper to create a new connection to the specified URL and returns the
	 * connection object
	 */
	public static URLConnection openConnection(String url) throws IOException {
		URL urlObject = new URL(url);
		URLConnection connection = urlObject.openConnection();
		return connection;
	}

	/*
	 * Read the HTTP response and pass it to the caller as string
	 */
	public static String parseResponse(URLConnection connection) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		// optimizing with String Buffer
		StringBuffer responseSB = new StringBuffer();
		while ((inputLine = input.readLine()) != null) {
			responseSB.append(inputLine);

		}
		input.close();
		return responseSB.toString();
	}
}
