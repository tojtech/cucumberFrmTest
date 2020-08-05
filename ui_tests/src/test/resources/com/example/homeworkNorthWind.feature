Feature: NorthWind

  Scenario Outline: Log In feature

    Given NorthWind index page
    And i click Sign in button
    And i type my user name with valid data and with invalid data "<username>" and "<password>"
    And i click Sign In button
    Then i sign out

    Examples:
    |username      |  password  |
    |aziz4646      |  aziz4646  |
    |aziz4647      | Abdulaziz  |
