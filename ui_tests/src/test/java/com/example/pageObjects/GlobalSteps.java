package com.example.pageObjects;

import com.example.TestsConfig;
import com.example.pageObjects.Execises.navigatingBetwennPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.mk_latn.No;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import  com.example.pageObjects.Execises.*;


import java.util.concurrent.TimeUnit;

import static com.example.CucumberHooks.getDriver;

/**
 * This class contains global (common) steps that do not belong to any specific page
 * As well as all the entry points into the system (open a url)
 */
public class GlobalSteps {
    @Given("I open start page")
    public GoogleStartPage iOpenDashboardPage() throws InterruptedException {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        getDriver().manage().window().maximize();

        return new GoogleStartPage();

    }

    @When("sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }


    @And("i type text and hit enter")
    public void iHitEnter() {
        String hello = "Hello Word";
        WebElement element = getSearchTextFieldElement();
        element.sendKeys(hello + Keys.ENTER);
    }

    public WebElement getSearchTextFieldElement() {
        return getDriver().findElement(By.xpath("//input[@name='q']"));

    }

    @Given("I open index page")
    public LoginClass indexPage() {
        String baseURL2 = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseURL2);
        return new LoginClass();
    }

    @Given("Google index page opened")
    public Homework indexPageOpen() throws InterruptedException {
        String baseURl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseURl);
        Thread.sleep(2000);
        return new Homework();
    }


    @Given("User should be on index page")
    public NorthWind2 userShouldBeOnIndexPage() throws InterruptedException {
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        Thread.sleep(2000);
        return new NorthWind2();
    }

    @Given("NorthWind index page")
    public NorthWind2 user() throws InterruptedException {
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        Thread.sleep(2000);
        return new NorthWind2();
    }
}
