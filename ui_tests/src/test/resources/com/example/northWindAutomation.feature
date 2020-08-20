Feature: NorthWind

  Scenario: Automating Northwind web page test cases
    Given I open NorthWind page
    When sleep and close popup
    Then I go through sign up process
    When longer sleep
    Then logging in to the site
    And I verify user is logged in
    And Verify that description of Orders section contains required text
    And I click to Orders
    And Verify User is on Orders page
    And I scroll down and click NEXT button at bottom right corner
    And I Click Order ID
    And I verify particular order page has been opened
    And Is status is Shipped
    And I click Back button on that order page
    Then I verify you’re landed back to Orders page