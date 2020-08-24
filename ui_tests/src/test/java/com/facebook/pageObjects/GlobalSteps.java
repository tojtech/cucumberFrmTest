package com.facebook.pageObjects;
import com.facebook.TestsConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.facebook.CucumberHooks.getDriver;

//
//
///**
// * This class contains global (common) steps that do not belong to any specific page
// * As well as all the entry points into the system (open a url)
// */
public class GlobalSteps {
    @Given("I open index page")
    public StartPage iOpenIndexPage() throws InterruptedException {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        Thread.sleep(2000);

        WebElement element = getDriver().findElement(By.xpath("//div[@class='modal-footer']/button"));
        Thread.sleep(2000);
        element.click();
        return new StartPage();

    }

    @When("sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(4000);
    }
}
//public class GlobalSteps {
//    @When("I open start page")
//    public StartPage iOpenDashboardPage() {
////        Base URL is read from config.properties file located in resources folder. Key is base.url
//        String baseUrl = TestsConfig.getConfig().getBaseUrl();
//        getDriver().get(baseUrl);
//        return new StartPage();
//    }
//
//    @When("sleep")
//    public void sleep() throws InterruptedException {
//        Thread.sleep(1000);
//    }
//
//
//    @Given("Open start page")
//    public void typeHelloWold() {
//        getDriver().get(TestsConfig.getConfig().getBaseUrl());
//
//        String baseUrl = "https://bigprof.com/demo/index.php/";
//        getDriver().get(baseUrl);
//
//    }
//}

