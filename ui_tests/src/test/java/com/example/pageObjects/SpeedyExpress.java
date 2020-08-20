
package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;


public class SpeedyExpress extends BasePage {

    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }
    public WebElement getOperationsButton(){
       return getDriver().findElement(By.xpath("/html/body/div[1]/a[2]"));
}
    public WebElement getOperationsField() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[5]"));
    }
    public WebElement getShippersButton(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[3]/div/div/a/strong"));
    }
    public WebElement getShippersField(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[1]/h1/div/div[1]/a"));
    }
    public WebElement getCheckboxSpeedy() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div[1]/div[1]/table/tbody/tr[2]/td[1]/input"));
    }
    public WebElement getMoreButton() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[2]/div[2]/button"));
    }
        public WebElement getRecords() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div[1]/div[1]/table/tfoot/tr/td"));
    }
    public WebElement getSpeedyExpress() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div[1]/div[1]/table/tbody/tr[2]/td[2]/a"));
    }
    public WebElement getDetailViewBlock() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div[2]/div"));
    }


    @And("Click Operations drop-down")
    public void clickOperations(){
        getOperationsButton().click();
    }

    @Then("Verify Operations is expanded")
    public void verifyOperationsIsExpanded() {
            Assert.assertTrue(getOperationsField().isDisplayed());
    }

    @And("Click Shippers")
    public void clickShippers() throws InterruptedException {
        getShippersButton().click();
        Thread.sleep(2000);

    }

    @And("Verify User is landed on the Shippers page")
    public void verifyShippersOpened() {
        Assert.assertEquals(getShippersField().getText(),"Shippers");
            }

    @And("Check the checkbox for “Speedy Express“ row")
    public void checkForSpeedyExpress() throws InterruptedException {
        getCheckboxSpeedy().click();
        Thread.sleep(2000);
        }

    @Then("Verify that More button has appeared")
    public void verifyMoreButtonAppeared() {
        Assert.assertTrue(getMoreButton().isDisplayed());
    }

    @And("Uncheck the checkbox for “Speedy Express“ row")
    public void uncheckSpeedyExpress() throws InterruptedException {
        getCheckboxSpeedy().click();
        Thread.sleep(2000);
    }

    @Then("Verify that More button is no longer visible")
    public void verifyMoreButtonIsGone() {
        Assert.assertFalse(getMoreButton().isDisplayed());

    }

    @When("Verify you have label “Records 1 to 3 of 3“ under the table")
    public void verifyRecordsPage() {
        Assert.assertEquals(getRecords().getText(),"Records 1 to 3 of 3");

            }

    @Then("Click “Speedy Express“")
    public void clickSpeedyExpress() throws InterruptedException {
        getSpeedyExpress().click();
        Thread.sleep(1000);
        }

    @Then("Verify that Detail View block is visible under the table")
    public void verifyDetailViewBlockVisible() throws InterruptedException {
        Assert.assertTrue(getDetailViewBlock().isDisplayed());
        Thread.sleep(1000);
    }
}

