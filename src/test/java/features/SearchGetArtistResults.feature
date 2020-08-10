# new feature
# Tags: optional

Feature: Search get artist results

  Scenario Outline: Search and gets the artist results for the given query
    Given Payload with get artist results endpoint "SearchGetArtistResults"
    When User calls the get artists results api with "<query>"
    Then Get artist results api must respond with status code "OK"
    And Get artist results api response must be validated successfully

    Examples:
    |     query     |
    | Arijit Singh  |