package com.wendy.example;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, plugin = {"pretty", "json:target/cucumber/cucumber.json", "html:target/cucumber", "rerun:target/rerun.txt"})
public class RunCukesTest {
}
