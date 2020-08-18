Feature: North Wind
  Scenario: check print preview page
    Given  open index page
    And check first row
    And I verify More button is visible
     And i click More button
    When  i click print preview button
    Then user should see print preview page
