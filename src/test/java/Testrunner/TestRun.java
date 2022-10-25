package Testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"pretty","html:target/html-reports"},
        features = "src/main/resources/Features",
        glue = "Stepdefinition"
)
public class TestRun extends AbstractTestNGCucumberTests {
}
