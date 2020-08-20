Feature: Northwind Task

  Scenario: Open start page
    Given I open index page
    And user clicks Sign In button on the top right corner
    And user clicks at Sign Up button on the top right corner
    And user fills out Sign Up form
    And user clicks Sign Up button on bottom of page
    And user verifies he is logged in
    And verify description of Orders contains "Orders placed by customers, with newest orders listed first."
    And user clicks on Orders button
    And user verifies Orders page is opened