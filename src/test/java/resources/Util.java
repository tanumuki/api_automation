package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Util {

    public static RequestSpecification request;


    public RequestSpecification requestSpecification(String ctx, String endPoint) throws IOException {


        request = new RequestSpecBuilder().setBaseUri(ConfigReader.getInstance().getBaseUrl())
                .addQueryParam("__call", endPoint)
                .addQueryParam("api_version", "4")
                .addQueryParam("_format", "json")
                .addQueryParam("_marker", "0")
                .addQueryParam("app_version", ConfigReader.getInstance().getAppVersion())
                .addQueryParam("v", ConfigReader.getInstance().getVersion())
                .addQueryParam("ctx", ctx).setContentType(ContentType.JSON).build();

//        PrintStream printStream = new PrintStream(new FileOutputStream("Output.txt", true), true);
//        RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig().defaultStream(printStream));
//        request.given().log().everything();
        return request;

    }


    /*
     * Sending a cookie in the form of Hashmap
     */


    public RequestSpecification requestSpecificationWithHeaders(String ctx, String endPoint, String cookie) throws FileNotFoundException {


        request = new RequestSpecBuilder().setBaseUri(ConfigReader.getInstance().getBaseUrl())
                .addCookie(cookie)
                .addQueryParam("__call", endPoint)
                .addQueryParam("api_version", "4")
                .addQueryParam("_format", "json")
                .addQueryParam("_marker", "0")
                .addQueryParam("app_version", ConfigReader.getInstance().getAppVersion())
                .addQueryParam("v", ConfigReader.getInstance().getVersion())
                .addQueryParam("ctx", ctx).setContentType(ContentType.JSON).build();
//        PrintStream printStream = new PrintStream(new FileOutputStream("Output.txt", true), true);
//        RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig().defaultStream(printStream));
//        request.given().log().everything();
        return request;
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
            printWriter.println("================================================================================================================================================================================================================================================================================");
            System.out.println("Response time recorded successfully in Output.txt");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (printWriter != null) {
                    printWriter.close();
                    bufferedWriter.close();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
