package com.facebook.helpers;

import com.facebook.selenium.SeleniumConfig;
import com.facebook.selenium.WaitForAjaxCalls;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.facebook.CucumberHooks.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Select element from active search results.
 */
public final class ElementsInteraction {
    private static final int TIMEOUT = SeleniumConfig.getConfig().getPageLoadingRetriesCount();

    private ElementsInteraction() {
    }

    public static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), TIMEOUT);
    }

    public static void click(By elementLocator) {
        getWait().until(elementToBeClickable(elementLocator)).click();
    }

    public static void sendKeys(By inputElementLocator, String text) {
        getWait().until(visibilityOfElementLocated(inputElementLocator)).sendKeys(text);
        new WaitForAjaxCalls(getDriver()).checkPendingRequests();
        assertElementValue(inputElementLocator, text);
    }

    public static void assertElementText(By elementLocator, String text) {
        getWait().ignoring(StaleElementReferenceException.class)
                .until(textToBe(elementLocator, text));
    }

    public static void assertElementValue(By elementLocator, String text) {
        getWait().ignoring(StaleElementReferenceException.class)
                .until(textToBePresentInElementValue(elementLocator, text));
    }

    public static By getLocator(String elementLocatorTemplate, String... dynamicLocatorParts) {
        return By.xpath(String.format(elementLocatorTemplate, dynamicLocatorParts));
    }

    public static String generatingRandomAlphabeticString() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);

        System.out.println(generatedString);

        return generatedString;
    }
}


