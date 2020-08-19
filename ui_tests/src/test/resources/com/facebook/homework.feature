Feature: Testing Northwind v4

  Scenario: Northwind
    Given  Go to basic URL
    And Click Catalog drop-down
    Then Verify Catalog is expanded
    And  Click Products
    Then   Verify User is landed on the Products page
    And Click “Pavlova, Ltd.“ Supplier
    Then   Verify Product ID is 17
    And  Verify that Category is “Meat/Poltry“
    And  Click “Order Items“
    Then Verify you are landed on Order Items page
    Then   Verify that for all 10 rows Product is Alice Mutton
    And Verify that for all 10 rows Category is Meat/Poultry / Pavlova, Ltd.