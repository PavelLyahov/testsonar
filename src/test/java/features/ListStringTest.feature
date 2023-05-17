@UIConfiguration
Feature: ListStringTest

  Background: Configuring Database and creditals
    Given 'https://userinyerface.com' address is opened

  @ListStringTest
  Scenario: ListStringTest
    Then The following fields are not filled in:
      | Email Address      |
      | Salutation         |
      | First Name         |
      | Last Name          |
      | Address            |
      | Apartment/Suite    |