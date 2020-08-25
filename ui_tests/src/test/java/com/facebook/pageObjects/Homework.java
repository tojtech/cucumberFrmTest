package com.facebook.pageObjects;

import com.facebook.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static com.facebook.CucumberHooks.getDriver;
import static com.facebook.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class Homework extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    public void waitFor3Sec() throws InterruptedException {
        Thread.sleep(3000);
    }

    public WebElement getterProductCategories() {
        return getDriver().findElement(By.xpath("//div[@id='categories-tile']"));
    }

    public WebElement getterCalatalog() {
        return getDriver().findElement(By.xpath(" //a[@href='#group-c32516babc5b6c47eb8ce1bfc223253c']"));
    }

    public WebElement getterProducts() {
        return getDriver().findElement(By.xpath("//div[@id='products-tile']//a"));
    }

    public WebElement getterPolinaSub() {
        return getDriver().findElement(By.xpath("//td[@id='products-SupplierID-17']"));
    }

    public void clickOnOrderItems() {
        getDriver().findElement(By.xpath("//a[@id='order_details_link']")).click();
    }


    @And("Click Catalog drop-down")
    public void click() throws InterruptedException {
        waitFor3Sec();
        getterCalatalog().click();
        waitFor3Sec();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,500);");
        waitFor3Sec();
    }

    @Then("Verify Catalog is expanded")
    public void verifyCatalogIsExpanded() {
        Assert.assertTrue(getterProductCategories().isDisplayed());
        System.out.println("Catalog has been expanded");
    }

    @And("Click Products")
    public void clickProducts() throws InterruptedException {
        getterProducts().click();
        waitFor3Sec();
    }

    @Then("Verify User is landed on the Products page")
    public void verifyUserIsLandedOnTheProductsPage() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://bigprof.com/demo/products_view.php");
        System.out.println("User landed on the Products page");
    }


    @And("Click “Pavlova, Ltd.“ Supplier")
    public void clickPavlovaLtdSupplier() throws InterruptedException {
        waitFor3Sec();
        getterPolinaSub().click();
        waitFor3Sec();
    }

    @Then("Verify Product ID is {int}")
    public void verifyProductIDIs(int arg0) {
        String idOfPavla = getDriver().findElement(By.xpath("//div[text()='17']")).getText();
        Assert.assertEquals(idOfPavla, "17");
        System.out.println("Product ID is verified");
    }

    @And("Verify that Category is “Meat\\/Poltry“")
    public void verifyThatCategoryIsMeatPoltry() {
        String idOfPavla = getDriver().findElement(By.xpath("//span[@id='CategoryID-match-text']")).getText();
        Assert.assertEquals(idOfPavla, "Meat/Poultry");
        System.out.println("Category is \"Meat/Poltry\" is verified ");
    }

    @And("Click “Order Items“")
    public void clickOrderItems() throws InterruptedException {
        waitFor3Sec();
        clickOnOrderItems();
        waitFor3Sec();
    }

    @Then("Verify you are landed on Order Items page")
    public void verifyYouAreLandedOnOrderItemsPage() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://bigprof.com/demo/order_details_view.php?filterer_ProductID=17&");
        System.out.println("User landed on \"Order Items\" page");
    }

    @Then("Verify that for all {int} rows Product is Alice Mutton")
    public void verifyThatForAllRowsProductIsAliceMutton(int arg0) {
        List<WebElement> listElements = getDriver().findElements(By.xpath("//form[@name='myform']//a[contains(text(),'Alice Mutton')]"));
        for (int x = 0; x < 10; x++) {
            Assert.assertEquals(listElements.get(x).getText(), "Alice Mutton", "Something went wrong");
        }
        System.out.println("10 rows are \"Alice Muntton\" is verified");
    }


    @And("And Verify that for all {int} rows Category is {string}, Ltd.")
    public void andVerifyThatForAllRowsCategoryIsLtd(int arg0, String arg1) {
        List<WebElement> listElements = getDriver().findElements(By.xpath("//form[@name='myform']//a[contains(text(),'Meat/Poultry / Pavlova, Ltd')]"));
        for (int y = 0; y < 10; y++) {
            Assert.assertEquals(listElements.get(y).getText(), "Meat/Poultry / Pavlova, Ltd.", "Something went wrong");
        }
        System.out.println("10 rows are \"Meat/Poultry / Pavlova\" is verified");

    }

    }





