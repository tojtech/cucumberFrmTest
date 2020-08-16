package com.example.pageObjects;

import com.example.TestsConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.example.CucumberHooks.getDriver;

public class GlobalBigProf {
    @Given("I open demo page")
    public BigProfPage iOpenDashboardPage() throws InterruptedException {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        Thread.sleep(5000);
        return new BigProfPage();
    }
    @And("I click on Close button")
    public void iClickOnCloseButton() {
    }
}
