package resources;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;
	private static ConfigReader configReader;

    private ConfigReader() {
		BufferedReader reader;
	    	String propertyFilePath = "src/test/java/resources//global.properties";
	        try {
	            reader = new BufferedReader(new FileReader(propertyFilePath));
	            properties = new Properties();
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

    public static ConfigReader getInstance( ) {
    	if(configReader == null) {
    		configReader = new ConfigReader();
    	}
        return configReader;
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("baseUrl");
        if(baseUrl != null) return baseUrl;
        else throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
    }
    
    public String getAppVersion() {
        String app_version = properties.getProperty("app_version");
        if(app_version != null) return app_version;
        else throw new RuntimeException("app_version not specified in the Configuration.properties file.");
    }
    
    public String getVersion() {
        String version = properties.getProperty("v");
        if(version != null) return version;
        else throw new RuntimeException("version not specified in the Configuration.properties file.");
    }
    
    public String getCtx() {
        String ctx = properties.getProperty("ctx");
        if(ctx != null) return ctx;
        else throw new RuntimeException("ctx not specified in the Configuration.properties file.");
    }

    public String getUserID() {
        String userId = properties.getProperty("user_Id");
        if(userId != null) return userId;
        else throw new RuntimeException("user_Id not specified in the Configuration.properties file.");
    }
}
