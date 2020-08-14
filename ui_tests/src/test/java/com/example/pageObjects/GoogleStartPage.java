package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */

public class GoogleStartPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened()   {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Google"));
    }
    public WebElement getSearchTextFieldElement() {
        return getDriver().findElement(By.xpath("//input[@name='q']"));
    }

    public WebElement getSearchButton() {
        return getDriver().findElement(By.cssSelector(".FPdoLc [value='Google Search']"));
    }
    
   public WebElement getRandomClick () {
        return getDriver().findElement(By.xpath("//body/div/div/span/center/div[1]"));
   }

    @And("I type search keyword \"Hello world\"")
    public void iTypeIntoSearchField()  {
        String text = "Hello world";
        WebElement element = getSearchTextFieldElement();
        element.sendKeys(text);

    }
    @Then("I click search button")
    public void clickSearchButton() throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait((WebDriver) getSearchButton(), 10);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div/div/form[@name='f']/div/div/div/center/input[1]"))).click();
       // Thread.sleep(3000);
       getRandomClick().click();
        //Thread.sleep(2000);
        getSearchButton().click();
    }
    @And("Verify Images tab has expected label: “Images”")
    public void verifyImagesTabHasExpectedLabelImages() {
        List<WebElement> imageElementsList = getDriver().findElements(By.xpath("//a[contains(text(),'Images')]"));
        Assert.assertFalse(imageElementsList.isEmpty());
    }

    @Then("^I verify the search results page has text \"([^\"]*)\"")
    public void   iVerifyTheSearchResultsPageIsOpened(String expectedTitle) throws InterruptedException {
        Thread.sleep(3000);
       //Assert.assertEquals(getTitleOfPage().getText().contains(expectedTitle), "I cant find it");
        //Assert.assertTrue(getDriver().getTitle().contains(expectedTitle), "Hello world - Google Search","I cant find it");
        Assert.assertTrue(getDriver().getTitle().contains(expectedTitle), "search");
        Thread.sleep(2000);
    }
}


    //getTitle().equals("<title>Hello World - Google Search</title>");


    //}
    // public WebElement getTitle () {
    //  getWait().until(ExpectedConditions.titleIs("Hello world - Google Search");
    //  return getTitle();
    //title[contains(text(),'Hello world - Google Search')]

    // }




//    other step definitions go here
//}
