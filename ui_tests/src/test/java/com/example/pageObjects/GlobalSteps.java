package com.example.pageObjects;

import com.example.TestsConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.example.CucumberHooks.getDriver;

/**
 * This class contains global (common) steps that do not belong to any specific page
 * As well as all the entry points into the system (open a url)
 */
public class GlobalSteps {
    @Given("I open start page")
    public ExamplePage iOpenDashboardPage() throws InterruptedException {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        Thread.sleep(5000);
        return new ExamplePage();
    }
    @And("I type search keyword “Hello World”")
    public void HelloWprld() throws InterruptedException {
        WebElement searchtext = getDriver().findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
        searchtext.sendKeys("Hello World");
        Thread.sleep(2000);

    }
    @When("I hit ImLucky")
    public void InLucky() throws InterruptedException {
        WebElement ImLucky = getDriver().findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[2]"));
        ImLucky.click();
        Thread.sleep(1000);
    }
    @Then("I verify that Search Results page is opened")
    public void SearchResult() throws InterruptedException {

        Thread.sleep(1000);
    }

}
