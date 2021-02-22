package resources;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties = new Properties();
    static String baseUrl;
    static String app_version;
    static String version;
    static String ctx;
    static String username;
    static String password;
    static String userAgent;

    private static ConfigReader configReader;

    private ConfigReader() {
        BufferedReader reader;
        String propertyFilePath = "src/test/java/resources/global.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    // public void setEnv() throws IOException {

    static {
        System.out.println("RUN");
        if (System.getProperty("baseUrl") != null) {

            String baseUrl = System.getProperty("baseUrl");
            String app_version = System.getProperty("app_version");
            String version = System.getProperty("version");
            String ctx = System.getProperty("ctx");
            String username = System.getProperty("username");
            String password = System.getProperty("password");
            String userAgent = System.getProperty("userAgent");

            System.out.println("stuff works " + baseUrl + " and " + app_version);
            if (baseUrl != null) {
                if (baseUrl.equalsIgnoreCase("staging")) {
                    properties.setProperty("baseUrl", "https://staging.saavn.com");
                } else if (baseUrl.equalsIgnoreCase("prod")) {
                    properties.setProperty("baseUrl", "https://www.saavn.com");
                }
            } else {
                baseUrl = "https://www.saavn.com";
                System.out.println("Aswin baseurl: " + baseUrl);
            }


            if (app_version != null) {
                if (app_version.equalsIgnoreCase("5.1")) {
                    properties.setProperty("app_version", "5.1");
                } else if (app_version.equalsIgnoreCase("6.1")) {
                    properties.setProperty("app_version", "6.1");
                } else if (app_version.equalsIgnoreCase("7.5.1")) {
                    properties.setProperty("app_version", "7.5.1");
                }
            }

            if (version != null) {
                if (version.equalsIgnoreCase("190")) {
                    properties.setProperty("v", "190");
                } else if (version.equalsIgnoreCase("211")) {
                    properties.setProperty("v", "211");
                } else if (version.equalsIgnoreCase("258")) {
                    properties.setProperty("v", "258");
                }
            }

            if (ctx != null) {
                if (ctx.equalsIgnoreCase("android")) {
                    properties.setProperty("ctx", "android");
                } else if (ctx.equalsIgnoreCase("iphoneapp")) {
                    properties.setProperty("ctx", "iphoneapp");
                }
            }

            if (username != null) {
                if (username.equalsIgnoreCase("prodAccount")) {
                    properties.setProperty("username", "tanu@saavn.com");
                } else if (username.equalsIgnoreCase("QAAccount")) {
                    properties.setProperty("username", "tanu.muk2009@gmail.com");
                }
            }


            if (password != null) {
                if (password.equalsIgnoreCase("prodPassword")) {
                    properties.setProperty("password", "Tanu1234");
                } else if (password.equalsIgnoreCase("QAPassword")) {
                    properties.setProperty("username", "tanu.muk2009@gmail.com");
                }
            }

            if (userAgent != null) {
                if (userAgent.equalsIgnoreCase("android")) {
                    properties.setProperty("userAgent", "Mozilla/5.0 (Linux; Android 8.0.0; SM-G960F Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.84 Mobile Safari/537.36");
                } else if (userAgent.equalsIgnoreCase("iOS")) {
                    properties.setProperty("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.1 Mobile/15E148 Safari/604.1");
                }
            }

            //putting the values

            File file = new File("src/test/java/resources/global.properties");
            FileOutputStream fileOut = null;
            try {
                fileOut = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                properties.store(fileOut, "properties");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                fileOut.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        /*
         * If the values are not available from terminal then retrieving the values by hardcoding it
         */
        else {

            baseUrl = "https://staging.jiosaavn.com";
            properties.setProperty("baseUrl", baseUrl);
            password = "Saavn123";
            properties.setProperty("password", password);
            app_version = "7.5.1";
            properties.setProperty("app_version", app_version);
            version = "258";
            properties.setProperty("v", version);
            ctx = "android";
            properties.setProperty("ctx", ctx);
            userAgent = "Mozilla/5.0 (Linux; Android 8.0.0; SM-G960F Build/R16NW) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.84 Mobile Safari/537.36";
            properties.setProperty("userAgent", userAgent);
            username = "tanu@saavn.com";
            properties.setProperty("username", username);
            password = "Tanu1234";
            properties.setProperty("password", password);

            File file = new File("src/test/java/resources/global.properties");
            FileOutputStream fileOut = null;
            try {
                fileOut = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                properties.store(fileOut, "properties");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                fileOut.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public String getBaseUrl() {
        baseUrl = properties.getProperty("baseUrl");
        if (baseUrl != null)
            return baseUrl;
        else throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
    }

    public String getAppVersion() {
        app_version = properties.getProperty("app_version");
        if (app_version != null) return app_version;
        else throw new RuntimeException("app_version not specified in the Configuration.properties file.");
    }

    public String getVersion() {
        version = properties.getProperty("v");
        if (version != null) return version;
        else throw new RuntimeException("version not specified in the Configuration.properties file.");
    }

    public String getCtx() {
        ctx = properties.getProperty("ctx");
        if (ctx != null) return ctx;
        else throw new RuntimeException("ctx not specified in the Configuration.properties file.");
    }


    public String getUsername() {
        username = properties.getProperty("username");
        if (username != null) return username;
        else throw new RuntimeException("ctx not specified in the Configuration.properties file.");
    }


    public String getPassword() {
        password = properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }


    public String getUserID() {
        String userId = properties.getProperty("user_Id");
        if (userId != null) return userId;
        else throw new RuntimeException("user_Id not specified in the Configuration.properties file.");
    }

    public String getUserAgent() {
        userAgent = properties.getProperty("userAgent");
        if (userAgent != null) return userAgent;
        else throw new RuntimeException("userAgent not specified in the Configuration.properties file.");
    }
}
