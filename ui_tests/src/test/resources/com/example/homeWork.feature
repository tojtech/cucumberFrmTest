Feature: Northwind

  Scenario: Firdavs

    Given  Go to basic URL
    And Go through sign up process
    And Login to the site
    When Verify User is logged in
    And Click AppGini homepage
    Then I verify User is on AppGini homepage
    And Click Back button of browser
    And Verify User is back to Northwind homepage
    Then I click Customers
    And Verify User is landed on Customers page
    And  Click at Customer Id BLONP
    Then  Verify User is on Customers page with Deatil View block, and Customer Id there is BLONP respectively