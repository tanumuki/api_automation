# new feature
# Tags: optional

Feature: Get all the featured playlists

  Scenario: Get All the featured playlists
    Given Payload with get all contents endPoint "GetFeaturedPlaylistAPI"
    When User calls Get All contents api
    Then Get All contents must respond with status code "OK"
    And User should successfully validate the Get All contents response