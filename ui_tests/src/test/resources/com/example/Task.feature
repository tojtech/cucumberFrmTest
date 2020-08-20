 Feature: SpeedyExpress

    Scenario: Open start page
       Given I open start page
       And Click Operations drop-down
       Then Verify Operations is expanded
       And Click Shippers
       And Verify User is landed on the Shippers page
       And Check the checkbox for “Speedy Express“ row
       Then Verify that More button has appeared
       And Uncheck the checkbox for “Speedy Express“ row
       Then Verify that More button is no longer visible
       When Verify you have label “Records 1 to 3 of 3“ under the table
       Then Click “Speedy Express“
       Then Verify that Detail View block is visible under the table
