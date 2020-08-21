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
public class SignedInPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    @And("^user verifies he is logged in$")
    public void verifyLogin() throws InterruptedException {
        String username = "jaime1"; //NOTE before each execution remember to change username
        getUsernameBox().sendKeys(username);
        Thread.sleep(2000);

        String password = "Showroom654";
        getPassword().sendKeys(password);
        Thread.sleep(2000);

        getSignInButton().click();

        Assert.assertEquals(getVerifiedUsername().getText(), "jaime1");
    }

    @And("^verify description of Orders contains \"([^\"]*)\"$")
    public void verifyOrdersDescription(String ordersText) throws InterruptedException {
        Assert.assertTrue(getOrderText().getText().contains(ordersText));
        Thread.sleep(2000);
    }

    @And("^user clicks on Orders button$")
    public void clickOrdersButton() throws InterruptedException {
        getClickOrdersButton().click();
        Thread.sleep(2000);
    }

    @And("^user verifies Orders page is opened$")
    public void verifyOrdersPageOpened(){
        Assert.assertEquals(getDriver().getTitle(), "Northwind | Orders");
    }

    @And("^user clicks Sales dropdown at the header$")
    public void clickSalesDropdown() throws InterruptedException {
        getClickSalesDropdown().click();
        Thread.sleep(2000);
    }

    @And("^user then clicks Customers from that dropdown$")
    public void clickCustomersFromDropdown() throws InterruptedException {
        getClickCustomersFromDropdown().click();
        Thread.sleep(2000);
    }

    @And("^user verifies Customers page is opened$")
    public void verifyCustomersPageOpened(){
        Assert.assertEquals(getDriver().getTitle(), "Northwind | Customers");
    }

    @And("^user clicks on Customer ID Anton$")
    public void clickCustomerAnton() throws InterruptedException {
        getClickCustomerAnton().click();
        Thread.sleep(2000);
    }

    @And("^user verifies Anton customer page is opened$")
    public void verifyAntonOpened(){
        Assert.assertEquals(getVerifiedAnton().getText(), "ANTON");
    }


// ********************** GETTERS *****************

    public WebElement getUsernameBox() {
        return getDriver().findElement(By.xpath("//input[@id='username']"));
    }

    public WebElement getPassword() {
        return getDriver().findElement(By.xpath("//input[@id='password']"));
    }

    public WebElement getClickCustomerAnton() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div/div[1]/table/tbody/tr[3]/td[2]/a"));
    }

    public WebElement getClickCustomersFromDropdown() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul[1]/li[1]/ul/li[1]/a"));
    }

    public WebElement getClickSalesDropdown() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul[1]/li[1]/a"));
    }

    public WebElement getOrderText() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div[2]"));
    }

    public WebElement getVerifiedUsername() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul[2]/p/strong/a"));
    }

    public WebElement getSignInButton() {
        return getDriver().findElement(By.xpath("//button[@id='submit']"));
    }

    public WebElement getClickOrdersButton() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div[1]/a[1]/strong"));
    }

    public WebElement getVerifiedAnton() {
        return getDriver().findElement(By.xpath("//div[@id='CustomerID']"));
    }

// EXTRAS
        ////scrolls down
        // JavascriptExecutor scrollDown = (JavascriptExecutor) getDriver();
        //        scrollDown.executeScript("window.scrollBy(0,1500);");
        //
        // add thread sleep 2000 in between

        //// scrolls up
        //JavascriptExecutor scrollUp = (JavascriptExecutor) getDriver();
        //        scrollUp.executeScript("window.scrollBy(0,-1500);");


}
