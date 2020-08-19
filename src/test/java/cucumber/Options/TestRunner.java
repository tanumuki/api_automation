package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions (
		features = "src/test/java/features/RadioValidation.feature",
		glue = {"stepDefinitions"},
		plugin = {"pretty", "html:target/cucumberReports", "json:target/jsonReport.json","timeline:target/timelineReport"}
		)
public class TestRunner {
	
	

}
