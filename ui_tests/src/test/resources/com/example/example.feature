Feature: Google site

  @Regression
  Scenario Outline: Open start page
    Given I open index page
    And user should see that Customer section title is "<title>"
    And user clicks at Customers section
    And user clicks SignIn button on Customers Page
  Examples:
        | title     |
        | Customers |
        | 91        |