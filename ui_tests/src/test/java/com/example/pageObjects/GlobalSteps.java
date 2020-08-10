package com.example.pageObjects;

import com.example.TestsConfig;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.example.CucumberHooks.getDriver;

/**
 * This class contains global (common) steps that do not belong to any specific page
 * As well as all the entry points into the system (open a url)
 */
public class GlobalSteps {

    @Given("I open index page")
    public BigprofIndexPage iOpenIndexPage() throws InterruptedException {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        Thread.sleep(500);

        WebElement element = getDriver().findElement(By.xpath("//div[@class='modal-footer']/button"));
        Thread.sleep(500);
        element.click();
        return new BigprofIndexPage();
    }

    @When("sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(4000);
    }

}
