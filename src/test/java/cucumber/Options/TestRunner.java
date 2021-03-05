package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        plugin = {"json:target/cucumber.json",
                "html:target/htmlReport/cucumber.html",
                "rerun:target/rerun.txt",
                "pretty", "html:target/aswinCukeReport.html", "rerun:target/rerun.txt", "timeline:target/timelineReport"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

