@UIConfiguration
Feature: Get object

  @GetObject
  Scenario: Get object
    And Get object:
      | firstName | lastName | email                | password   |
      | John      | Johnson  | qa158@mailinator.com | ********** |
