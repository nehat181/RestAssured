package com.org.Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/org/functionalTests/End2End_Test.feature",glue = {"com/org/stepDefinitions"},
        monochrome = true,
        strict = true
)

public class TestRunner {

}
