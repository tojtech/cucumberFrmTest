package com.example.pageObjects.Execises;

import com.example.BasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class iFrameDemo extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Practice | Let's Kode It"));
    }


    @And("Switching iFrame")
    public void switchiFrame() throws InterruptedException {
        getDriver().switchTo().frame("courses-iframe");
        getDriver().findElement(By.id("search-courses")).sendKeys("Hello Word");
        Thread.sleep(2000);
        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.id("displayed-text")).sendKeys("IIIIIIII");
        Thread.sleep(2000);
    }

}


