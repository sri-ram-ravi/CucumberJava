package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"},glue = {"classpath:stepDefinitions"},
                  monochrome = true,dryRun = false,tags = "@contact_us",plugin = {"pretty","html:target/cucumber.html"})
public class MainRunners extends AbstractTestNGCucumberTests { }