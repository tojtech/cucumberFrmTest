package com.example.pageObjects;

import com.example.BasePage;

import com.example.helpers.ElementsInteraction;
import io.cucumber.java.en.And;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import javax.swing.*;


import java.util.List;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.assertElementText;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class LoginClass extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Practice | Let's Kode It"));
    }

    @And("I type Hello Word on enter name TextBox")
    public void typeText() throws InterruptedException {
//        ElementsInteraction.sendKeys(By.id("name"), "Hello Word");
        Thread.sleep(2000);

    }

    @And("I check bmw")
    public void checkBoxChecked() throws InterruptedException {
        checkBMW();
        Thread.sleep(3000);
        System.out.println("We checked the checkBox");
        Action action = (Action) getDriver();

    }


    public void  checkBMW(){
          ElementsInteraction.click(By.id("bmwcheck"));
    }

    public Boolean isCheckBoxPresent(){
//        assertElementText();
       return getDriver().findElement(By.id("bmwcheck")).isDisplayed();
    }


    public  void listElements(){
      List<WebElement> listElement =  getDriver().findElements(By.cssSelector("Example"));

        Assert.assertFalse(listElement.isEmpty());
    }
//driver.findeleme (By,name("A")).sendKey ("A"+Keys.

}
