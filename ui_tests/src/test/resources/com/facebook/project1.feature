Feature: Northwind

  @Regression @12345
  Scenario: Open start page
    Given I open index page
    And Go through sign up process
    And Login to the site
    And Click AppGini Homepage
    And Verify Gini project is opened
    And Go back to Northwind Homepage
    And Click “Change theme” at the bottom
    And Verify “Change the theme of this demo“ modal is appeared
    And Select “Cosmo“ theme
    And Click Apply button
    And Click “More info“ button
    And Verify “About this demo“ modal is opened