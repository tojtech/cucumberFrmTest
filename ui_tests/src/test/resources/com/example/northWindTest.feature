Feature: NorthWind
@Regression
  Scenario Outline: New test scenario
    Given I open NorthWind page
    When close popup
    When is my page open
    Then I open sign in page
    And I enter "<username>" and "<password>"
  Examples:
      | username | | password |
      | admin    | | qwerty   |
      | user     | | 12345ww  |
      | tester   | | qwerty11 |


