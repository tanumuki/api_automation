# new feature
# Tags: optional

Feature: Get Album recommendations for a given album id

  Scenario: Get Album recommendations for a given album id
    Given Payload with get album recommendations endPoint "GetAlbumRecosAPI"
    When User calls Get album recommendations api
    Then Get album recommendations must respond with status code "OK"
    And User should see the recommendations response validated