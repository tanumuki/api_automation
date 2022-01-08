# new feature
# Tags: optional

Feature: search.getPlaylistResults

  Scenario Outline: View All Playlist Results for the given search query
    Given I have the endpoint for "SearchGetPlaylistResults"
    When I make the "GET" request with the following query parameters
      | q |
      |<query>|
    Then I validate status code with "OK"
    And search playlist results api response must be validated

    Examples:
    | query |
    | nee |
    | saa |