Feature: NorthWind

  Scenario: Open start page
    Given I open index page
    And user clicks Sign In button on top left corner
    And user clicks at Sign Up button on top left corner
    And user enters valid username: "rossabd"
    And user enters valid password: "Tashkent1!"
    And user confirms password: "Tashkent1!"
    And user enters valid email: "hamroz.abduhoshimov@gmail.com"
    And user enters valid Full Name: "Ross Abdu"
    And user enters valid Address: "9500 Mall Road"
    And user enters valid City: "Morgantown"
    And user enters valid State: "West Virginia"
#    And user should see that Customer section title is "<title>"
#    And user clicks at Customers section