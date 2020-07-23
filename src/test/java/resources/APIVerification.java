//package resources;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.testng.Assert;
//
//import io.restassured.response.Response;
//import lombok.extern.slf4j.Slf4j;
//
//
//@Slf4j
//public class APIVerification{
//	
//	
//	
//
//
//	public static void responseKeyValidationfromArray(Response response, String key) {
//		try {
//			JSONArray array = new JSONArray(response.getBody().asString());
//			for(int i=0; i<array.length();i++) {
//				JSONObject obj = array.getJSONObject(i);
//				log.info( "Validetd values are  " + obj.get(key));
//				
//			}
//		} catch (Exception e) {
//			log.info( e.fillInStackTrace());
//		}
//	}
//	
//	
//	public static void responseKeyValidationFromJsonObject(Response response, String key) {
//		try {
//			JSONObject json = new JSONObject(response.getBody().asString());
//			if(json.has(key) && json.get(key)!= null) {
//				log.info( "Sucessfully validated value of " + key + " It is " + json.get(key));
//			}else {
//				log.info("Key is not availble");
//			}
//		} catch (Exception e) {
//			log.info( e.fillInStackTrace());
//		}
//	}
//	
//	
//	public static boolean isNonEmptyString(String str){
//	    return str != null && !str.equals("") && !str.trim().isEmpty();
//	}
//	
//	public static void responseTimeValidation(Response response) {
//		try {
//			long time=response.time();
//			log.info( "Api response time is :: " + time);
//		} catch (Exception e) {
//			log.info( e.fillInStackTrace());
//		}
//	}
//
//}
