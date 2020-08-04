package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class NorthWind2 extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    public WebElement orderGetter(){
        return getDriver().findElement(By.xpath("//*[@id=\"orders-tile\"]/div/div/a"));
    }

        @And("^User will see order \"([^\"]*)\"$")
        public void userShouldSeeThisNameOnCustomerSection(String expected) {
         Assert.assertEquals(orderGetter().getText(), expected, "We Printing" + orderGetter().getText());
        }


}





