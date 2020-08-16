Feature: Google site

  Scenario: Open start page
    Given I open start page
    And I type search keyword “Hello World”
    When I hit ImLucky
    Then I verify that Search Results page is opened

