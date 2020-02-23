Feature: N11 sitesi için oluşturulan senaryonun testini yazma işlemi

  Scenario: We will go to the n11 website and make some operations.
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


  Scenario: We will go to the IETT website and make some different operations.
    When Navigate to IETT website
    Then Search Line Stop name and select from popup
    Then Get Information about line
    And Click All Information
    Then Select Stops through
    And Click Third Stop
    And Get instand stop information
    Then Select Buses passing through the station
    And Go to Line About and get info about it
    Then Click IETT Icon
    Then Click Nasıl Giderim Menu