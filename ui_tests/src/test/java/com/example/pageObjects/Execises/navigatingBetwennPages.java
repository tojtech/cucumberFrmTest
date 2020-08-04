package com.example.pageObjects.Execises;

import com.example.BasePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.example.CucumberHooks.getDriver;
import static com.example.helpers.ElementsInteraction.getWait;

/**
 * Name of the page represents the web page name.
 * It extends the BasePage abstract class that implements common logic for page loading.
 * It also forces you to add isPageOpened method that is executed on creation of page object instance (object of class)
 */
public class navigatingBetwennPages extends BasePage {
    /**
     * This method is executed whenever new object of class is created.
     * It's done by calling the method in constructor of BasePage class
     */

    public String title(){
        String title;
        return title = getDriver().getTitle();
    }
    public void isPageOpened() {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs(title()));
        System.out.println(title());
    }

    @When("i go to Login page")
    public void indexPage() throws InterruptedException {
        String LoginPage = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
        getDriver().navigate().to(LoginPage);
        String getTitle= getDriver().getTitle();
        System.out.println("The current title is:  " +getTitle);
        Thread.sleep(2000);
        getDriver().navigate().back();
        Thread.sleep(2000);
        getDriver().navigate().refresh();


    }



}
