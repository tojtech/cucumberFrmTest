package com.example.pageObjects.Execises;

import com.example.BasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;




import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class Action_MouseHover extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Practice | Let's Kode It"));
    }

    public WebElement mouseHoverGetter(){
        return  getDriver().findElement(By.id("mousehover"));
    }

    public WebElement subElementTopGetter() {
     return getDriver().findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
    }


    @And("scroll down")
    public void scrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1010);");
        Thread.sleep(2000);

        Actions action =new Actions(getDriver());
        action.moveToElement(mouseHoverGetter()).perform();
        Thread.sleep(2000);

        action.moveToElement(subElementTopGetter()).click().perform();
        Thread.sleep(2000);

        getDriver().close();
    }



}
