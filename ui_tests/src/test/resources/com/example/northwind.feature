Feature: Northwind

  Scenario: Homework
    Given Go to basic URL
    And user should click on close button on pop up
    And I click on Sign in button  where i should be navigated to Sign in page
    And I click on Sign up button on the top right corner
    Then Go through sign up process
    And Login to the site
    And i verify User is logged in
    And i verify that description of Orders section contains “Orders placed by customers, with newest orders listed first.“ text
    And Click Orders
    And Verify User is on Orders page
    And i click SALES dropdown at the header and click Customers from that dropdown
    And Verify Customers page is opened
    And Click at Customer ID “ANTON“ Verify that particular Customer page is opened













