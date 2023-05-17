@UI
@UIConfiguration
Feature: AddCreditCard

  Scenario: AddCreditCard
    And I create a new card with the fallowing parameters 'without' saving on Payment Options page:
      | cardNumber         | expireDate |
      | 4242 4242 4242 424 |            |
    Then 'Card number' field has 'incorrect' data on Payment Options form
