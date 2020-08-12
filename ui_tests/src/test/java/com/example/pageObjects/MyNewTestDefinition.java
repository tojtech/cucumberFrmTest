package com.example.pageObjects;

import com.example.BasePage;
import com.example.TestsConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;
import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;


 public class MyNewTestDefinition extends BasePage {

    public void isPageOpened() {
            getWait().until(ExpectedConditions.titleIs("Google"));
    }
     @Given("I open chrome page")
     public MyNewTestDefinition iOpenDashboardPage() {
         String baseUrl = TestsConfig.getConfig().getBaseUrl();
         getDriver().get(baseUrl);
         return new MyNewTestDefinition();
     }
        @And("I type in search Hello World And Hit Enter")
        public void iTypeInSearchHelloWorld() {
        String typing = "Hello World";
        WebElement Searchlocation = gettingSearchField();
        Searchlocation.sendKeys(typing + Keys.ENTER);
        }

        public WebElement gettingSearchField(){
            return getDriver().findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        }

        @Then("Scroll down")
    public void scrollDown() {
        WebElement element = getDriver().findElement(By.cssSelector("div.r>a[href=\"https://en.wikipedia.org/wiki/%22Hello,_World!%22_program\"]"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

        }

        @When("is my search field visible")
    public void isMySearchFieldVisible() {
        List<WebElement> searchElements = getDriver().findElements(By.xpath("//a[@class='Fx4vi']"));
        Assert.assertFalse(((java.util.List) searchElements).isEmpty());
        }

        @Then("I click to github link to link")
    public void iClickToGithubLinkToLink() {
        WebElement link = getDriver().findElement(By.cssSelector("div.r>a[href=\"https://guides.github.com/activities/hello-world/\"]"));
        link.click();

             }

             @When("is GitHub page open")
    public void isGitHubPageOpen() {
        List<WebElement> searchElements = getDriver().findElements(By.cssSelector("a[href=\"https://www.youtube.com/githubguides\"]"));
        Assert.assertFalse(((java.util.List) searchElements).isEmpty());
    }
}
