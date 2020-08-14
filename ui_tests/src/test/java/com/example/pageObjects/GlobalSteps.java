package com.example.pageObjects;

import com.example.TestsConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.example.CucumberHooks.getDriver;

/**
 * This class contains global (common) steps that do not belong to any specific page
 * As well as all the entry points into the system (open a url)
 */
public class GlobalSteps {
    @When("I open start page")
    public SpiceJetStartPage iOpenDashboardPage() {
//        Base URL is read from config.properties file located in resources folder. Key is base.url
        String baseUrl = TestsConfig.getConfig().getBaseUrl();
        getDriver().get(baseUrl);
        return new SpiceJetStartPage();
    }

    @When("sleep")
    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }

    @When("I type Youtube in Search bar")
    public void iTypeYoutubeInSearchBar() {
    }

    @Then("I see the result")
    public void iSeeTheResult() {
    }

    @And("I type search keyword {string}")
    public void iTypeSearchKeyword(String arg0) {
        
    }

    @When("I hit Enter")
    public void iHitEnter() {
        
    }

    @Then("i verify the Search results page is opened")
    public void iVerifyTheSearchResultsPageIsOpened() {
        
    }

    @And("I type search keyword Youtube")
    public void iTypeSearchKeywordYoutube() {
        
    }

    @And("I type search keyword Youtube in search bar")
    public void iTypeSearchKeywordYoutubeInSearchBar() {
    }
}
