package com.example.pageObjects;

import com.example.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
public class NorthWind extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */



    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }

    public WebElement customersElement(){
        return  getDriver().findElement(By.xpath(" //*[@id=\"customers-tile\"]/div/div/a/strong"));
    }

//    @And("^user should see customers title \"([^\"]*)\"$")
//    public void titleGetting(String expected){
//        Assert.assertEquals(customersElement().getText(),expected,"Heloow");
//
//    }


}
