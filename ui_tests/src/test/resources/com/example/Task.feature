Feature: EmployeesPage

  Scenario: Employee step test
    Given I open start page
    And Click “Operations” tab
    When Click Employees
    Then Employees page is opened
    And Go to last page using pagination drop-down
    Then verify there are four rows are available
    #And Verify label “Records 6 to 9 of 9” at the bottom of the table
    #And Click “Previous” button
    #And Verify, that 5 previous rows are displayed
    #And Click “Northwind” icon
    #And Verify “Sales” tab is expanded