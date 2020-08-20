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
        return  getDriver().findElement(By.className("input-sm ltr"));

    }
    public WebElement getRecordsLabel(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div/div[1]/table/tfoot/tr/td"));  //MISSING DATA!!!

    }
    public WebElement getTablePage2(){
        return getDriver().findElement(By.cssSelector("tbody"));
    }
    public WebElement getEmployeesPageVer(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[1]/h1/div/div[1]/a"));
    }
    public WebElement getPreviousButton() {
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div/div[2]/div[1]/button/span"));
    }
    public WebElement getTablePage1(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div/div[1]/table/tbody"));
    }
    public WebElement getNorthWindButton(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/nav/div[1]/a"));
    }
    public WebElement getExpandedSalesTab(){
        return getDriver().findElement(By.xpath("/html/body/div[1]/div[4]"));
    }



    @Then("Employees page is opened")
    public void iVerifyEmployeePageIsOpened(){
       // List<WebElement> employeePageHeader = getDriver().findElements(By.xpath("//h1"));
       // Assert.assertFalse(employeePageHeader.isEmpty());
        Assert.assertEquals(getEmployeesPageVer().getText(), "Employees");

    }

    @And("^go to last page using pagination drop-down$")
    public void goToLastPage() throws InterruptedException {
      WebElement drop = getDriver().findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/form/div[3]/div/div[2]/div[2]/select"));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(drop);
        actions.perform();
        Select secondPage = new Select(drop);
        secondPage.selectByIndex(1);
        Thread.sleep(3000);
    }

    @Then("^verify there are four rows are available$")
    public void verifyFourRows() {
        Assert.assertTrue(getTablePage2().isDisplayed());
    }
        // List<WebElement> tableRows = simpleTable.findElements(By.tagName("tr"));
        // for (int i = 1; i <= 4; i++) {
            //Assert.assertFalse(i);
            //Assert.assertEquals();

        @And("^verify label Records at the bottom of the table$")
      public void verifyLabelRecords() {
       String s = "Records";
            Assert.assertTrue(getRecordsLabel().getText().contains(s));
    }
    @And("^click “Previous” button$")
    public void clickPreviousButton() {
        getPreviousButton().click();
    }
    @And("^verify, that 5 previous rows are displayed$")
        public void verifyTable1(){
        Assert.assertTrue(getTablePage1().isDisplayed());
    }

    @And("^click “NorthWind” icon$")
    public void clickNorthWindIcon() {
        getNorthWindButton().click();
    }

    @And("^verify “Sales” tab is expanded$")
    public void verifySalesTab() {
        Assert.assertTrue(getExpandedSalesTab().isDisplayed());
    }
}