package com.example.pageObjects.Execises;

import com.example.BasePage;

import com.example.helpers.ElementsInteraction;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import javax.swing.*;


import java.util.List;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.assertElementText;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class Test1 extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Orders"));

    }

    public WebElement getMoreButton(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[2]/div[2]/button"));
    }

    @And("check first row")
    public void checkFirst(){
        getDriver().findElement(By.xpath("//input[@id='record_selector_11079']")).click();

    }

    @And("I verify More button is visible")
    public void verifyMoreButton(){
        Assert.assertEquals(getMoreButton().getAttribute("id"), "selected_records_more","it works");
    }

    @And("i click More button")
    public void iClickMoreButton() throws InterruptedException {
        getMoreButton().click();
        Thread.sleep(2000);
    }


    @When("i click print preview button")
    public void iClickPrintPreviewButton() throws InterruptedException {
        getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[2]/div[2]/ul/li/a")).click();
        Thread.sleep(2000);
    }

    @Then("user should see print preview page")
    public void userShouldSeePrintPreviewPage() throws InterruptedException {
        Assert.assertEquals(getDriver().findElement(By.cssSelector("#back")).getAttribute("title"), "Cancel Printing","it should work");
        Thread.sleep(2000);
    }
}
