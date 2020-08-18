package com.example.pageObjects;

import com.example.TestsConfig;
import com.example.pageObjects.Execises.Test1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.example.CucumberHooks.getDriver;

/**
 * This class contains global (common) steps that do not belong to any specific page
 * As well as all the entry points into the system (open a url)
 */
public class GlobalSteps {
    @When("I open start page")
    public ExamplePage iOpenDashboardPage() {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        return new ExamplePage();
    }

    @When("sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }

    public void Secound() {
        System.out.println("HIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
    }

    @Given("open index page")
    public Test1 openIndexPage() throws InterruptedException {
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        getDriver().manage().window().maximize();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//div[@class='modal-footer']/button")).click();
        Thread.sleep(2000);
        return new Test1();
    }

    @Given("practice page opened")
    public void practicePageOpened() {
        
    }

    @Given("user is on index page")
    public void userIsOnIndexPage() {

    }

    @Given("index page opened")
    public void indexPageOpened() {
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        getDriver().manage().window().maximize();
    }
}
