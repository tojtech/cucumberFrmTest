Feature: Northwind Task

  ##@Smoke
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
    And user clicks Sales dropdown at the header
    And user then clicks Customers from that dropdown
    And user verifies Customers page is opened
    And user clicks on Customer ID Anton
    And user verifies Anton customer page is opened


#  Anton customer page is opened