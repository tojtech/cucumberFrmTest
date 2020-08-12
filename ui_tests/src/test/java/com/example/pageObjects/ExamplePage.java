package com.example.pageObjects;

import com.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class ExamplePage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Google"));
    }

    public void isPageScrolledDown() {
        getWait().until(ExpectedConditions.jsReturnsValue(""));
    }

    public void isNorthWindPageOpen() {
        getWait().until(ExpectedConditions.titleIs("Hide me!"));

    }
    public void isGoogleLinkOpen(){
        getWait().until(ExpectedConditions.titleIs("\n" +
                "    \n" +
                "      Hello World · GitHub Guides\n" +
                "    \n" +
                "  "));
    }
}
