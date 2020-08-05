package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class singInPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    private void signInButtonGetter(){
        String loginURL = "https://bigprof.com/demo/index.php?signIn=1";
        getDriver().navigate().to(loginURL);
    }

    private   WebElement userNameTextBoxGetter(){
        return  getDriver().findElement(By.id("username"));
    }
    private WebElement passwordTextBoxGetter(){
        return  getDriver().findElement(By.id("password"));
    }
    private void clickSubmitButton(){
        getDriver().findElement(By.id("submit")).click();
    }

    private void clickSignOutButton(){
          getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul[2]/a")).click();
    }

    @And("i click Sign in button")
    public void clickOn() throws InterruptedException {
       signInButtonGetter();
        Thread.sleep(2000);
    }

// manully
    @And("^i type my user name with valid data and with invalid data \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iTypeMyUserNameWithValidDataAndWithInvalidDataAnd(String username, String password) throws InterruptedException {
        userNameTextBoxGetter().sendKeys(username);
        Thread.sleep(2000);
        passwordTextBoxGetter().sendKeys(password);
        Thread.sleep(2000);

    }

//    @And("i type my user name with valid data and with invalid data \"([^\"]*)\"  and \"([^\"]*)\"$")
//    public void iTypeMyUserNameVithValidDataAndWithInvalidDataAnd(String username, String password) throws InterruptedException {
//        Thread.sleep(2000);
//        userNameTextBoxGetter().sendKeys(username);
//        Thread.sleep(2000);
//        passwordTextBoxGetter().sendKeys(password);
//    }


    @And("i click Sign In button")
    public void iClickSignInButton() throws InterruptedException {
        clickSubmitButton();
        Thread.sleep(2000);
    }

    @Then("i sign out")
    public void iSignOut() throws InterruptedException {

        if (getDriver().getCurrentUrl().equals("https://bigprof.com/demo/index.php?loginFailed=1")) {
            System.out.println("Invalid data");
            Thread.sleep(2000);
            getDriver().quit();
        } else {
            clickSignOutButton();
            Thread.sleep(2000);
            getDriver().quit();
        }
    }
}
