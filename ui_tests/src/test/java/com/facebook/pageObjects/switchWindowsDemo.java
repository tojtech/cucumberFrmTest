package com.facebook.pageObjects;

import com.facebook.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.util.Set;

import static com.facebook.CucumberHooks.getDriver;
import static com.facebook.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class switchWindowsDemo extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Practice | Let's Kode It"));
    }
    JavascriptExecutor js =  (JavascriptExecutor) getDriver();

    public void  sendMyKeys(By elementLocater, String text) {
        getDriver().findElement(elementLocater).sendKeys(text);
    }

    @And("click on new Window button")
    public void clickOnWindow() throws InterruptedException {

        js.executeScript("window.scrollBy(0,300);");
        Thread.sleep(2000);
        String parantWindow = getDriver().getWindowHandle();
        getDriver().findElement(By.id("openwindow")).click();

        Set<String> windows = getDriver().getWindowHandles();
        System.out.println("parant handel: "+ parantWindow);
        System.out.println("all handels" + windows);
        for (String handel : windows){
            if(!handel.equals(parantWindow)){
                getDriver().switchTo().window(handel);
                sendMyKeys(By.id("search-courses"),"Hello word");
                Thread.sleep(2000);
                getDriver().close();
                break;
            }
        }
        getDriver().switchTo().window(parantWindow);
        sendMyKeys(By.id("name"),"We did it");
        System.out.println("All done");
        Thread.sleep(2000);



    }


    @Then("scroll down to the Iframe")
    public void scrollDownToTheIframe() throws InterruptedException {
        js.executeScript("window.scrollBy(0,1200);");
        Thread.sleep(2000);
    }

    @Then("type Java in Iframe then scroll up")
    public void typeJavaInIframeThenScrollUp() throws InterruptedException {
        getDriver().switchTo().frame("courses-iframe");

        js.executeScript("window.scrollBy(0,1000);");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1000);");
//        Thread.sleep(2000);

        sendMyKeys(By.id("search-courses"),"java");
//        Thread.sleep(2000);
        getDriver().switchTo().defaultContent();
        js.executeScript("window.scrollBy(0,-1500);");
//        Thread.sleep(2000);
        getDriver().findElement(By.id("name")).clear();
        sendMyKeys(By.id("name"),"Hello Word");
        Thread.sleep(5000);
//        Thread.sleep(2000);

    }

    @And("under category choose Software ID and click on it")
    public void underCategoryChooseSoftwareIDAndClickOnIt() throws InterruptedException {
        getDriver().switchTo().frame("courses-iframe");
        getDriver().findElement(By.id("search-courses")).clear();
        Actions action = new  Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("//div[@class='row search']/div[1]/div[2]/button"));
        action.moveToElement(element).click().perform();
        getDriver().findElement(By.xpath("//div[@class='row search']/div[1]/div[2]/ul/li[4]/a")).click();
        Thread.sleep(2000);
    }
}
