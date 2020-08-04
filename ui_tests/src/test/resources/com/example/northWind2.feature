Feature:  NorthWind2

  Scenario Outline: Checking orders
    Given NorthWind index page
    And  User will see order "<title>"

    Examples:

    | title     |
    | orders    |
    | 98        |