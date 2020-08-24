package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;
import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;


public  class NorthWindAutomation extends BasePage{
    public void isPageOpened()  {
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    @Then("I go through sign up process")
    public void iGoThroughSignUpProcess() throws InterruptedException {
        initialPagesignInElement().click();
        initialPageSingUpElement().click();
            Thread.sleep(2000);

        WebElement usernameDrElement = userNameField();
            usernameDrElement.sendKeys(usernameText());
        WebElement passWorDrElement = passwordField();
            passWorDrElement.sendKeys(passwordText());
        WebElement confirmPassword = confirmPasswordField();
            confirmPassword.sendKeys("12345a");
        WebElement emailDrElement = emailField();
            emailDrElement.sendKeys("info1@mail.com");
        WebElement fullNameDrElement = fullNameField();
           fullNameDrElement.sendKeys("oops");
        WebElement addressDrElement = addressField();
           addressDrElement.sendKeys("100 E 10th st");
        WebElement cityDrElement = cityField();
           cityDrElement.sendKeys("Nyc");
        WebElement stateDrElement=stateField();
            stateDrElement.sendKeys("NY");
        JavascriptExecutor scrollingDown = (JavascriptExecutor) getDriver();
             scrollingDown.executeScript("window.scrollBy(0,1500);");
        WebElement signUpButtonAfterFillingTheForm = signUpButton();
            signUpButtonAfterFillingTheForm.click();
    }
    public String usernameText(){
        //Change username for each run
         String textToTypeInUserName = "admin5029";
         return textToTypeInUserName;
    }
    public String passwordText(){
        String elementsToTypeInPassword ="12345a";
        return elementsToTypeInPassword;
    }
    public WebElement initialPagesignInElement(){
        return getDriver().findElement(By.cssSelector(".navbar-collapse > a"));
    }
    public WebElement initialPageSingUpElement(){
        return getDriver().findElement(By.cssSelector("div.panel-heading > a")); }
    public WebElement userNameField(){
        return getDriver().findElement(By.cssSelector("input[id='username']"));
    }
    public WebElement passwordField(){
        return getDriver().findElement(By.cssSelector("input[id=password]"));
    }
    public WebElement confirmPasswordField(){
        return getDriver().findElement(By.cssSelector("input[id=confirmPassword]")); }
    public WebElement emailField(){
        return getDriver().findElement(By.cssSelector("input[id=email]"));
    }
    public WebElement fullNameField() {
        return getDriver().findElement(By.cssSelector("input[id=custom1]"));
    }
    public WebElement addressField() {
        return getDriver().findElement(By.cssSelector("input[id=custom2]"));
    }
    public WebElement cityField() {
        return getDriver().findElement(By.cssSelector("input[id=custom3]"));
    }
    public WebElement stateField(){
        return getDriver().findElement(By.cssSelector("input[id=custom4]"));
    }
    public WebElement signUpButton(){
        return getDriver().findElement(By.cssSelector("button[id='submit']"));
    }
    public WebElement userNameFieldToSignIn(){
        return getDriver().findElement(By.cssSelector("input[id=username]"));
    }
    public WebElement passwordFieldToSignIn(){
        return getDriver().findElement(By.cssSelector("input[id=password]"));
    }
    public WebElement loggingInSignUpButton(){
        return getDriver().findElement(By.cssSelector("button[id='submit']"));
    }
    public WebElement OrderButtonInInitialPage(){
        return getDriver().findElement(By.cssSelector("#orders-tile > div > div > div.btn-group > a:nth-child(1)"));
    }

    @When("sleep and close popup")
    public void sleepClosePopup() throws InterruptedException {
            Thread.sleep(1000);
        WebElement closeButtonOnModal = getDriver().findElement(By.xpath("//div[@class='modal-footer']/button"));
            Thread.sleep(2000);
        closeButtonOnModal.click();
    }

    @Then("logging in to the site")
    public void loggingInToTheSite() {
        WebElement usernameFieldDr=userNameFieldToSignIn();
            usernameFieldDr.sendKeys(usernameText());
        WebElement passwordFieldDr=passwordFieldToSignIn();
            passwordFieldDr.sendKeys(passwordText());
        loggingInSignUpButton().click();
    }

    @When("longer sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(4000);
    }

    @And("I verify user is logged in")
    public void iVerifyUserIsLoggedIn() {
        String actualResult = getDriver().findElement(By.cssSelector("ul.nav.navbar-nav.navbar-right.hidden-xs > p > strong > a")).getText();
        Assert.assertTrue(actualResult.contains(usernameText()));
    }

    @And("Verify that description of Orders section contains required text")
    public void verifyThatDescriptionOfOrdersSectionContainsRequiredText() {
        WebElement fieldToVerify = getDriver().findElement(By.cssSelector("a[title='The customers table contains a list of imaginary customers of the Northwind company. You can also access the imaginary orders made by each customer here.']"));
        Assert.assertTrue(fieldToVerify.isDisplayed());
    }

    @And("I click to Orders")
    public void iClickToOrders() throws InterruptedException {
        OrderButtonInInitialPage().click();
            Thread.sleep(2000);
    }

    @And("Verify User is on Orders page")
    public void verifyUserIsOnOrdersPage() {
        getWait().until(ExpectedConditions.titleIs("Northwind | Orders"));
    }

    @And("I scroll down and click NEXT button at bottom right corner")
    public void iClickNEXTButtonAtBottomRightCorner() {
        JavascriptExecutor scrollDown = (JavascriptExecutor) getDriver();
            scrollDown.executeScript("window.scrollBy(0,1500);");
        WebElement nextButton=getDriver().findElement(By.cssSelector("#Next"));
            nextButton.click();
    }

    @And("I Click Order ID")
    public void iClickOrderID() {
        WebElement id11067Field = getDriver().findElement(By.cssSelector("#orders-OrderID-11067>a"));
            id11067Field.click();
    }

    @And("I verify particular Order page has been opened")
    public void iVerifyParticularOrderPageHasBeenOpened() {
        List<WebElement> isId11067Opened = getDriver().findElements(By.cssSelector("a[style='text-decoration: none; color: inherit;']"));
        Assert.assertFalse((isId11067Opened).isEmpty());
    }

    @And("Is status is Shipped")
    public void isStatusIsShipped() {
        String shipField = getDriver().findElement(By.cssSelector("#status > span")).getText();
        Assert.assertTrue(shipField.contains("Shipped"));
    }

    @And("I click Back button on that order page")
    public void iClickBackButtonOnThatOrderPage() {
        WebElement backButtonField = getDriver().findElement(By.cssSelector("button[id='deselect']"));
            backButtonField.click();
    }

    @Then("I verify if user landed back to Orders page")
    public void iVerifyYouReLandedBackToOrdersPage() {
        List<WebElement> backToOrderPage = getDriver().findElements(By.cssSelector("a[style='text-decoration: none; color: inherit;']"));
        Assert.assertFalse(( backToOrderPage).isEmpty());
    }
}



