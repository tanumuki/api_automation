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
#    | A | {"type":"albums"}  |
#    | A | {"type":"playlists"}  |
#    | A | {"type":"songs"}  |
#    | A | {"type":"channels"}  |
    | A | {"type":"podcasts"}  |
#    | A | {"type":"artists"}  |