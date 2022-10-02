Feature: Test Search Functionalities Of Overstock Website

  @PositiveTest
    Scenario:Check relevant product for the search term is displayed for a particular search term
    Given a user is on the overstock home page to purchase some items
    When user enters "Mattresses" into the search bar
    And click on search button
    Then search history should be displayed

  @NegativeTest
  Scenario:Check irrelevant product for the search term is not displayed for a particular search term
    Given a user is on the overstock home page to purchase some items
    When user enters "Matres" into the search bar
    And click on search button
    Then search history should not be displayed


