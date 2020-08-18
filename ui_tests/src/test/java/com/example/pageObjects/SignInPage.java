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
public class SignInPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    @And("^user clicks at Sign Up button on top left corner$")
    public void clickSignUpButton (){
        getSignUpButton().click();
    }

    @And("^user fills out Sign Up form with valid data$")
    public void fillOutSignUpForm() throws InterruptedException {
        String userName = "rossabdu3";
        getUserNameField().sendKeys(userName);
        sleep(2000);

        String password = "Tashkent1!";
        getPasswordField().sendKeys(password);
        sleep(2000);

        getConfirmPasswordField().sendKeys(password);
        sleep(2000);

        String email = "hamroz.abduhoshimov@gmail.com";
        getEmailAddressField().sendKeys(email);

        String fullName = "Ross Abdu";
        getFullNameField().sendKeys(fullName);

        String address = "1600 Pennsylvania Avenue NW";
        getAddressField().sendKeys(address);

        String city = "Washington";
        getCityField().sendKeys(city);

        String state = "DC";
        getStateField().sendKeys(state);
    }

    @When("^user submits Sign Up button on the bottom of the form$")
    public void submitSignUpForm(){
        getDriver().findElement(By.xpath("//button[@id='submit']")).click();
    }

    @Then("^user should be navigated to Sign In page$")
    public void returnToSignInPage() throws InterruptedException {
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
        sleep(2000);
    }

    @And("^user Signs In by entering valid Username and Password$")
    public void logIn() throws InterruptedException{
        WebElement usernameBox = getDriver().findElement(By.id("usernameBoxId"));
        String textInsideUsernameBox = usernameBox.getAttribute("");
    }

    /* ********************************************** SLEEPING ******************************************************************************************************* */

    @When("sleeping")
    public void sleep(int i) throws InterruptedException {
        Thread.sleep(2000);
    }
    /* ********************************************** GETTER ********************************************************************************************************* */

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