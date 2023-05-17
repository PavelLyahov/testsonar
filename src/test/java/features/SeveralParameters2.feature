@UIConfiguration
Feature: SeveralParameters

  @SeveralParameters
  Scenario Outline: Test error validation for the use input "<Field>" - max characters validation (not signed-in user)
    Given 'https://userinyerface.com' address is opened
    When I click next
    Then Game Page Is Open
    And Edit Profile form is configured as follows:
      | firstName | lastName | email                | password   | country                  | address           | city   | state         | postalCode | phoneNumber  |
      | John      | Johnson  | qa158@mailinator.com | ********** | United States of America | 38 Everett Street | Boston | Massachusetts | 02134      | 617-555-1200 |

