Feature: Google site

  Scenario Outline: Open start page
    Given I open index page
    And user should see that Customer section title is "<title>"
    ##When My Login button is visible
    ##Then I can click that button
  Examples:
        | title     |
        | Customers |
        | 91        |