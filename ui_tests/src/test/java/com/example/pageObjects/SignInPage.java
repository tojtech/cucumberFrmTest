package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @When("^user Signs In by entering valid Username and Password$")
    public void logIn() throws InterruptedException{
        WebElement usernameBox = getDriver().findElement(By.id("username"));
        String textInsideUsernameBox = usernameBox.getText();
        if (textInsideUsernameBox.isEmpty()){
            getDriver().findElement(By.xpath("//input[@id='username']")).sendKeys("rossabdu6"); //username should be updated before pushing code
        }else {
            Assert.assertEquals(textInsideUsernameBox, "rossabdu6"); //username should be updated before pushing code
        }
        sleep(2000);

        WebElement passwordBox = getDriver().findElement(By.id("password"));
        String textInsidePasswordBox = passwordBox.getText();
        if (textInsidePasswordBox.isEmpty()){
            getDriver().findElement(By.id("password")).sendKeys("Tashkent1!");
        }
        sleep(2000);

        getDriver().findElement(By.id("rememberMe")).click();
        sleep(1000);

        getSignInButton().click();
        sleep(2000);

    }

    @Then("^user expands Catalog menu on the bottom of the page$")
    public void expandCatalog() throws InterruptedException {
        Assert.assertEquals(getSignedInAs().getText(), "rossabdu6"); //username should be updated before pushing code
        // scrolls down
        JavascriptExecutor scrollDown = (JavascriptExecutor) getDriver();
        scrollDown.executeScript("window.scrollBy(0,1500);");
        sleep(2000);

        getCatalog().click();

        /*// scrolls up
        JavascriptExecutor scrollUp = (JavascriptExecutor) getDriver();
        scrollUp.executeScript("window.scrollBy(0,-1500);");*/
    }

    @And("^user opens Product Categories$")
    public ProductCategoriesPage clickProductCategories() throws InterruptedException {
        getProductCategories().click();
        return new ProductCategoriesPage();
    }

    /* ********************************************** SLEEPING ******************************************************************************************************* */

    @When("sleeping")
    public void sleep(int i) throws InterruptedException {
        Thread.sleep(2000);
    }


    /* ********************************************** GETTER ********************************************** */
    public WebElement getSignInButton(){
        return getDriver().findElement(By.xpath("//button[@id='submit']"));
    }
    public WebElement getSignedInAs(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul[2]/p/strong/a"));
    }
    public WebElement getCatalog(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/a[3]"));
    }
    public WebElement getProductCategories(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div/a"));
    }

}
