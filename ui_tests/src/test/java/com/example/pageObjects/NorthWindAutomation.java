package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.example.helpers.ElementsInteraction.*;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;


public  class NorthWindAutomation extends BasePage{
    public void isPageOpened()  {

        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }
    @Then("I go through sign up process")
    public void iGoThroughSignUpProcess() throws InterruptedException {
        WebElement signInButtonDr = signInElement();
            signInButtonDr.click();
        WebElement signUpButtonDr = initialPageSingUpElement();
            signUpButtonDr.click();
                Thread.sleep(2000);
        WebElement usernameDrElement = userNameField();
            usernameDrElement.sendKeys("admin");
        WebElement passWorDrElement = passwordField();
            passWorDrElement.sendKeys("12345a");
        WebElement confirmPassword = confirmPasswordField();
            confirmPassword.sendKeys("12345a");
        WebElement emailDrElement = emailField();
            emailDrElement.sendKeys("info1@mail.com");
        WebElement fullNameDrElement = fullNameField();
           fullNameDrElement.sendKeys("oops");
        WebElement addressDrElement = addressField();
           addressDrElement.sendKeys("100 E 10th st");
        WebElement cityDrElement = cityField();
           cityDrElement.sendKeys("Nyc");
        WebElement stateDrElement=stateField();
            stateDrElement.sendKeys("NY");
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1500);");
        WebElement signUpButtonAfterFillingTheForm = signUpButton();
            signUpButtonAfterFillingTheForm.click();
    }


    public WebElement signInElement(){
     return getDriver().findElement(By.cssSelector(".navbar-collapse > a"));
    }
    public WebElement initialPageSingUpElement(){
        return getDriver().findElement(By.cssSelector("div.panel-heading > a"));
    }
    public WebElement userNameField(){
        return getDriver().findElement(By.cssSelector("input[id='username']"));
    }
    public WebElement passwordField(){
        return getDriver().findElement(By.cssSelector("input[id=password]"));
    }
    public WebElement confirmPasswordField(){
        return getDriver().findElement(By.cssSelector("input[id=confirmPassword]"));
    }
    public WebElement emailField(){
        return getDriver().findElement(By.cssSelector("input[id=email]"));
    }
    public WebElement fullNameField(){
        return getDriver().findElement(By.cssSelector("input[id=custom1]"));
    }
    public WebElement addressField(){
        return getDriver().findElement(By.cssSelector("input[id=custom2]"));
    }
    public WebElement cityField(){
        return getDriver().findElement(By.cssSelector("input[id=custom3]"));
    }
    public WebElement stateField(){
        return getDriver().findElement(By.cssSelector("input[id=custom4]"));
    }
    public WebElement signUpButton(){
        return getDriver().findElement(By.cssSelector("button[id='submit']"));
    }

    @When("sleep and close popup")
    public void sleepClosePopup() throws InterruptedException {
        Thread.sleep(1000);
        WebElement closeButtonOnModal = getDriver().findElement(By.xpath("//div[@class='modal-footer']/button"));
        Thread.sleep(2000);
        closeButtonOnModal.click();
    }

    @Then("logging in to the site")
    public void loggingInToTheSite() {

    }
}



