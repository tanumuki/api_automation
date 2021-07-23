Feature: jiotunepage.getNameCallerTuneHome

  Scenario: Get Artist Caller Tune Home details on Jiotunespage
    Given I have the endpoint for "JiotunepageGetNameCallerTuneHome"
    When I make the "GET" request with the following query parameters
    | n  | p  |
    | 20 | 1  |
    Then I validate status code with "OK"
    Then I validate the response of the API
