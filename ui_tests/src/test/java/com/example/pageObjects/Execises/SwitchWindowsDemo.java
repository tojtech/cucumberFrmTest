package com.example.pageObjects.Execises;

import com.example.BasePage;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class SwitchWindowsDemo extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Practice | Let's Kode It"));
    }



    public WebElement newWindowGetter(){
            return getDriver().findElement(By.id("openwindow"));
    }

    @And("user scrolls down And scrolls up")
    public  void scrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1500);");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1500);");
        Thread.sleep(2000);
    }

    @Then("user clicks on New Window button")
    public void userClicksOnNewWindowButton() throws InterruptedException {
        newWindowGetter().click();
        Thread.sleep(2000);
    }


    @Then("user searches for {string}")
    public void userSearchesFor(String arg0) throws InterruptedException {
        String parentW =getDriver().getWindowHandle();
        Set<String> handels = getDriver().getWindowHandles();
        System.out.println("This is all handels:   "+handels);
        for (String handel : handels){
            if(!handel.equals(parentW)){
                getDriver().switchTo().window(handel);
                getDriver().findElement(By.id("search-courses")).sendKeys("javascript masterclass");
                Thread.sleep(2000);
                getDriver().close();
                break;
            }
        }
        Thread.sleep(2000);
        getDriver().switchTo().window(parentW);
        getDriver().findElement(By.id("name")).sendKeys("Hello Word");
        Thread.sleep(2000);
    }


}


