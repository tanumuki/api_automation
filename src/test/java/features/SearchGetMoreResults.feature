# new feature
# Tags: optional

Feature: search.getMoreResults

  Scenario Outline: View all results for the given query and entity type
    Given Payload with endpoint get more results "SearchGetMoreResults"
    When User calls get more results api with "<query>" and "<type>"
    Then get more results api should respond with status code "OK"
    And get more results api response must be validated successfully

    Examples:
    | query | type  |
#    | A | albums  |
#    | A | playlists  |
#    | A | songs  |
#    | A | channels  |
    | A | podcasts  |
#    | A | artists  |