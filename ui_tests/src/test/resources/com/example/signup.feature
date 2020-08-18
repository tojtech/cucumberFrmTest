Feature: NorthWind

  Scenario: Open start page
    Given I open index page
    And user clicks Sign In button on top left corner
    And user clicks at Sign Up button on top left corner
    And user enters valid username: "test"
    And user enters valid password: "Test1!"
    And user confirms password: "Test1!"
    And user enters valid email: "test@gmail.com"
    And user enters valid Full Name: "Test Test"
    And user enters valid Address: "Somewhere"
    And user enters valid City: "Morgantown"
    And user enters valid State: "West Virginia"
#    And user should see that Customer section title is "<title>"
#    And user clicks at Customers section