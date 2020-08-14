Feature: Landing

  Scenario: Open start page
    Given I open start page
    And I click Sign In button
    Then go to Sign In page and confirm the page has "Sign In Here" header and click Sign Up button
    And enter User Name in user name field: "test123"
    And enter password  in Password field: "123456LOL"
    And confirm password in Confirm Password field: "123456LOL"
    And enter email in Email Address field: "testemail@test.com"
    And enter Full Name in Full Name field: "Fluff Puff"
    And enter address in Address field: "Nobody cares where you live"
    And enter city in City field: "NYC"
    And enter state in State field: "NY"
    #Then I click Sign Up and transferred to a new window