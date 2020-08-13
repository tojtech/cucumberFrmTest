package com.example.pageObjects;

import com.example.TestsConfig;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.example.CucumberHooks.getDriver;

/**
 * This class contains global (common) steps that do not belong to any specific page
 * As well as all the entry points into the system (open a url)
 */
public class GlobalSteps {

    @Given("I open index page")
    public BigprofIndexPage iOpenIndexPage() throws InterruptedException {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        sleep(1000);
        WebElement closeButtonOnModal = getDriver().findElement(By.xpath("//div[@class='modal-footer']/button"));
        sleep(2000);
        closeButtonOnModal.click();
        return new BigprofIndexPage();
    }

    @When("sleep")
    public static void sleep(long time) throws InterruptedException {
        Thread.sleep(time);
    }

   // "//*[@id='orders-tile']/div/div/div[1]/a[1]/strong" - relative

    //"/html/body/div[1]/div[4]/div[1]/div[2]/div/div/div[1]/a[1]/strong" - absolute
}
