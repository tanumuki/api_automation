package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/rerun.txt",
		glue = {"stepDefinitions"},
		plugin = {"pretty", "html:target/cucumberReports", "rerun:target/rerun.txt", "json:target/jsonReport.json","timeline:target/timelineReport"}

		)
public class FailedRunner extends AbstractTestNGCucumberTests {



}
