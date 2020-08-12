Feature: Landing

  Scenario: Open start page
    Given I open start page
    And I type search keyword "Hello world"
    Then I click search button
    And Verify Images tab has expected label: “Images”
  #String myImageButton = getSearchButton().getText();
  #myImageButton = "Images";
    Then I verify the search results page has text "Hello World - Google Search"
   # And I hit enter



