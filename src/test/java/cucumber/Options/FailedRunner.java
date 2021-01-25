package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		features = "@target/rerun.txt",
		glue = {"stepDefinitions"},
		plugin = {"json:target/report/cucumber-json.json",
				"html:target/htmlReport/cucumber.html",
				"rerun:target/rerun.txt",
				"pretty", "html:target/aswinCukeReport.html", "rerun:target/rerun.txt", "timeline:target/timelineReport"},
		monochrome = true
)
public class FailedRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}