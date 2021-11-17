# new feature
# Tags: optional

Feature: search.getPlaylistResults

  Scenario Outline: View All Playlist Results for the given search query
    Given Payload with endpoint search playlist results "SearchGetPlaylistResults"
    When User calls search playlist results api with the "<query>"
    Then search playlist results api must respond with status code "OK"
    And search playlist results api response must be validated

    Examples:
    | query |
    | nee |