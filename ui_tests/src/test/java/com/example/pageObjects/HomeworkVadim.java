package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class HomeworkVadim extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    public void SendKeys(By elementInput, String text){
        getDriver().findElement(elementInput).sendKeys(text);
    }
    String userName= "firdavs1235";
    @And("Go through sign up process")
    public void sighIn() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@class='btn btn-success navbar-btn navbar-right']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[@class='btn btn-success pull-right']")).click();
        Thread.sleep(2000);
        SendKeys(By.id("username"),userName);
        SendKeys(By.id("password"),"Firdavs1");
        SendKeys(By.id("confirmPassword"),"Firdavs1");
        SendKeys(By.id("email"),"Whatever@gmail.co");
        SendKeys(By.id("custom1"),"FirstName");
        SendKeys(By.id("custom3"),"weqw");
        getDriver().findElement(By.id("submit")).click();
        Thread.sleep(10000);
    }

    @And("Login to the site")
    public void loginToTheSite() throws InterruptedException {
        getDriver().findElement(By.id("username")).sendKeys(userName);
        getDriver().findElement(By.id("password")).sendKeys("Firdavs1");
    getDriver().findElement(By.id("submit")).click();
    Thread.sleep(3000);

    }

    @When("Verify User is logged in")
    public void verifyUserIsLoggedIn() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(getDriver().findElement(By.xpath("//p[@class='navbar-text']//a")).getText(),userName);
    }

    @And("Click AppGini homepage")
    public void clickAppGiniHomepage() {
        getDriver().findElement(By.xpath("//a[@class='btn btn-block btn-lg btn-success']")).click();

    }

    @Then("I verify User is on AppGini homepage")
    public void iVerifyUserIsOnAppGiniHomepage() {
    Assert.assertEquals(getDriver().getCurrentUrl(),"https://bigprof.com/appgini/","Was not valid");

    }

    @And("Click Back button of browser")
    public void clickBackButtonOfBrowser() {
        getDriver().navigate().back();
    }

    @And("Verify User is back to Northwind homepage")
    public void verifyUserIsBackToNorthwindHomepage() {
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://bigprof.com/demo/index.php","Was not valid");
    }

    @Then("I click Customers")
    public void iClickCustomers() {
        getDriver().findElement(By.xpath("//a[@class='btn btn-block btn-lg btn-warning']")).click();
    }

    @And("Verify User is landed on Customers page")
    public void verifyUserIsLandedOnCustomersPage() {
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://bigprof.com/demo/customers_view.php","was not valid");
    }

    @And("Click at Customer Id BLONP")
    public void clickAtCustomerIdBLONP() {
        getDriver().findElement(By.id("customers-CustomerID-BOLID")).click();
    }

    @Then("Verify User is on Customers page with Deatil View block, and Customer Id there is BLONP respectively")
    public void verifyUserIsOnCustomersPageWithDeatilViewBlockAndCustomerIdThereIsBLONPRespectively() {
        Assert.assertEquals(getDriver().findElement(By.xpath("//a[@class='hidden-xs btn btn-default btn-lg pull-right hspacer-sm']")).isDisplayed(),true);
    }
}
