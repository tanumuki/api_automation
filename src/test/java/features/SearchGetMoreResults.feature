# new feature
# Tags: optional

Feature: View all results for the given query and entity type

  Scenario Outline: View all results for the given query and entity type
#    Given Payload with endpoint get more results "SearchGetMoreResults"
    Given I have the endpoint for "SearchGetMoreResults"
#    When User calls get more results api with "<query>" and "<type>"
    When I make the "GET" request with the following query parameters
    | query | params |
    | <queries> | <param>|
    Then I validate status code with "OK"
    And get more results api response must be validated successfully

    Examples:
    | queries | param  |
#    | A | albums  |
#    | A | playlists  |
#    | A | songs  |
#    | A | channels  |
    | A | podcasts  |
#    | A | artists  |