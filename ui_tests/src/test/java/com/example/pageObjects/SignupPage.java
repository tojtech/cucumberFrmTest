package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static com.example.helpers.ElementsInteraction.getWait;
import static com.example.CucumberHooks.getDriver;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class SignupPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    @And("^user clicks at Sign Up button on the top right corner$")
    public void clickSignupButton(){
        getSignup().click();
    }

    @And("^user fills out Sign Up form$")
    public void fillSignupForm() throws InterruptedException {
        String username = "jaime3"; //NOTE before each execution remember to change username
        getUsernameBox().sendKeys(username);
        Thread.sleep(2000);

        String password = "Showroom654";
        getPassword().sendKeys(password);
        getConfirmPassword().sendKeys(password);
        Thread.sleep(2000);

        String emailAddress = "jalencastro@hotmail.com";
        getEmailAddress().sendKeys(emailAddress);
        Thread.sleep(2000);

        String fullName = "Jaime Tojtech";
        getFullName().sendKeys(fullName);
        Thread.sleep(2000);

        String address = "123 Fairytale Lane";
        getAddress().sendKeys(address);
        Thread.sleep(2000);

        String city = "Lefrak";
        getCity().sendKeys(city);
        Thread.sleep(2000);

        String state = "New York";
        getState().sendKeys(state);
        Thread.sleep(2000);
    }
    @And("^user clicks Sign Up button on bottom of page$")
    public void submitSignupButton() throws InterruptedException {
        getSignUpButton().click();
        Thread.sleep(10000);
    }


// ********************** GETTERS *****************

    public WebElement getSignup(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[1]/a"));
    }
    public WebElement getUsernameBox() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[1]/input"));
    }
    public WebElement getPassword() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[2]/div[1]/div/input"));
    }
    public WebElement getConfirmPassword() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[2]/div[2]/div/input"));
    }
    public WebElement getEmailAddress() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[3]/input"));
    }
    public WebElement getFullName() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[5]/div[2]/input"));
    }
    public WebElement getAddress() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[6]/div[2]/input"));
    }
    public WebElement getCity() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[7]/div[2]/input"));
    }
    public WebElement getState() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[8]/div[2]/input"));
    }
    public WebElement getSignUpButton() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[2]/form/div[9]/div/button"));
    }



// EXTRAS
    ////scrolls down
    // JavascriptExecutor js = (JavascriptExecutor) getDriver();
    //        js.executeScript("window.scrollBy(0,1500);");
    //
    // add thread sleep 2000 in between

    //// scrolls up
    //JavascriptExecutor js = (JavascriptExecutor) getDriver();
    //        js.executeScript("window.scrollBy(0,-1500);");

}
