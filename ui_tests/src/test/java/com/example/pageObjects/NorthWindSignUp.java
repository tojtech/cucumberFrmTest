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
public class NorthWindSignUp extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    @And("^user clicks Sign In button on top left corner$")
    public SignInPage clickSignInButton(){
        getSignInButton().click();
        return new SignInPage();
    }

    @And("^user clicks at Sign Up button on top left corner$")
    public void clickSignUpButton (){
        getSignUpButton().click();
    }

    @And("^user enters valid username: \"([^\"]*)\"$")
    public void enterValidUsername(String userName) throws InterruptedException {
        getUserNameField().sendKeys(userName);
        Thread.sleep(2000);
    }

    @And("^user enters valid password: \"([^\"]*)\"$")
    public void enterValidPassword(String password) throws InterruptedException {
        getPasswordField().sendKeys(password);
        Thread.sleep(2000);
    }
    @And("^user confirms password: \"([^\"]*)\"$")
    public void confirmValidPassword(String password) throws InterruptedException {
        getConfirmPasswordField().sendKeys(password);
        Thread.sleep(2000);
    }
    @And("^user enters valid email: \"([^\"]*)\"$")
    public void enterEmail(String email) throws InterruptedException {
        getEmailAddressField().sendKeys(email);
        Thread.sleep(2000);
    }
    @And("^user enters valid Full Name: \"([^\"]*)\"$")
    public void enterFullName(String fullName) throws InterruptedException {
        getFullNameField().sendKeys(fullName);
        Thread.sleep(2000);
    }
    @And("^user enters valid Address: \"([^\"]*)\"$")
    public void enterAddress(String address) throws InterruptedException {
        getAddressField().sendKeys(address);
        Thread.sleep(2000);
    }
    @And("^user enters valid City: \"([^\"]*)\"$")
    public void enterCity(String city) throws InterruptedException {
        getCityField().sendKeys(city);
        Thread.sleep(2000);
    }
    @And("^user enters valid State: \"([^\"]*)\"$")
    public void enterState(String state) throws InterruptedException {
        getStateField().sendKeys(state);
        Thread.sleep(2000);
    }

/* ********************************************** GETTER ********************************************** */
    public WebElement getSignInButton(){
        return getDriver().findElement(By.xpath("/html//nav[@role='navigation']//a[@href='index.php?signIn=1']"));
    }
    public WebElement getSignUpButton (){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[@class='row']//div[@class='panel-heading']/a[@href='membership_signup.php']"));
    }
    public WebElement getUserNameField(){
        return getDriver().findElement(By.xpath("//input[@id='username']"));
    }
    public WebElement getPasswordField(){
        return getDriver().findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement getConfirmPasswordField(){
        return getDriver().findElement(By.xpath("//input[@id='confirmPassword']"));
    }
    public WebElement getEmailAddressField(){
        return getDriver().findElement(By.xpath("//input[@id='email']"));
    }
    public WebElement getFullNameField(){
        return getDriver().findElement(By.xpath("//input[@id='custom1']"));
    }
    public WebElement getAddressField(){
        return getDriver().findElement(By.xpath("//input[@id='custom2']"));
    }
    public WebElement getCityField(){
        return getDriver().findElement(By.xpath("//input[@id='custom3']"));
    }
    public WebElement getStateField(){
        return getDriver().findElement(By.xpath("//input[@id='custom4']"));
    }

}
