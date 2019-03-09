package com.sapbasu.cucumberseed.runner;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features", glue = "com.sapbasu.cucumberseed", plugin = {
    "pretty", "html:target/cucumber-reports"}, monochrome = true)
@SpringBootTest
public class CucumberSeedApplicationTests {
  
}
