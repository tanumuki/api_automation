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
    Then Response should be validated against the parameters for Name Tune Home or Artist Tune

#    Same structure of response for NameCallerTuneHome and ArtistCallerTune, hence, just made some changes to generalize the functions
  Scenario: Get Artist Caller Tune details on Jiotunespage for given artistID
    Given I have the endpoint for "JiotunepageGetArtistCallerTune"
    When I make the "GET" request with the following query parameters
      | n  | p  | id     |
      | 20 | 1  | 459696 |
    Then I validate status code with "OK"
    And  Response should be validated against the parameters for Name Tune Home or Artist Tune