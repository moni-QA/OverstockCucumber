Feature:Test different types of functionalities of overstock website

  Background:
    Given a user is on the overstock home page

  @NavigatePage
   Scenario: Check user can navigate page for purchase product
     And user navigate to Furniture Page
     When user click on TV Stand link
     Then user navigate to TVStand Page

  @TestVisibilityOfProductCard
    Scenario: Check the visibility of product card clearly
      And user navigate to Furniture Page
      When user click on TV Stand link
      Then user can see the card of single product

  @TestProductFiltering
    Scenario: Check user can see the  product based on filtering
      And user navigate to Furniture Page
      When user click on TV Stand link
      And user perform required steps to filtering product
      Then user can see the  product based on filtering

  @CheckShippingInformation
  Scenario: Check the shipping information
    And user click on shipping link
    Then user can see the details information of shipping

  @TestContinueSoppingOption
  Scenario: Check user can add a product to cart
    And user navigate to Cart Page
    When user click on Continue Shopping
    Then user can navigate to cart page





