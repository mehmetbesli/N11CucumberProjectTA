Feature: N11 sitesi için oluşturulan senaryonun testini yazma işlemi

  Scenario: we will go to the n11 website and make some operations.
    Given Navigate to the website
    And Click Login Text
    When Filling username and password
    Then Click enter button
    And Search any model mobile phone
    Then Click search button
    And Go to second page
    Then Add Favourite third product
    Then Click Sepete Ekle button
    And Add Favorite Icon
    And Move Hesabim and click Favorilerim
    Then Select product before added
    And Delete selected mobile phone
    Then Click Logout