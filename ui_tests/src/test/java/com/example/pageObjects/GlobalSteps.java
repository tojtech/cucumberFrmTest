package com.example.pageObjects;

import com.example.TestsConfig;
import com.example.selenium.WaitForAjaxCalls;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.List;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.assertElementValue;
import static com.example.helpers.ElementsInteraction.getWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * This class contains global (common) steps that do not belong to any specific page
 * As well as all the entry points into the system (open a url)
 */
public class GlobalSteps {
    @Given("I open start page")
    public NorthWind iOpenDashboardPage() throws InterruptedException {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        Thread.sleep(3000);
        return new NorthWind();
    }





    @When("sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(3000);
    }



}


