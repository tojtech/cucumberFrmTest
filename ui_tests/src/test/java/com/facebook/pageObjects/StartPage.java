package com.facebook.pageObjects;

import com.facebook.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.facebook.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class StartPage extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Facebook - Log In or Sign Up"));
    }

//    other step definitions go here
}
