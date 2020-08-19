package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */

public class EmployeesPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Employees"));
    }
    public WebElement getGoToPageDropDown(){
        getDriver().findElement(By.className("input-sm ltr"));
        return getGoToPageDropDown();
    }

    @Then("Employees page is opened")
    public void iVerifyEmployeePageIsOpened(){
        List<WebElement> employeePageHeader = getDriver().findElements(By.xpath("//h1"));
        Assert.assertFalse(employeePageHeader.isEmpty());

    }


    @And("Go to last page using pagination drop-down")
    public void goToLastPageUsingPaginationDropDown() throws InterruptedException {
        //JavascriptExecutor js = (JavascriptExecutor)getDriver();
      WebElement drop = getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div/div[2]/div[2]/select"));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(drop);
        actions.perform();
        Select secondPage = new Select(drop);
        secondPage.selectByIndex(1);
        Thread.sleep(3000);
    }

    @Then("verify there are four rows are available")
    public void verifyThereAreRowsAreAvailable() {
        WebElement simpleTable = getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div/div[1]/table"));
        List<WebElement> tableRows = simpleTable.findElements(By.tagName("tr"));
        for (WebElement row:tableRows){
            System.out.println("THIS MANY ROWS:"+ row);
        }
        //Assert.assertEquals();


    }
}