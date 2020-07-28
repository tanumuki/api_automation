/**
 * 
 */
package validators;

/**
 * @author aswingokulachandran
 *
 */
public class AssertionMsg {
	
	public static String print(String className, String methodName, String entityType, String fieldName, String value) {
		return className + " " + methodName + " - " + entityType + " " + fieldName + " failed assertion -- value: \""
				+ value + "\"";
	}
	
	public static String print(String className, String methodName, String fieldName, String value) {
		return className + " " + methodName + " - " + fieldName + " failed assertion -- value: \""
				+ value + "\"";
	}
	
	public static String print(String className, String methodName, String entityType, String fieldName, String value, String source) {
		return className + " " + methodName + " - " + fieldName + " failed assertion -- value: \""
				+ value + "\" for the entityType - " + entityType + " with id " + source;
	}

}
