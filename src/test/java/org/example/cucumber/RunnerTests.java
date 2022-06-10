package org.example.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

@CucumberOptions(features = {"src/test/java/org/example/cucumber/features"}, glue = {"org.example.cucumber"})
public class RunnerTests extends AbstractTestNGCucumberTests {
    public static String browser;

    @BeforeTest
    @Parameters("browser")
    public void defineBrowser(String browser) {
        RunnerTests.browser = browser;
    }
}
