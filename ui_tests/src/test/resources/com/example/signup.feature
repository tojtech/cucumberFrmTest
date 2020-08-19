Feature: NorthWind-Sign Up

  Scenario: Open start page
    Given I open index page
    And user clicks Sign In button on top right corner
    And user clicks at Sign Up button on top left corner
    And user fills out Sign Up form with valid data
    And user submits Sign Up button on the bottom of the form
    When user Signs In by entering valid Username and Password
    Then user expands Catalog menu on the bottom of the page
    And user opens Product Categories
    And user verifies the landed page is Product Categories page
    And user clicks at Meat/Poultry row
    And user verifies Category name and Description
    And user clicks Products button on top right corner
    And user verifies the landed page is Products page
    And user clicks at Perth Pasties row
    And user verifies Product ID is: "53"
