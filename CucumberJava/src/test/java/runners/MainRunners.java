package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"}, glue = {"classpath:stepDefinitions"},
        monochrome = true, dryRun = false, tags = "@smoke", plugin = {"pretty","html:target/cucumber.html"}) //
public class MainRunners extends AbstractTestNGCucumberTests {
    /* @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/
}
