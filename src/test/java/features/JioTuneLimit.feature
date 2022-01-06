Feature: jiotune.jioTuneLimit

  Background:
    Given I login with randomly generated user credentials

  Scenario: Verify the functionality of Jio tune limite API

    Given I have the endpoint for "JioTuneLimitApi"
    When I make the "GET" request
    Then The Jio tune API returns response with status code 200


