# new feature
# Tags: optional

Feature: search.getMoreResults

  Scenario Outline: View all results for the given query and entity type
    Given I have the endpoint for "SearchGetMoreResults"
    When I make the "GET" request with the following query parameters
    | query | params |
    | <query> | <params>|
    Then I validate status code with "OK"
    And get more results api response must be validated successfully

    Examples:
    | query | params  |
#    | A | albums  |
#    | A | playlists  |
#    | A | songs  |
#    | A | channels  |
    | A | podcasts  |
#    | A | artists  |