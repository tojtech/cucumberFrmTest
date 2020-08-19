package com.facebook.pageObjects;

import com.facebook.TestsConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.facebook.CucumberHooks.getDriver;

/**
 * This class contains global (common) steps that do not belong to any specific page
 * As well as all the entry points into the system (open a url)
 */
public class GlobalSteps {
    @When("I open start page")
    public StartPage iOpenDashboardPage() {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        return new StartPage();
    }

    @When("sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Given("Go to basic URL")
    public Homework goToBasicURL() throws InterruptedException {
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        getDriver().manage().window().maximize();
        getDriver().findElement(By.xpath("//button[@class='btn btn-default']")).click();
        return new Homework();
    }
}
