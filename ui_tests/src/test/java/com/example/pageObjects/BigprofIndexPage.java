package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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
public class BigprofIndexPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    public WebElement getTitleOfCustomersSection(){
        return getDriver().findElement(By.xpath("//a[@href='customers_view.php']"));
    }

    @And("^user should see that Customer section title is \"([^\"]*)\"$")
    public void isCustomerSectionTitleCorrect(String expectedTitle){
        Assert.assertTrue(getTitleOfCustomersSection().getText().contains(expectedTitle),
                "User should see expected Title, but instead " + getTitleOfCustomersSection().getText() + " is visible");
    }


    public WebElement getLoginTextfield(){
       return getDriver().findElement(By.cssSelector("div.A8SBwf>div>center>input.TF2"));
    }

    public WebElement getPasswordTextfield(){
        return getDriver().findElement(By.cssSelector("div.A8SBwf>div>center>div.TF1"));
    }

    public WebElement getLoginButton(){
        return getDriver().findElement(By.cssSelector("div.A8SBwf>div>center>button.myButton"));
    }

    @When("^user login to site using Username as \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void passLoginAndPassword(String username, String password){
        // some
    }

    @Then("I can click that button")
    public void clickLoginButton(){
        getLoginButton().click();
        String myActualLable = getLoginButton().getText();
    }

    @When("My Login button is visible")
    public void isLoginButtonPresent() {
        List<WebElement> loginElementsList = getDriver().findElements(By.cssSelector(".LoginBTN"));

        Assert.assertFalse(loginElementsList.isEmpty());
    }

    //public void clickSearchButton(){
     //   getSearchButton().click();
    //}

//    other step definitions go here
}
