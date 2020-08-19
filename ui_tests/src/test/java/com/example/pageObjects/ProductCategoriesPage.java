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
public class ProductCategoriesPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
        getWait().until(ExpectedConditions.titleIs("Northwind | Product Categories"));
    }

    @And("^user verifies the landed page is Product Categories page$")
    public void verifyProductCategoriesPage() throws InterruptedException{
        Assert.assertEquals(getPageName().getText(), "Product Categories");
    }

    @And("^user clicks at Meat/Poultry row$")
    public void clickMeatPoultry() throws InterruptedException {
        JavascriptExecutor scrollDown = (JavascriptExecutor) getDriver();
        scrollDown.executeScript("window.scrollBy(0, 500);");
        sleep(2000);
        getMeatPoultry().click();
    }

    @And("^user verifies Category name and Description$")
    public void verifyCategoryAndDescription() throws InterruptedException {
        Assert.assertEquals(getCategoryName().getText(), "Meat/Poultry");
        Assert.assertEquals(getPageDescription().getText(), "Prepared meats");
        sleep(2000);
    }

    @And("^user clicks Products button on top right corner$")
    public ProductsPage clickProducts(){
        getProducts().click();
        return new ProductsPage();
    }


    /* ********************************************** SLEEPING ******************************************************************************************************* */

    @When("uykuMeansSleep")
    public void sleep(int i) throws InterruptedException {
        Thread.sleep(2000);
    }

    /* ********************************************** GETTER ********************************************** */
    public WebElement getPageName(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[1]/h1/div/div[1]/a"));
    }
    public WebElement getMeatPoultry(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div/div[1]/table/tbody/tr[3]/td[3]/a"));
    }
    public WebElement getCategoryName(){
        return getDriver().findElement(By.xpath("//div[@id='CategoryName']"));
    }
    public WebElement getPageDescription(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div/form/div[2]/div/div[2]/div[2]/div[1]/fieldset/div[4]/div/div[2]/div"));
    }
    public WebElement getProducts(){
        return getDriver().findElement(By.xpath("//a[@id='products_link']"));
    }
}
