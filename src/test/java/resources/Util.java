package resources;

import cookieManager.GetCookies;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Util {

    public static RequestSpecification request;
    public static final TestContext testContext = new TestContext();
    static final String ANDROID_DEVICE_ID = "device_id=8yEi4ih9eJxp9H1IUk6LcVyJnienvB1gnXph5GTxFn8%3D";
    static final String IOS_DEVICE_ID = "ssid=did_v1_598C80A8-AF83-4D5E-AFA0-79FB1EE1CB41";


    public RequestSpecification requestSpecification(String ctx, String endPoint) throws IOException {


        PrintStream log = new PrintStream(new FileOutputStream("Output.txt"));

        request = new RequestSpecBuilder().setBaseUri(ConfigReader.getInstance().getBaseUrl())
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .addHeader("User-Agent", ConfigReader.getInstance().getUserAgent())
                .addQueryParam("__call", endPoint)
                .addQueryParam("api_version", "4")
                .addQueryParam("_format", "json")
                .addQueryParam("_marker", "0")
                .addQueryParam("app_version", ConfigReader.getInstance().getAppVersion())
                .addQueryParam("v", ConfigReader.getInstance().getVersion())
                .addQueryParam("ctx", ctx).setContentType(ContentType.JSON).build();

        return request;

    }


    /*
     * Sending a cookie in the form of Hashmap
     */


    public RequestSpecification requestSpecificationWithHeaders(String ctx, String endPoint, String cookie) throws FileNotFoundException {


        PrintStream log = new PrintStream(new FileOutputStream("Output.txt"));
        String device_id = ctx.equalsIgnoreCase("iphoneapp") ? IOS_DEVICE_ID : ANDROID_DEVICE_ID;
        cookie = updateGeoCookieToIndia(cookie);
        cookie += device_id;
        request = new RequestSpecBuilder().setBaseUri(ConfigReader.getInstance().getBaseUrl())
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .addCookie(cookie)
                .addHeader("User-Agent", ConfigReader.getInstance().getUserAgent())
                .addQueryParam("__call", endPoint)
                .addQueryParam("api_version", "4")
                .addQueryParam("_format", "json")
                .addQueryParam("_marker", "0")
                .addQueryParam("app_version", ConfigReader.getInstance().getAppVersion())
                .addQueryParam("v", ConfigReader.getInstance().getVersion())
                .addQueryParam("ctx", ctx).setContentType(ContentType.JSON)
                .build();

        return request;
    }

    //https://www.baeldung.com/rest-assured-header-cookie-parameter

    public static String updateGeoCookieToIndia(String cookie) {
//        replace the country to IN in the geo cookie. Ex: geo=178.128.24.31%2CSG%2C%2C%2C62;
//        This is needed in Jenkins, since our instance is based out of Singapore and all tests should run from
//        India
        return cookie.contains("%2CIN%2C") ? cookie : cookie.replaceAll("%2C[A-Z]{2}%2C", "%2CIN%2C");
    }

    public static String getGlobalValue(String key) throws IOException {

        Properties property = new Properties();
        FileInputStream fs = new FileInputStream("src/test/java/resources/global.properties");
        property.load(fs);
        return property.getProperty(key);

    }

    public static String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }


    public static List<String> readFileInToList(String filePath) throws FileNotFoundException {
        List<String> fileContents = new ArrayList<>();
        Scanner s = new Scanner(new File(filePath));
        while (s.hasNextLine()) {
            fileContents.add(s.nextLine());
        }
        s.close();
        return fileContents;
    }

    public static void logResponseTime(Response resp) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter("Output.txt", true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.println("Response time is: " + resp.getTime() + "ms");
            System.out.println("Response time recorded successfully in Output.txt");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //User generator method

    public static HashMap<String, String> generateNewUser() throws Exception {

        HashMap<String, String> map = new HashMap<String, String>();
        StringBuffer response = null;
        String baseurl = ConfigReader.getInstance().getBaseUrl();
        long time = System.currentTimeMillis();
        String randoms = String.valueOf(time);
        String domain = "@saavn.com";
        String username = randoms + domain;
        String password = "Saavn@1234";
        System.out.println(username);
        String url = baseurl + "/api.php?__call=user.createV2&username=" + username + "&email=" + username + "&password=" + password + "&api_version=4&_format=json&_marker=0&ctx=android";

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
        String cookie = GetCookies.initCookies(username, password);

        map.put("username", username);
        map.put("password", password);
        map.put("cookie", cookie);
        return map;

    }

    public RequestSpecification requestSpecificationJioPhone(String endPoint, String cookie) throws IOException {

        PrintStream log = new PrintStream(new FileOutputStream("Output.txt"));

        request = new RequestSpecBuilder().setBaseUri(ConfigReader.getInstance().getBaseUrl())
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .addCookie(cookie)
                .addHeader("User-Agent", ConfigReader.getInstance().getUserAgent())
                .addQueryParam("__call", endPoint)
                .addQueryParam("api_version", "4")
                .addQueryParam("_format", "json")
                .addQueryParam("_marker", "0")
                .addQueryParam("v", ConfigReader.getInstance().getVersion())
                .setContentType(ContentType.JSON)
                .build();

        return request;
    }

    public RequestSpecification requestSpecificationWithHeaders(String ctx, String endPoint) throws FileNotFoundException {


        PrintStream log = new PrintStream(new FileOutputStream("Output.txt"));
//        String device= "device_id= 8yEi4ih9eJxp9H1IUk6LcVyJnienvB1gnXph5GTxFn8%3D";
//        cookie=cookie+device;
        request = new RequestSpecBuilder().setBaseUri(ConfigReader.getInstance().getBaseUrl())
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
//                .addCookie(cookie)
                .addHeader("User-Agent", ConfigReader.getInstance().getUserAgent())
                .addQueryParam("__call", endPoint)
                .addQueryParam("api_version", "4")
                .addQueryParam("_format", "json")
                .addQueryParam("_marker", "0")
                .addQueryParam("app_version", ConfigReader.getInstance().getAppVersion())
                .addQueryParam("v", ConfigReader.getInstance().getVersion())
                .addQueryParam("ctx", ctx).setContentType(ContentType.JSON)
                .build();
        return request;
    }
}
