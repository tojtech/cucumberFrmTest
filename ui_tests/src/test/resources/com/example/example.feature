Feature: Google Site

  Scenario: Open start page
    Given I open start page
    And I type search keyword Youtube in search bar
    When I hit Enter
    Then i verify the Search results page is opened
    ##And I type search keyword "Hello World"
    ##When I hit Enter
    ##Then i verify the Search results page is opened


