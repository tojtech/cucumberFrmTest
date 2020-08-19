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
public class ProductsPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleIs("Northwind | Products"));
    }

    @And("^user verifies the landed page is Products page$")
    public void verifyProductsPage() throws InterruptedException{
        Assert.assertEquals(getProductsPageName().getText(), "Products");
    }

    @And("^user clicks at Perth Pasties row$")
    public void clickPerthPasties() throws InterruptedException {
        getPerthPasties().click();
        sleep(2000);
    }

    @And("^user verifies Product ID is: \"([^\"]*)\"$")
    public void verifyProductId(String productID) throws InterruptedException {
        Assert.assertTrue(getProductId().getText().contains(productID), "53");
        sleep(2000);
    }


    /* ********************************************** SLEEPING ******************************************************************************************************* */

    @When("sonMeansSleep")
    public void sleep(int i) throws InterruptedException {
        Thread.sleep(2000);
    }

    /* ********************************************** GETTER ********************************************** */
    public WebElement getProductsPageName(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[1]/h1/div/div[1]/a"));
    }
    public WebElement getPerthPasties(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div/div[1]/table/tbody/tr[4]/td[2]/a"));
    }
    public WebElement getProductId(){
        return getDriver().findElement(By.xpath("//div[@id='ProductID']"));
    }
}
