package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/aswinCukeReport.html", "rerun:target/rerun.txt", "json:target/jsonReport.json", "timeline:target/timelineReport"}

)
public class TestRunner extends AbstractTestNGCucumberTests {
}
