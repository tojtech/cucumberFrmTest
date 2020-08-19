#Feature: NorthWind
#
#  Scenario Outline: Open start page
#    Given I open index page
#    And user should see that Customer section title is "<title>"
#    And user clicks at Customers section
#  Examples:
#        | title     |
#        | Customers |
#        | 91        |