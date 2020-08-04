package com.example.pageObjects;

import com.example.BasePage;

import com.example.helpers.ElementsInteraction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;
/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class Homework extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Google"));
    }

    private WebElement seachBoxGetter() {
        return getDriver().findElement(By.xpath("//input[@name='q']"));
    }

    private void clickSeachButtonGetter() throws InterruptedException {
        WebElement element = seachBoxGetter();
        element.sendKeys(Keys.ENTER);
    }

    private WebElement imageTabGetter(){
        return getDriver().findElement(By.xpath("//a[@data-sc='I']"));
    }

    @When("I type \"aaaaaaaaaa\"")
    public void sendKeysToSearchBox() throws InterruptedException {
        WebElement element = seachBoxGetter();
        element.sendKeys("Hello Word");
        Thread.sleep(2000);
    }

    @And("And I hit Enter")
    public void iClickSearchButton() throws InterruptedException {
        clickSeachButtonGetter();
        Thread.sleep(2000);
    }

    @Then("i verify image tab has {string} text")
    public void iVerifyImageTabHasText(String arg0) {
        WebElement element =imageTabGetter();
       String actualResult = element.getText();
        Assert.assertEquals(actualResult,"Images");
    }
}
