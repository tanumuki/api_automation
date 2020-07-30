/**
 *
 */
package validators;

/**
 * @author aswingokulachandran
 *
 */
public class Validate {
    /*
     * Validate as number
     */
    public static boolean asNum(String str) {
        //return str.matches("\\d+|^$");
        return str.matches("^$|^[0-9]\\d*(\\.\\d+)?$|\\d+");
    }
    /*
     * Validate timestamp
     */

    public static boolean asTimeStamp(String time) {
        //return str.matches("\\d+|^$");
        return time.matches("^[0-9]{10}");
    }

    /*
     * Validate featured station type
     */

    public static boolean asFeaturedStationType(String type) {
        //return str.matches("\\d+|^$");
        return type.matches("artist|featured");
    }


    /*
     * Validate as id
     */
    public static boolean asId(String str) {
        return str.matches("[0-9A-Za-z_-]{8}|[0-9]{7}|[0-9A-Za-z_-]{6}|[0-9]{0,9}|[0-9A-Za-z]{32}|[0-9A-Za-z]{42}|[0-9]{96}|[0-9A-Za-z]{42}|[0-9A-Za-z_]{42}");
    }


    /*
     * Validate as role
     */
    public static boolean asRole(String str) {
        return str.matches("music|.+|^$");
    }

    /*
     * Validate as String
     */
    public static boolean asString(String str) {
        return str.matches("^$|.+");

    }

    /*
     * Validate as url
     */
    //http(s)?
    public static boolean asUrl(String str) {
        System.out.println("str size: " + str.length());
        System.out.println("Testing url: \"" + str + "\"");
        return str.matches("^$|((https|http)://(c|www|staging|c.sop|pli|qa-az|staging-az|prod-az|static|c-origin)?.(saavn|saavncdn|jiosaavn).com/(s|editorial|artists|.+)(/.+)?.(png|jpg)?(/.+)?)|((https|http)://(c|www|staging|c.sop|qa-az|staging-az|prod-az)?.(saavn|saavncdn).com/(s|editorial|artists|.+)(/.+)?.(png|jpg)?(/.+)?)|(https://graph.facebook.com/v2.9/.+/picture|https://static.saavncdn.com/_i/share-image.png)");
        //return str.matches("(https|http)://(c|c.sop|staging|www|.+)?.(saavncdn|saavn).com/(s|editorial|artists|.+)/(.+/)?.(png|jpg)?/(s/radio/.+/.+)?|https://graph.facebook.com/v2.9/.+/.+");
        //return str.matches("(https|http)://(c|c.sop|staging|www|.+)?.(saavncdn|saavn).com/(s|editorial|artists|.+)/(.+)?.(png|jpg)?");

    }

    /*
     * Validate as boolean
     */
    public static boolean asBoolean(String str) {

        return str.matches("^$|true|false|0|1|True|False");
    }

    /*
     * Validate as language
     */
    public static boolean asLang(String str) {
        // HomeUtils.getSupportedLangs();
        // return HomeUtils.languages.contains(str);
        return str.matches(".+");
    }

    /*
     * Validate as Date
     */
    public static boolean asDate(String str) {

        return str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}");
    }

    public static boolean asProduct(String str) {
        return str.matches("PRIME|prime|saavn.30day|SAAVN.30DAY");
    }

    public static boolean asEmail(String str) {
        return str.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
    }

    public static boolean asDateTime(String str) {
        return str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}");
    }

    public static boolean asGender(String str) {
        return str.matches("m|f|u");
    }
	public static boolean isNonEmptyString(String str){
	    return str != null && !str.equals("") && !str.trim().isEmpty();
	}

}
