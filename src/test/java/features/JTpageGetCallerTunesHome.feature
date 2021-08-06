Feature: jiotunepage.getArtistCallerTuneHome, jiotunepage.getNameCallerTuneHome

  Scenario: Get Artist Caller Tune Home details on Jiotunespage
    Given I have the endpoint for "JiotunepageGetArtistCallerTuneHome"
    When I make the "GET" request with the following query parameters
    | n  | p  |
    | 20 | 1  |
    Then I validate status code with "OK"
    And Response should be validated against the parameters

  Scenario: Get Name Caller Tune Home details on Jiotunespage
    Given I have the endpoint for "JiotunepageGetNameCallerTuneHome"
    When I make the "GET" request with the following query parameters
      | n  | p  |
      | 20 | 1  |
    Then I validate status code with "OK"
    Then Response should be validated against the parameters for Name Tune Home

