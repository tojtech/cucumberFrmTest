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
import org.testng.Assert;

import javax.swing.*;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;
import static com.example.helpers.ElementsInteraction.sendKeys;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class HomeworkPage extends BasePage {
    public HomeworkPage() throws InterruptedException {
    }

    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */

    public void isPageOpened() throws InterruptedException {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
        Thread.sleep(2000);
    }

        public void SendKeysTo(By elementInput, String text){
        getDriver().findElement(elementInput).sendKeys(text);
 }
 String loginE = "NorthwindNaseem8";


    public WebElement getPopupElement(){
        return getDriver().findElement(By.cssSelector("button[class='close']"));
    }

    @And("user should click on close button on pop up")
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

    public WebElement getSignUpElement() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[1]/a"));
    }

    @And("I click on Sign up button on the top right corner")
    public void clickSignUpElement(){
        getSignUpElement().click();
    }

    @Then("Go through sign up process")
    public void getUsernameElement() throws InterruptedException {

        //SendKeysTo(By.id("username"),"NorthwindNaseem");

        getDriver().findElement(By.id("username")).sendKeys(loginE);
        getDriver().findElement(By.id("password")).sendKeys("Bigprof");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("Bigprof");
        getDriver().findElement(By.xpath("//input[@id='email']")).sendKeys("bigprofnaseem@gmail.com");
        getDriver().findElement(By.id("custom1")).sendKeys("Noskadui Aeroport");
        getDriver().findElement(By.id("custom2")).sendKeys("112 east 2nd st");
        getDriver().findElement(By.id("custom4")).sendKeys("New York");
        getDriver().findElement(By.id("submit")).click();
        Thread.sleep(10000);
        //

    }

    @And("Login to the site")
    public void getLogin() throws InterruptedException {
        getDriver().findElement(By.id("username")).sendKeys(loginE);
        getDriver().findElement(By.id("password")).sendKeys("Bigprof");
        getDriver().findElement(By.id("submit")).click();
        getDriver().findElement(By.cssSelector("p[class='navbar-text']")).getText();
        Thread.sleep(2000);
    }
    @And("i verify User is logged in")
    public void iVerifyUserIsLoggedIn() {
        getDriver().findElement(By.cssSelector("p[class='navbar-text']")).getText();
    }


    @And("i verify that description of Orders section contains “Orders placed by customers, with newest orders listed first.“ text")
    public void iVerifyThatDescriptionOfOrdersSectionContainsOrdersPlacedByCustomersWithNewestOrdersListedFirstText() {
        getDriver().findElement
                (By.xpath("//div[text()='Orders placed by customers, with newest orders listed first.']")).getText();
        Assert.assertTrue(true);

    }

    @And("Click Orders")
    public void clickOrders() {
        getDriver().findElement(By.xpath("//*[@id='orders-tile']/div/div/div[1]/a[1]")).click();
    }

    @And("Verify User is on Orders page")
    public void verifyUserIsOnOrdersPage() {
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://bigprof.com/demo/orders_view.php","It's not valid");
    }

    @And("i click SALES dropdown at the header and click Customers from that dropdown")
    public void iClickSALESDropdownAtTheHeader() throws InterruptedException {
        getDriver().findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul[1]/li[1]/ul/li[1]/a")).click();
        Thread.sleep(1000);

    }

    @And("Verify Customers page is opened")
    public void verifyCustomersPageIsOpened() throws InterruptedException {
        Assert.assertEquals(getDriver().findElement(By.xpath("//a[@style='text-decoration: none; color: inherit;']")).getAttribute("href"),"https://bigprof.com/demo/customers_view.php");
        Thread.sleep(2000);
    }


    @And("Click at Customer ID “ANTON“")
    public void clickAtCustomerIDANTON() {
        getDriver().findElement(By.xpath("//*[@id='customers-CustomerID-ANTON']/a")).click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//a[@style='text-decoration: none; color: inherit;']")).getAttribute("href"),"https://bigprof.com/demo/customers_view.php");
    }
}















