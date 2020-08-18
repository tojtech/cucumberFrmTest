Feature: Northwind

  Scenario: Test sign in button
    Given I open start page
    And pop up message displays on the page that i should close
    And I click on Sign in button  where i should be navigated to Sign in page
    Then I type my username in username bar using invalid username
    And i type my password in password bar using invalid password
    Then i click on Remember me checkbox
    And i click on sign in button
    Then i should see error message displayed on the page
    And after seeing error message i click on Sign Up button

