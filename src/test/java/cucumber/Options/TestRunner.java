package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions (features = "src/test/java/features", glue = {"stepDefinitions"}, tags = "@contents", 
plugin = {"pretty", "html:target/cucumberReports/html-report.html", "json:target/jsonReport.json","timeline:target/timelineReport"})
public class TestRunner {
	
	
	
	

}
