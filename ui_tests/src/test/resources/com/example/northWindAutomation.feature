Feature: NorthWind

  Scenario: Automating Northwind web page test cases
    Given I open NorthWind page
    When sleep and close popup
    Then I go through sign up process
    When sleep
    Then logging in to the site

