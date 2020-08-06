package com.example.pageObjects;

import com.example.BasePage;
import com.example.TestsConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.ObjectInputStream;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class javaScript1 extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Google"));
    }
    public WebElement seachBoxGetter(){
            return  getDriver().findElement(By.name("q"));
    }
    public WebElement imageTabGetter(){
        return  getDriver().findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[3]/a"));
    }
    public void waitFor3Sec() throws InterruptedException {
        Thread.sleep(3000);
    }

    String baseTitle = getDriver().getTitle();

    @And("i search for BMW and i hit enter")
    public void searchForBmW() throws InterruptedException {
        seachBoxGetter().sendKeys("BMW");
        waitFor3Sec();
        seachBoxGetter().sendKeys(Keys.ENTER);
        waitFor3Sec();
    }

    @And("i click on Image tab")
    public void iClickOnImageTab() throws InterruptedException {
        imageTabGetter().click();
        waitFor3Sec();
    }


    @And("i scroll down and up")
    public void iCrollDownAndUp() throws InterruptedException {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,1700);");
        waitFor3Sec();
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,-1700);");
        waitFor3Sec();


    }

    @Then("i go back to the main page")
    public void iGoBackToTheMainPage() throws InterruptedException {
        waitFor3Sec();
        getDriver().navigate().refresh();
        waitFor3Sec();
        getDriver().navigate().to(TestsConfig.getConfig().getBaseUrl());
        String title = getDriver().getTitle();

        Assert.assertEquals(baseTitle, title);
    }
}
