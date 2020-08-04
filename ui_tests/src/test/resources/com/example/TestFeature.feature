Feature: Lets Kode it

  Scenario: Prictice page
    Given   I open index page
    And I type Hello Word on enter name TextBox
    And I check bmw
    #Then i Shoud see bmw is Checked text typed

  Scenario:  Login Page with invalid data
    Given  Login Page opend
    And I type Login
    And I type Password
    Then i should see fail

