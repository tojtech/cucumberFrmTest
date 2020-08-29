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

public class NorthWindTest extends BasePage {

    public void isPageOpened() {
            getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
        }
    @When("is my page open")
    public void isMyPageOpen() {
            List<WebElement> searchElements = getDriver().findElements(By.cssSelector(".navbar-header"));
            Assert.assertFalse(searchElements.isEmpty());

        }
    @When("close popup")
    public void closePopup() throws InterruptedException {
        Thread.sleep(1000);
        WebElement closeButtonOnModal = getDriver().findElement(By.xpath("//div[@class='modal-footer']/button"));
        Thread.sleep(2000);
        closeButtonOnModal.click();
    }
     public WebElement signInPageElement(){
         return getDriver().findElement(By.cssSelector("a[class=\"btn btn-success navbar-btn navbar-right\"]"));
        }

    @Then("I open sign in page")
    public void iOpenSignInPage() throws InterruptedException {
            signInPageElement().click();
            Thread.sleep(2000);
        }
    @And("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String username, String password) {
         WebElement usernameElement = getDriver().findElement(By.cssSelector("#username"));
         WebElement passwordElement = getDriver().findElement(By.cssSelector("#password"));
         WebElement sigIn = getDriver().findElement(By.cssSelector("#submit"));

            usernameElement.sendKeys(username);
            passwordElement.sendKeys(password);
            sigIn.click();
        }
    }

