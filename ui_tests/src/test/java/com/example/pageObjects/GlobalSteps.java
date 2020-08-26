package com.example.pageObjects;

import com.example.TestsConfig;
import com.example.helpers.ElementsInteraction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.example.CucumberHooks.getDriver;

/**
 * This class contains global (common) steps that do not belong to any specific page
 * As well as all the entry points into the system (open a url)
 */
public class GlobalSteps {
    @Given("I open start page")
    public HomeworkVadim iOpenDashboardPage() {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        return new HomeworkVadim();
    }

    @When("sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }

   @And("I type keyword \"Selenium\" in Search field of Google")
    public void type(){
       ElementsInteraction.sendKeys(By.xpath("//input[@name='q']"),"Hello Word");
   }

    @Given("Go to basic URL")
    public HomeworkVadim  goToBasicURL() throws InterruptedException {
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        getDriver().manage().window().maximize();
        Thread.sleep(2000);
        getDriver().findElement(By.cssSelector("button[class='btn btn-default']")).click();
        return new HomeworkVadim();

    }
}
