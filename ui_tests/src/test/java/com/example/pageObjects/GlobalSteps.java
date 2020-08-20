package com.example.pageObjects;

import com.example.TestsConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.example.CucumberHooks.getDriver;

/**
 * This class contains global (common) steps that do not belong to any specific page
 * As well as all the entry points into the system (open a url)
 */
public class GlobalSteps {
    @Given("I open NorthWind page")
    public NorthWindTest iOpenDashboardNorthWind()  {
        // Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().manage().window().maximize();
        getDriver().get(baseUrl);
        return new NorthWindTest();

    }

    @When("sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void isSearchFieldOpened() {
        List<WebElement> searchElements = getDriver().findElements(By.xpath("//a[@class='Fx4vi']"));
        Assert.assertFalse(((java.util.List) searchElements).isEmpty());
    }

    @Given("I open chrome page")
    public MyNewTestDefinition iOpenDashboardPage() {
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().manage().window().maximize();
        getDriver().get(baseUrl);
        return new MyNewTestDefinition();
    }


}

