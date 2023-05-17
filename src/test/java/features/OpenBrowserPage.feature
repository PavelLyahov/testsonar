@UIConfiguration
Feature: OpenBrowserPage

  Background: Configuring Database and creditals
    Given 'https://userinyerface.com' address is opened

    @OpenBrowserPage
  Scenario: CurrentBids
    When I click next
    Then Game Page Is Open
