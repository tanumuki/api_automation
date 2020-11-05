# new feature
# Tags: optional

Feature: Get Album recommendations for a given album id

  Scenario Outline: Get Album recommendations for a given album id
    Given Payload with get album recommendations endPoint "GetAlbumRecoAPI"
    When User calls Get album recommendations api for the "<albumid>"
    Then Get album recommendations must respond with status code "OK"
    And User should see the recommendations response validated

    Examples:
    | albumid |
    | 23216490  |