package com.mhra.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
          features= {"src/test/resources/features/searchdepartment.feature"},
          glue={"com.mhra.stepdefinitions"},
          plugin={"pretty", "html:target/cucumber-reports.html"},
          monochrome = true
)

public class TestRunner {
    
}

