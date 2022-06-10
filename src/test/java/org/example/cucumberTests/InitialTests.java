package org.example.cucumberTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/org/example/features"}, glue = {"ru.savkk.test"})
public class InitialTests extends AbstractTestNGCucumberTests {
}
