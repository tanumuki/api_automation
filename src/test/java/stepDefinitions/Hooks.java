package stepDefinitions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;

public class Hooks {

    static
    {
        File file = new File("Output.txt");

        if (file.delete())
        {
            System.out.println("Output.txt deleted successfully");
        }
        else
        {
            System.out.println("Output.txt could not be deleted");
        }
    }
    @Before
    public void enableLoggingToAFile() throws IOException {
        PrintStream printStream = new PrintStream(new FileOutputStream("Output.txt", true), true);
        RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig().defaultStream(printStream).enablePrettyPrinting(true));

    }
    
    
  
}
