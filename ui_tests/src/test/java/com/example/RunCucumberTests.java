package com.example;

import com.example.helpers.ElementsInteraction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import static com.example.CucumberHooks.getDriver;

@CucumberOptions(plugin = {
        "rerun:target/rerun.txt", // Create a text file with failed scenarios
        "pretty",
        "html:target/cucumber",
        "json:target/cucumber-report.json",
        "timeline:target/cucumberTimeline"},
        strict = true
)
public class RunCucumberTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}


