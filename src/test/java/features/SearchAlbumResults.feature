# new feature
# Tags: optional

Feature: search.getAlbumResults

  Scenario Outline: Get Album results for a given search query
    Given Payload with endpoint search get album results "SearchGetAlbumResults"
    When User calls search get album results api with "<query>"
    Then search get album results api must respond with status code "OK"
    And search get album results response must be validated successfully

    Examples:
    | query |
    | Rajinikanth |