package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = "@target/rerun.txt",
		glue = {"stepDefinitions"},
		plugin = {"pretty", "html:target/cucumberReports", "rerun:target/rerun.txt", "json:target/jsonReport.json","timeline:target/timelineReport"}

		)
public class FailedRunner {



}
