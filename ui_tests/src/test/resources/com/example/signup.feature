Feature: NorthWind-Sign Up

  Scenario: Open start page
    Given I open index page
    And user clicks Sign In button on top right corner
    And user clicks at Sign Up button on top left corner
    And user fills out Sign Up form with valid data
    When user submits Sign Up button on the bottom of the form
    Then user should be navigated to Sign In page
#    And user should see that Customer section title is "<title>"
#    And user clicks at Customers section