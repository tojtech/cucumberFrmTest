package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;



public class NorthWind extends BasePage {

    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    public WebElement getSignInButton() {
        return getDriver().findElement(By.xpath("//a[contains(text(),'Sign In')]"));
    }

    public WebElement getSignUpButton() {

        return getDriver().findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
    }

    public WebElement getUsernameField() {
        return getDriver().findElement(By.xpath("//input[@name='newUsername']"));
    }

    public WebElement getPasswordField() {

        return getDriver().findElement(By.xpath("//input[@name='password']"));
    }

    public WebElement getConfirmPasswordField() {
        return getDriver().findElement(By.xpath("//input[@name='confirmPassword']"));
    }

    public WebElement getEmailAddressField() {

        return getDriver().findElement(By.xpath("//input[@name='email']"));
    }

    public WebElement getFullNameField() {
        return getDriver().findElement(By.xpath("//input[@placeholder='Full Name']"));
    }

    public WebElement getAddressField() {

        return getDriver().findElement(By.xpath("//input[@name='custom2']"));
    }

    public WebElement getCityField() {

        return getDriver().findElement(By.xpath("//input[@name='custom3']"));
    }

    public WebElement getStateField() {
        return getDriver().findElement(By.xpath("//input[@name='custom4']"));
    }

    public WebElement getSingUpFinalButton() {
        return getDriver().findElement(By.xpath("//button[@name='signUp']"));
    }

    @And("I click Sign In button")
    public void clickSignInButton()  {
        getSignInButton().click();
    }

    @And("click “Operations” tab")
    public void clickOperationTab() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[contains(text(),'Operations')]")).click();
    }

    @When("click Employees")
    public EmployeesPage clickEmployeeButton() {
        getDriver().findElement(By.xpath("//strong[contains(text(),'Employees')]")).click();
        return new EmployeesPage();
    }


    @Then("go to Sign In page and confirm the page has \"Sign In Here\" header and click Sign Up button")
    public void goToSignInPageAndConfirmTheSignInPageIsOpened() {
        List<WebElement> signInHere = getDriver().findElements(By.xpath("//strong[contains(text(),'Sign In Here')]"));
        Assert.assertFalse(signInHere.isEmpty());
        getSignUpButton().click();
    }

    @And("^enter User Name in user name field: \"([^\"]*)\"$")
    public void enterUserName(String userName) throws InterruptedException {
        getUsernameField().sendKeys(userName);
        Thread.sleep(2000);
    }

    @And("^enter password  in Password field: \"([^\"]*)\"$")
    public void enterPassword(String password) throws InterruptedException {
        getPasswordField().sendKeys(password);
        Thread.sleep(2000);
    }

    @And("^confirm password in Confirm Password field: \"([^\"]*)\"$")
    public void confirmPassword(String password) throws InterruptedException {
        getConfirmPasswordField().sendKeys(password);
        Thread.sleep(2000);
    }

    @And("^enter email in Email Address field: \"([^\"]*)\"$")
    public void enterValidInEmailAddressField(String email) throws InterruptedException {
        getEmailAddressField().sendKeys(email);
        Thread.sleep(2000);
    }

    @And("^enter Full Name in Full Name field: \"([^\"]*)\"$")
    public void enterInFullNameField(String fullName) throws InterruptedException {
        getFullNameField().sendKeys(fullName);
        Thread.sleep(2000);
    }

    @And("^enter address in Address field: \"([^\"]*)\"$")
    public void enterInAddressField(String address) throws InterruptedException {
        getAddressField().sendKeys(address);
        Thread.sleep(2000);
    }

    @And("^enter city in City field: \"([^\"]*)\"$")
    public void enterInCityField(String city) throws InterruptedException {
        getCityField().sendKeys(city);
        Thread.sleep(2000);
    }

    @And("^enter state in State field: \"([^\"]*)\"$")
    public void enterInStateField(String state) throws InterruptedException {
        getStateField().sendKeys(state);
        Thread.sleep(2000);
    }

}