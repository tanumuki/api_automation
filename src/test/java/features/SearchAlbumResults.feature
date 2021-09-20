# new feature
# Tags: optional

Feature: search.getAlbumResults

  Scenario Outline: Get Album results for a given search query
    Given I have the endpoint for "SearchGetAlbumResults"
    When I make the "GET" request with the following query parameters
    | q |
    |<query>|
    Then I validate status code with "OK"
    And search get album results response must be validated successfully

    Examples:
    | query |
    | Rajinikanth |