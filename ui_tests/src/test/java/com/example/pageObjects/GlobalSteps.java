package com.example.pageObjects;

import com.example.TestsConfig;
import io.cucumber.java.en.Given;

import static com.example.CucumberHooks.getDriver;

/**
 * This class contains global (common) steps that do not belong to any specific page
 * As well as all the entry points into the system (open a url)
 */
public class GlobalSteps {
    @Given("Go to basic URL")
    public HomeworkPage iOpenDashboardPage() throws InterruptedException {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        return new HomeworkPage();
    }

    /*public void isPageOpened() throws InterruptedException {
//        Add verifications implemented using WebDriverWait that would be checking if the page is actually opened
        getWait().until(ExpectedConditions.titleIs("Northwind | Homepage"));
    }*/


}
