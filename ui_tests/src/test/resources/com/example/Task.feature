Feature: EmployeesPage
@Regression
  Scenario: Employee step test
    Given I open start page
    And click “Operations” tab
    When click Employees
    Then Employees page is opened
    And go to last page using pagination drop-down
    Then verify there are four rows are available
    And verify label Records at the bottom of the table
    And click “Previous” button
    And verify, that 5 previous rows are displayed
    And click “NorthWind” icon
    And verify “Sales” tab is expanded
  #will be updated