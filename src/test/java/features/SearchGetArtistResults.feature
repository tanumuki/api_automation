# new feature
# Tags: optional

Feature: search.getArtistResults

  Scenario Outline: Search and gets the artist results for the given query
    Given I have the endpoint for "SearchGetArtistResults"
    When I make the "GET" request with the following query parameters
      |q|
      |<queries>|
    Then I validate status code with "OK"
    And Get artist results api response must be validated successfully

    Examples:
    |     queries    |
    | Arijit Singh  |
    |Selena Gomez   |