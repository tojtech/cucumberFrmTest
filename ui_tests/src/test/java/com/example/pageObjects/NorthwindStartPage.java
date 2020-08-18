package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class NorthwindStartPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */

    public void isPageOpened() throws InterruptedException {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
        Thread.sleep(2000);

    }

    public WebElement getPopupElement() {
        return getDriver().findElement(By.cssSelector("button[class='btn btn-default']"));
    }

    @And("pop up message displays on the page that i should close")
    public void clickPopupElement() throws InterruptedException {
        getPopupElement().click();
        Thread.sleep(1000);
    }


    public WebElement getSignInElement() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/a"));

    }

    @And("I click on Sign in button  where i should be navigated to Sign in page")
    public void clickSignInElement() throws InterruptedException {
        getSignInElement().click();
        Thread.sleep(2000);

    }

    @Then("I type my username in username bar using invalid username")
    public void getUsernameElement() throws InterruptedException {
        getDriver().findElement(By.id("username")).sendKeys("Northwind");
        Thread.sleep(2000);
    }

    @And("i type my password in password bar using invalid password")
    public void getPasswordElement() throws InterruptedException {
        getDriver().findElement(By.id("password")).sendKeys("Bigprof");
        Thread.sleep(2000);
    }

    public WebElement getRememberMeElement() {
        return getDriver().findElement(By.id("rememberMe"));
    }

    @And("i click on Remember me checkbox")
    public void clickRememberMeElement() throws InterruptedException {
        getRememberMeElement().click();
        Thread.sleep(1000);
    }

    public WebElement submitSignIn() {
        return getDriver().findElement(By.id("submit"));
    }

    @And("i click on sign in button")
    public void clickSignIn() throws InterruptedException {
        submitSignIn().click();
        Thread.sleep(2000);
    }

    public WebElement getErrorMessageElement() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]"));
    }

    @Then("i should see error message displayed on the page")
    public void ErrorMessageElement() throws InterruptedException {
        getErrorMessageElement().getText();
        System.out.println(getErrorMessageElement().getText());
        Thread.sleep(2000);
    }

    public WebElement getSignupElement(){
        return getDriver().findElement(By.cssSelector("a[class='btn btn-success pull-right']"));
    }

    @And("after seeing error message i click on Sign Up button")
    public void clickSignUpElement(){
        getSignupElement().click();
    }

}















